package wand.generators;

import wand.core.WandNode;

import java.io.PrintStream;

public interface Generator {
	public void generateNode( WandNode node, PrintStream out );
}
