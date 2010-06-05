package wand.backends.c;

import wand.generators.FunctionGenerator;
import wand.core.WandNode;
import wand.parser.*;

import java.io.PrintStream;

public class CFunctionGenerator implements FunctionGenerator {
	public void generateNode( WandNode node, PrintStream out ) {
	    ASTFunctionDeclaration declaration = (ASTFunctionDeclaration)node;
	    
	    ASTType type = (ASTType)declaration.getReturnType();
	    
		out.print( type.getTypeName() + " " + declaration.getFunctionName() + " ()" );
		
		ASTBlock block = declaration.getFunctionBody( );
		if ( block == null ) {
		    out.println( ";" );
		} else {
		    out.println( " {" );
		    block.generateToStream( out );
		    out.println( "}" );
		}
		/*
		int numChildren = node.jjtGetNumChildren( );
		for ( int i = 0; i < numChildren; i++ ) {
		    SimpleNode child = (SimpleNode)node.jjtGetChild(i);
		    out.println( "  // " + child.toString() );
		    //child.dump( "  // --  " );
		}
		*/
		
		
	}
}
