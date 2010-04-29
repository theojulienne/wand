package wand.nodes;

import wand.generators.*;

public class ProgramNode extends TreeNode {
	protected ProgramNode( ) {
		
	}
	
	public void addDeclaration( DeclarationNode node ) {
		childNodes.add( node.assignToParent( this ) );
	}
	
	public Generator getGenerator( ) {
		return GeneratorFactory.getGeneratorFactory( ).getProgramGenerator( );
	}
}
