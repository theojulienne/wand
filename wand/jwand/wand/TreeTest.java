package wand;

import wand.nodes.*;
import wand.generators.GeneratorFactory;

public class TreeTest {
	public static void main( String[] args ) {
		NodeFactory nodeFactory = NodeFactory.getNodeFactory(  );
		
		GeneratorFactory.setGeneratorFactory( new wand.backends.c.CGeneratorFactory( ) );
		
		ProgramNode node = nodeFactory.createProgramNode( );
		node.addDeclaration( nodeFactory.createFunctionNode( ) );
		
		GeneratorFactory.generateNode( node, System.out );
		
		System.out.println( "Hello, World!" );
	}
}
