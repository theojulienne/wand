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
	
	
	
	public abstract FunctionGenerator getFunctionGenerator( );
	public abstract ProgramGenerator getProgramGenerator( );
}
