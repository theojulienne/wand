package wand.backends.c;

import wand.generators.Generator;
import wand.core.WandNode;
import wand.parser.*;
import wand.generators.ChildGenerator;

import java.io.PrintStream;

public class CStatementGenerator implements Generator {
	public void generateNode( WandNode node, PrintStream out ) {
	    ASTStatement expr = (ASTStatement)node;
	    
	    ChildGenerator.generateChildren( node, out );
	    out.println( ";" );
	}
}
