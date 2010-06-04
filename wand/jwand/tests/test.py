import os

from terminal import TerminalController
term = TerminalController()

def run_test( test_type, path, files ):
	# test is in format code-result eg "core-pass"
	version_code, expected_result = test_type.split( '-' )

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
		
		if result:
			description = term.GREEN + '[PASS]' + term.NORMAL
		else:
			description = term.RED + '[FAIL]' + term.NORMAL
		
		print ' %s  type=%-15s feature=%-15s name=%-15s' % \
				(description, test_type, test_feature, test_name)

if __name__ == '__main__':
	print 'Running Wand tests...'
	run_tests( )
	print 'All tests passed. You are AWESOME!'
