package wand.backends.c;

import wand.generators.FunctionGenerator;
import wand.core.WandNode;
import wand.parser.*;

import java.io.PrintStream;

public class CFunctionGenerator implements FunctionGenerator {
	public void generateNode( WandNode node, PrintStream out ) {
	    ASTFunctionDeclaration declaration = (ASTFunctionDeclaration)node;
	    
		out.println( "void " + declaration.getFunctionName() + " () {" );
		
		out.println( "}" );
	}
}
