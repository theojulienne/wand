package wand.backends.c;

import wand.generators.Generator;
import wand.core.WandNode;
import wand.parser.*;

import java.io.PrintStream;

public class CAssignmentGenerator implements Generator {
	public void generateNode( WandNode node, PrintStream out ) {
	    ASTAssignExpression expr = (ASTAssignExpression)node;
	    
	    ASTIdentifier target = expr.getTarget( );
	    ASTAssignOperator operator = expr.getOperator( );
	    ASTExpression value = expr.getValueExpression( );
	    
	    String op = "error";
	    
	    int operatorType = operator.getTokenType( );
	    if ( operatorType == WandParserConstants.OPASSIGN ) {
	        op = "=";
	    } else {
	        assert false : "Invalid operator for backend.";
	    }
	    
	    out.print( "    (" );
	    target.generateToStream( out );
	    out.print( ") " );
	    
	    out.print( op );
	    
	    out.print( " (" );
	    value.generateToStream( out );
	    out.print( ")" );
	}
}
