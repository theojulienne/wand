package wand;

import wand.generators.GeneratorFactory;
import wand.parser.*;

public class TreeTest {
	public static void main( String[] args ) {
		//NodeFactory nodeFactory = NodeFactory.getNodeFactory(  );
		
		GeneratorFactory.setGeneratorFactory( new wand.backends.c.CGeneratorFactory( ) );
		
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
		
		program.generateToStream( System.out );
		
		/*
		ProgramNode node = nodeFactory.createProgramNode( );
		node.addDeclaration( nodeFactory.createFunctionNode( ) );
		
		node.generateToStream( System.out );*/
	}
}
