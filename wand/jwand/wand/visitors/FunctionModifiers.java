package wand.visitors;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class FunctionModifiers extends WandVisitor {
    public FunctionModifiers( ) {
        
    }
    
    public Object visit(ASTDecoratedFunctionDeclaration node, Object data) {
        ASTFunctionDeclaration function = (ASTFunctionDeclaration) node.getFunction( );
        ASTModifiers modifiers = (ASTModifiers) node.getModifiers( );
        
        function.setFunctionModifiers( modifiers );
        
        WandNode parent = node.getParent( );
        parent.replaceChild( node, function );
        
        return data;
    }
}
