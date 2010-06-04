import os

from terminal import TerminalController
term = TerminalController()

PASS_STATS = {}

def run_test( test_type, path, files ):
	# test is in format code-result eg "core-pass"
	version_code, expected_result = test_type.split( '-' )
	
	return False # not implemented

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
	
