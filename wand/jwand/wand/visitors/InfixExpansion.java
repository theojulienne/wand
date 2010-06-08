package wand.visitors;

import java.util.Stack;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class InfixExpansion extends WandVisitor {
    private Stack<WandNode> exprStack = null;
    
    public InfixExpansion( ) {
        exprStack = new Stack<WandNode>( );
    }
    
    public Object visit(ASTInfixExpression node, Object data) {
        exprStack.clear();
        
        for ( WandNode child: node ) {
            exprStack.push( child );
            
            if ( exprStack.size() == 3 ) {
                ASTInfixExpression newExpr = new ASTInfixExpression(WandParserTreeConstants.JJTINFIXEXPRESSION);
                
                WandNode rhs = exprStack.pop( );
                WandNode op  = exprStack.pop( );
                WandNode lhs = exprStack.pop( );
                
                newExpr.jjtAddChild( lhs, 0 );
                newExpr.jjtAddChild( op,  1 );
                newExpr.jjtAddChild( rhs, 2 );
                
                lhs.jjtSetParent( newExpr );
                op.jjtSetParent( newExpr );
                rhs.jjtSetParent( newExpr );
                
                exprStack.push( newExpr );
            }
        }
        
        assert exprStack.size() == 1;
        
        WandNode newNode = exprStack.pop( );
        
        WandNode parent = node.getParent( );
        parent.replaceChild( node, newNode );
        
        return data;
    }
}
