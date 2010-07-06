package wand.visitors;

import java.util.*;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class VariableMapper extends WandVisitor {
    private ASTProgram currentProgram = null;
    private Scope currentScope = null;
    
    private boolean inDeclaration = false;
    private WandType currentType = null;
    
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
        ASTType typeNode = (ASTType)node.getType( );
        
        currentType = typeNode.getType( );
        visitChildren( node, data );
        currentType = null;
        
        return data;
    }
    
    public Object visit( ASTVariableDeclarator node, Object data ) {
        int currChild = 0;
        
        for ( WandNode child: node ) {
            // first child is a declaration ASTIdentifier, which is being declared now
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
    
    public Object visit( ASTFunctionParameter node, Object data ) {
        ASTType typeNode = (ASTType)node.getType( );
        
        currentType = typeNode.getType( );
        visitChildren( node, data );
        currentType = null;
        
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
            assert currentType != null: "Found a variable declaration but type not known";
            
            // declaring this variable
            //System.out.println( "declaring " + name );
            //System.out.println( "   with type: " + currentType );
            
            variable = new WandVariable( name, currentType );
            
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
        ASTIdentifier identifierNode = node.getIdentifier( );
        String identifier = identifierNode.getIdentifier( );
        System.out.println( "Function called: " + identifier );
        
        List<WandNamespace> usedNamespaces = currentProgram.getUsedNamespaces( );
        
        FunctionSymbol symbol = null;
        
        ASTArguments argumentsNode = node.getArguments( );
        
        // accept further FIRST, so our params are variable mapped
        argumentsNode.accept( this, data );
        
        // FIXME: use expression type for matching
        /*for ( WandNode child: argumentsNode ) {
            System.out.println( " --> Param: " + child + ": " + child.getExpressionType() );
        }*/
        
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
        
        // we've found our function symbol, now we need to figure out which type declaration fits best
        
        // get the types of the arguments being passed to the function
        WandTypeSet argTypes = node.getArgumentTypeSet( );
        
        List<WandFunctionDeclaration> matchingDeclarations = new ArrayList<WandFunctionDeclaration>();
        WandFunctionDeclaration exactMatch = null;
        
        for ( WandFunctionDeclaration declaration: symbol ) {
            WandTypeSet declTypes = declaration.getParameterTypeSet( );
            
            if ( declTypes.canImplicitlyCoerce( argTypes ) ) {
                matchingDeclarations.add( declaration );
                
                if ( declTypes.equals( argTypes ) ) {
                    // they are the same exact types!
                    assert exactMatch == null: "2 declarations exactly matched the types in a function call";
                    exactMatch = declaration;
                }
            }
            
            //System.out.println( declTypes + " matches " + argTypes + "? " + declTypes.canImplicitlyCoerce( argTypes ) );
        }
        
        WandFunctionDeclaration declaration = null;
        
        if ( matchingDeclarations.size() == 1 ) {
            // found exactly 1, great!
            declaration = matchingDeclarations.get( 0 );
        } else if ( matchingDeclarations.size() > 1 ) {
            // more than one match. this is acceptable, providing as one matches _exactly_
            assert exactMatch != null: "Multiple function declarations matched the provided argument types, but none matched explicitly.";
            declaration = exactMatch;
        }
        
        assert declaration != null: "Provided arguments did not match any function declarations.";
        
        
        WandFunctionReference reference = new WandFunctionReference( declaration );
        
        // replace node in parent
        node.replaceChild( identifierNode, reference );
        
        return data;
    }
}
