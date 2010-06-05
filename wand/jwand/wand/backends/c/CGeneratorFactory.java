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
	
	public Generator getAssignmentGenerator( ) {
	    return new CAssignmentGenerator( );
	}
	
	public Generator getIdentifierGenerator( ) {
	    return new CIdentifierGenerator( );
	}
	
	public Generator getStatementGenerator( ) {
	    return new CStatementGenerator( );
	}
	
	public Generator getLocalDeclarationGenerator( ) {
	    return new CLocalDeclarationGenerator( );
	}
	
	public Generator getTypeGenerator( ) {
	    return new CTypeGenerator( );
	}
}