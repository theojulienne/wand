package wand.nodes;

import wand.generators.GeneratorFactory;

public class NodeFactory {
	private static NodeFactory nodeFactory = new NodeFactory();
	
	public static void setNodeFactory( NodeFactory factory ) {
		nodeFactory = factory;
	}
	
	public static NodeFactory getNodeFactory( ) { 
		return nodeFactory;
	}
	
	
	public ProgramNode createProgramNode( ) {
		return new ProgramNode( );
	}
	
	public FunctionNode createFunctionNode( ) {
		return new FunctionNode( );
	}
}
