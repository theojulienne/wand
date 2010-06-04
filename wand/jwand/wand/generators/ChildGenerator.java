package wand.generators;

import wand.core.WandNode;
import wand.parser.*;

import java.io.PrintStream;

public class ChildGenerator implements Generator {
    public static void generateChildren( WandNode node, PrintStream out ) {
        int numChildren = node.jjtGetNumChildren( );
		
		for ( int i = 0; i < numChildren; i++ ) {
			WandNode childNode = (WandNode)node.jjtGetChild(i);
			
			if ( childNode != node ) {
			    childNode.generateToStream( out );
			}
		}
    }
    
    public void generateNode( WandNode node, PrintStream out ) {
		generateChildren( node, out );
	}
}
