package wand.nodes;

import java.util.ArrayList;
import java.io.PrintStream;

import wand.generators.Generator;

public abstract class TreeNode {
	protected ArrayList<TreeNode> childNodes = new ArrayList<TreeNode>();
	protected TreeNode parent;
	
	public ArrayList<TreeNode> getChildNodes( ) {
		return childNodes;
	}
	
	public TreeNode assignToParent( TreeNode parent ) {
		this.parent = parent;
		return this;
	}
	
	public abstract Generator getGenerator( );
	
	public void generateToStream( PrintStream out ) {
		this.getGenerator( ).generateNode( this, out );
	}
}
