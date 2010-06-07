// begin function foo
int foo( int n ) {
	int bar = ( 42 + ( 2 * 10 ) );
	int bar2 = ( ( 42 * n ) + 10 );
	bar = 3;
	{
		int foo = 123;
		bar = 789;
	}
}
// end function foo
