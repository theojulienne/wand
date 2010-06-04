package wand.backends.c;

import wand.generators.*;
import wand.core.WandNode;
import wand.parser.*;

import java.io.PrintStream;
import java.util.ArrayList;

public class CProgramGenerator implements ProgramGenerator {
	public void generateNode( WandNode node, PrintStream out ) {
		out.println( "// program!" );
		ChildGenerator.generateChildren( node, out );
		out.println( "// end program!" );
	}
}
