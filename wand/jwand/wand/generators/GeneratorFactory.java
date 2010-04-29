package wand.generators;

import wand.nodes.TreeNode;

import java.io.PrintStream;

public abstract class GeneratorFactory {
	private static GeneratorFactory generatorFactory;
	
	public static void setGeneratorFactory( GeneratorFactory factory ) {
		generatorFactory = factory;
	}
	
	public static GeneratorFactory getGeneratorFactory( ) {
		return generatorFactory;
	}
	
	public static void generateNode( TreeNode node, PrintStream out ) {
		Generator generator = generatorFactory.generatorForType( node.getClass() );
		generator.generateNode( node, out );
	}
	
	public abstract Generator generatorForType( Class type );
}
