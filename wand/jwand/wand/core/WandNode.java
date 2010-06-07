package wand.core;

import wand.parser.Node;
import wand.generators.Generator;
import wand.generators.ChildGenerator;
import java.io.PrintStream;

public abstract class WandNode implements Node {
    public Generator getGenerator( ) {
        return new ChildGenerator( );
    }
    
    public void generateToStream( PrintStream out ) {
        Generator generator = getGenerator( );
        
        assert generator != null: "Node '" + this + "' provided no code generator!";
        
        generator.generateNode( this, out );
    }
    
    public void accept( WandVisitor visitor, Object data ) {
        jjtAccept( visitor, data );
    }
    
    public void replaceChild( WandNode oldChild, WandNode newChild ) {
        int numChildren = jjtGetNumChildren( );
        
        for ( int i = 0; i < numChildren; i++ ) {
            if ( jjtGetChild( i ) == oldChild ) {
                jjtAddChild( newChild, i );
                return;
            }
        }
        
        assert false: "Child not found in node.";
    }
    
    public WandNode getParent( ) {
        return (WandNode)jjtGetParent( );
    }
}