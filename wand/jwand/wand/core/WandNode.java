package wand.core;

import wand.parser.Node;
import wand.generators.Generator;
import java.io.PrintStream;

public abstract class WandNode implements Node {
    public Generator getGenerator( ) {
        return null;
    }
    
    public void generateToStream( PrintStream out ) {
        getGenerator( ).generateNode( this, out );
    }
}