package wand.nodes;

import java.util.ArrayList;

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
}
