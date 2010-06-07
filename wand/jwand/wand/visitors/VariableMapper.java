package wand.visitors;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class VariableMapper extends WandVisitor {
    private Scope currentScope = null;
    
    private boolean inDeclaration = false;
    
    public VariableMapper( ) {
        
    }
    
    private void pushScope( ) {
        currentScope = new Scope( currentScope );
    }
    
    private void popScope( ) {
        currentScope = currentScope.getParentScope( );
    }
    
    public Object visit( ASTBlock node, Object data ) {
        pushScope( );
        visitChildren( node, data );
        popScope( );
        
        return data;
    }
    
    public Object visit( ASTLocalVariableDeclarationStatement node, Object data ) {
        inDeclaration = true;
        System.out.println( "variable declaration" );
        visitChildren( node, data );
        inDeclaration = false;
        return data;
    }
    
    public Object visit( ASTIdentifier node, Object data ) {
        String name = node.getIdentifier( );
        
        WandNode variable = null;
        
        if ( inDeclaration ) {
            // declaring this variable
            System.out.println( "declaring " + name );
            
            variable = new WandVariable( name );
            
            currentScope.add( name, variable );
        } else {
            // using this variable
            variable = currentScope.lookup( name );
            
            System.out.println( "using " + name );
            
            // FIXME: this will become a compile error!
            assert variable != null: "Variable " + name + " undeclared in the current scope";
        }
        
        // replace node in parent
        WandNode parent = node.getParent( );
        parent.replaceChild( node, variable );
        
        return data;
    }
}
