package wand.backends.c;

import wand.generators.FunctionGenerator;
import wand.nodes.*;

import java.io.PrintStream;

public class CFunctionGenerator implements FunctionGenerator {
	public void generateNode( TreeNode node, PrintStream out ) {
		out.println( "function!" );
	}
}
