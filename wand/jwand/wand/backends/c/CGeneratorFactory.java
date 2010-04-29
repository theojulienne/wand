package wand.backends.c;

import wand.generators.*;
import wand.nodes.*;

public class CGeneratorFactory extends GeneratorFactory {
	public Generator generatorForType( Class type ) {
		Generator generator = null;
		
		if ( FunctionNode.class.isAssignableFrom( type ) ) {
			generator = new CFunctionGenerator( );
		} else if ( ProgramNode.class.isAssignableFrom( type ) ) {
			generator = new CProgramGenerator( );
		}
		
		return generator;
	}
}