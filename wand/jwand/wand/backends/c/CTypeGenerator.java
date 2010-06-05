package wand.backends.c;

import wand.generators.Generator;
import wand.core.WandNode;
import wand.parser.*;
import wand.generators.ChildGenerator;

import java.io.PrintStream;

public class CTypeGenerator implements Generator {
	public void generateNode( WandNode node, PrintStream out ) {
	    ASTType type = (ASTType)node;
	    
	    out.print( type.getTypeName( ) );
	}
}
