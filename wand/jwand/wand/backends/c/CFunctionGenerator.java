package wand.backends.c;

import wand.generators.FunctionGenerator;
import wand.core.WandNode;

import java.io.PrintStream;

public class CFunctionGenerator implements FunctionGenerator {
	public void generateNode( WandNode node, PrintStream out ) {
		out.println( "function!" );
	}
}
