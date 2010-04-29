package wand.generators;

import wand.nodes.TreeNode;
import java.io.PrintStream;

public interface Generator {
	public void generateNode( TreeNode node, PrintStream out );
}
