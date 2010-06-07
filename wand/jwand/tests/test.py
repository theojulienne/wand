import os, subprocess

from terminal import TerminalController
term = TerminalController()

WAND_COMPILER = '../bin/wandc'

PASS_STATS = {}

def wand_compile( src_file ):
	cmd = [WAND_COMPILER, '-c', src_file]
	
	proc = subprocess.Popen( cmd, 
		stdin=subprocess.PIPE,
		stdout=subprocess.PIPE,
		stderr=subprocess.STDOUT )
	output = proc.communicate()[0]
	
	assert proc.returncode is not None
	
	exception = False
	
	if proc.returncode != 0:
		print output
		
		if 'Exception in thread' in output:
			exception = True
	
	return (proc.returncode == 0), exception

def run_executable( command ):
	proc = subprocess.Popen( command, 
		stdin=subprocess.PIPE,
		stdout=subprocess.PIPE,
		stderr=subprocess.STDOUT )
	output = proc.communicate()[0]
	
	assert proc.returncode is not None
	
	if proc.returncode != 0:
		print command, 'returned', proc.returncode
		print output
	
	return (proc.returncode == 0)

def gcc_files( sources, binary ):
	cmd = ['gcc'] + sources + ['-o', binary]
	return run_executable( cmd )

def cleanup( created_files ):
	for f in created_files:
		try:
			os.unlink( f )
		except:
			pass

def run_test( test_type, path, files ):
	# test is in format code-result eg "core-pass"
	version_code, expected_result = test_type.split( '-' )
	
	wand_files = list( path+'/'+f for f in files if f.endswith('.wand') )
	c_files = list( f for f in files if f.endswith('.c') )
	
	gen_c_files = list( f.replace('.wand','.c') for f in wand_files )
	
	TARGET_FILENAME = path + '/test'
	created_files = gen_c_files + [ TARGET_FILENAME ]
	
	all_compiled = True
	exception_thrown = False
	
	for wand_file in wand_files:
		exit_success, exception_thrown_child = wand_compile( wand_file )
		all_compiled = all_compiled and exit_success
		exception_thrown = exception_thrown or exception_thrown_child
	
	expect_graceful = test_type.endswith( '-graceful' )
	
	if expect_graceful:
		# FIXME: this needs to check the return code was not a 
		# crash (graceful compile error only)
		cleanup( created_files )
		return (not all_compiled) and (not exception_thrown)
	
	# now we know we're expecting a real pass,
	# we can make sure wandc compiled successfully
	if not all_compiled:
		cleanup( created_files )
		return False
	
	# now we have a .c file, compile it (and other files)
	# with gcc
	if not gcc_files( gen_c_files + c_files, TARGET_FILENAME ):
		cleanup( created_files )
		return False
	
	result = run_executable( TARGET_FILENAME )
	cleanup( created_files )
	
	return result
	
	

def run_tests( ):
	for root, dirs, files in os.walk( '.' ):
		# don't visit subversion directories
		if '.svn' in dirs:
			dirs.remove( '.svn' )
		
		# split up the root into directory components
		components = root.split( '/' )
		
		# remove the leading "." entry
		components = components[1:]
		
		# ignore any directories except those with exactly
		# the required components (type+feature+name)
		if len(components) != 3:
			continue
		
		test_type, test_feature, test_name = components
		
		result = run_test( test_type, root, files )
		
		description = '[????]'
		stats_code = 'unknown'
		
		if result:
			description = term.GREEN + '[PASS]' + term.NORMAL
			stats_code = 'pass'
		else:
			description = term.RED + '[FAIL]' + term.NORMAL
			stats_code = 'fail'
		
		print ' %s  type=%-15s feature=%-15s name=%-15s' % \
				(description, test_type, test_feature, test_name)
		
		if test_type not in PASS_STATS:
			PASS_STATS[test_type] = {
				'pass': 0,
				'fail': 0,
				'total': 0
			}
		
		PASS_STATS[test_type]['total'] += 1
		PASS_STATS[test_type][stats_code] += 1
		

if __name__ == '__main__':
	print 'Running Wand tests...'
	print
	
	run_tests( )
	
	print
	print 'Results:'
	for test_type in PASS_STATS:
		stats = PASS_STATS[test_type]
		num_tests = stats['total']
		num_passed = stats['pass']
		num_failed = stats['fail']
		perc_passed = num_passed * 100.0 / num_tests
		perc_failed = num_failed * 100.0 / num_tests
		
		print ('%15s (%3d tests): ' + \
			term.GREEN + '%3d passed (%3d%%)' + term.NORMAL + \
			'   ' + \
			term.RED + '%3d failed (%3d%%)' + term.NORMAL + 
			'') % \
			(test_type, num_tests, num_passed, perc_passed, num_failed, perc_failed)
	
