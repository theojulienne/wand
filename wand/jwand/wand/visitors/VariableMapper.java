package wand.visitors;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class VariableMapper extends WandVisitor {
    private Scope currentScope = null;
    
    private boolean inDeclaration = false;
    
    public VariableMapper( ) {
        pushScope( );
    }
    
    private void pushScope( ) {
        currentScope = new Scope( currentScope );
    }
    
    private void popScope( ) {
        currentScope = currentScope.getParentScope( );
    }
    
    public Object visit( ASTBlockStatement node, Object data ) {
        pushScope( );
        visitChildren( node, data );
        popScope( );
        
        return data;
    }
    
    public Object visit( ASTLocalVariableDeclarationStatement node, Object data ) {
        visitChildren( node, data );
        return data;
    }
    
    public Object visit( ASTVariableDeclarator node, Object data ) {
        int currChild = 0;
        for ( WandNode child: node ) {
            // first child is a declaration ASTIdentifier
            inDeclaration = (currChild == 0);
            child.accept( this, data );
            inDeclaration = false;
            
            currChild++;
        }
        
        return data;
    }
    
    public Object visit( ASTFunctionParameters node, Object data ) {
        inDeclaration = true;
        visitChildren( node, data );
        inDeclaration = false;
        return data;
    }
    
    public Object visit( ASTFunctionDeclaration node, Object data ) {
        pushScope( );
        visitChildren( node, data );
        popScope( );
        return data;
    }
    
    public Object visit( ASTIdentifier node, Object data ) {
        String name = node.getIdentifier( );
        
        WandNode variable = null;
        
        if ( inDeclaration ) {
            // declaring this variable
            //System.out.println( "declaring " + name );
            
            variable = new WandVariable( name );
            
            if ( currentScope.definedLocally( name ) ) {
                assert false: "Duplicate definition of variable " + name + " in current scope";
            }
            
            currentScope.add( name, variable );
        } else {
            // using this variable
            variable = currentScope.lookup( name );
            
            //System.out.println( "using " + name );
            
            // FIXME: this will become a compile error!
            assert variable != null: "Variable " + name + " undeclared in the current scope";
        }
        
        // replace node in parent
        WandNode parent = node.getParent( );
        parent.replaceChild( node, variable );
        
        return data;
    }
    
    public Object visit(ASTFunctionCall node, Object data) {
        // skip the identifier (first node), because it's a function,
        // and we are only looking for variables.
        // FIXME: this will break when we have delegate types that
        // must be considered.
        
        boolean first = true;
        for ( WandNode child: node ) {
            if ( first ) {
                first = false;
                continue;
            }
            child.accept( this, data );
        }
        
        return data;
    }
}
