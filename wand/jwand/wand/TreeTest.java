package wand;

import wand.generators.GeneratorFactory;
import wand.parser.*;

public class TreeTest {
    // from: http://java.sun.com/j2se/1.4.2/docs/guide/lang/assert.html
    static {
        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (!assertsEnabled)
            throw new RuntimeException("Asserts must be enabled!!!");
    }
    
	public static void main( String[] args ) {
		//NodeFactory nodeFactory = NodeFactory.getNodeFactory(  );
		
		//GeneratorFactory.setGeneratorFactory( new wand.backends.c.CGeneratorFactory( ) );
		
		WandParser parser = new WandParser( System.in );
		ASTProgram program = null;
		
		try {
		    program = parser.Program( );
		} catch (ParseException e) {
		    System.out.println( e.getMessage() );
		    e.printStackTrace( );
		    System.exit( 1 );
		}
		
		System.out.println( program );
		
		//program.generateToStream( System.out );
		
		wand.visitors.VariableMapper vmap = new wand.visitors.VariableMapper( );
		vmap.visitFrom( program, null );
		
		wand.backends.c.CCodeGenerator codegen = new wand.backends.c.CCodeGenerator( );
		codegen.setOutputStream( System.out );
		codegen.generate( program );
		
		
		/*
		ProgramNode node = nodeFactory.createProgramNode( );
		node.addDeclaration( nodeFactory.createFunctionNode( ) );
		
		node.generateToStream( System.out );*/
	}
}
