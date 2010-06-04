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
        getGenerator( ).generateNode( this, out );
    }
}