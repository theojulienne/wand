package wand.backends.c;

import wand.generators.Generator;
import wand.core.WandNode;
import wand.parser.*;

import java.io.PrintStream;

public class CIdentifierGenerator implements Generator {
	public void generateNode( WandNode node, PrintStream out ) {
	    ASTIdentifier id = (ASTIdentifier)node;
	    
	    out.print( id.getIdentifier( ) );
	}
}
