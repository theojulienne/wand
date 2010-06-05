package wand.generators;

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
	public abstract Generator getAssignmentGenerator( );
	public abstract Generator getIdentifierGenerator( );
	public abstract Generator getStatementGenerator( );
	public abstract Generator getLocalDeclarationGenerator( );
	public abstract Generator getTypeGenerator( );
}
