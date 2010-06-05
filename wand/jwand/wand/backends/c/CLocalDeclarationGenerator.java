package wand.backends.c;

import wand.generators.Generator;
import wand.core.WandNode;
import wand.parser.*;
import wand.generators.ChildGenerator;

import java.io.PrintStream;

public class CLocalDeclarationGenerator implements Generator {
	public void generateNode( WandNode node, PrintStream out ) {
	    ASTLocalVariableDeclarationStatement local = (ASTLocalVariableDeclarationStatement)node;
	    
	    ASTType type = (ASTType)local.getType( );
	    
	    out.print( "    " + type.getTypeName() + " " );
	    for ( int i = 1; i < node.jjtGetNumChildren(); i++ ) {
	        WandNode child = (WandNode)node.jjtGetChild(i);
	        
	        if ( i > 1 ) {
	            out.print( ", " );
	        }
	        
	        child.generateToStream( out );
	    }
	    out.println( ";" );
	}
}
