package wand.nodes;

public class ProgramNode extends TreeNode {
	protected ProgramNode( ) {
		
	}
	
	public void addDeclaration( DeclarationNode node ) {
		childNodes.add( node.assignToParent( this ) );
	}
}
