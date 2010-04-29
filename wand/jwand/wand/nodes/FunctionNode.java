package wand.nodes;

import wand.generators.*;

public class FunctionNode extends DeclarationNode {
	public Generator getGenerator( ) {
		return GeneratorFactory.getGeneratorFactory( ).getFunctionGenerator( );
	}
}
