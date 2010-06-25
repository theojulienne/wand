package wand.visitors;

import java.util.*;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class VariableMapper extends WandVisitor {
    private ASTProgram currentProgram = null;
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
    
    public Object visit( ASTProgram node, Object data ) {
        currentProgram = node;
        
        return visitChildren( node, data );
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
        boolean first = true;
        for ( WandNode child: node ) {
            if ( first ) {
                // the first node is the function name itself
                
                first = false;
                
                ASTIdentifier identifierNode = (ASTIdentifier)child;
                String identifier = identifierNode.getIdentifier( );
                //System.out.println( "Function called: " + identifier );
                
                List<WandNamespace> usedNamespaces = currentProgram.getUsedNamespaces( );
                
                FunctionSymbol symbol = null;
                
                // FIXME: this needs to allow for qualified identifiers
                
                // FIXME: instead of using just any old match, use the BEST match 
                // based on the type, and error if types can't be implicitly cast.
                for ( WandNamespace namespace: usedNamespaces ) {
                    if ( namespace.containsName( identifier ) ) {
                        symbol = (FunctionSymbol)namespace.getSymbol( identifier );
                        break;
                    }
                }
                
                assert symbol != null: "Function " + identifier + " could not be found. Typo or missing a namespace?";
                
                WandFunctionDeclaration declaration = symbol.getFirstDeclaration( );
                WandFunctionReference reference = new WandFunctionReference( declaration );
                // replace node in parent
                
                node.replaceChild( identifierNode, reference );
                
                continue;
            }
            child.accept( this, data );
        }
        
        return data;
    }
}
