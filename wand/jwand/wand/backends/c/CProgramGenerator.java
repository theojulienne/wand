package wand.backends.c;

import wand.generators.*;
import wand.core.WandNode;
import wand.parser.*;

import java.io.PrintStream;
import java.util.ArrayList;

public class CProgramGenerator implements ProgramGenerator {
	public void generateNode( WandNode node, PrintStream out ) {
		int numChildren = node.jjtGetNumChildren( );
		
		out.println( "// program!" );
		for ( int i = 0; i < numChildren; i++ ) {
			ASTDeclarations childNode = (ASTDeclarations)node.jjtGetChild(i);
			
			childNode.generateToStream( out );
		}
		out.println( "// end program!" );
	}
}
