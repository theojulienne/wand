package wand.backends.c;

import wand.generators.*;
import wand.core.WandNode;

public class CGeneratorFactory extends GeneratorFactory {
	public FunctionGenerator getFunctionGenerator( ) {
		return new CFunctionGenerator( );
	}
	
	public ProgramGenerator getProgramGenerator( ) {
		return new CProgramGenerator( );
	}
}