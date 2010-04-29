package wand.backends.c;

import wand.generators.*;
import wand.nodes.*;

import java.io.PrintStream;
import java.util.ArrayList;

public class CProgramGenerator implements ProgramGenerator {
	public void generateNode( TreeNode node, PrintStream out ) {
		ArrayList<TreeNode> childNodes = node.getChildNodes( );
		
		out.println( "// program!" );
		for ( int i = 0; i < childNodes.size(); i++ ) {
			DeclarationNode childNode = (DeclarationNode)childNodes.get(i);
			
			GeneratorFactory.generateNode( childNode, out );
		}
		out.println( "// end program!" );
	}
}
