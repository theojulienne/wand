package wand.generators;

import wand.core.WandNode;
import wand.parser.*;

import java.io.PrintStream;

public class ChildGenerator implements Generator {
    public static void generateChildren( WandNode node, PrintStream out, int startNode ) {
        int numChildren = node.jjtGetNumChildren( );
		
		for ( int i = startNode; i < numChildren; i++ ) {
			WandNode childNode = (WandNode)node.jjtGetChild(i);
			
			if ( childNode != node ) {
			    childNode.generateToStream( out );
			}
		}
    }
    
    public static void generateChildren( WandNode node, PrintStream out ) {
        generateChildren( node, out, 0 );
    }
    
    public void generateNode( WandNode node, PrintStream out ) {
		generateChildren( node, out );
	}
}
