package wand.visitors;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class NamespaceFinder extends WandVisitor {
    private WandNamespace namespace;
    private ASTProgram program;
    
    public NamespaceFinder( ) {
        
    }
    
    public Object visit(ASTProgram node, Object data) {
        program = node;
        
        // FIXME: only if no NamespaceDeclaration node exists?
        namespace = WandNamespace.getGlobalNamespace( );
        
        visitChildren( node, data );
        
        node.setNamespace( namespace );
        node.importNamespace( namespace );
        
        return data;
    }
    
    public Object visit(ASTNamespaceDeclaration node, Object data) {
        namespace = WandNamespace.getNamespace( node.getQualifiedName( ) );
        program.importNamespace( namespace );
        
        return data;
    }
    
    // look for functions
    public Object visit(ASTFunctionDeclaration node, Object data) {
        String functionName = node.getFunctionName( );
        
        FunctionSymbol function = null;
        
        if ( namespace.containsName( functionName ) ) {
            function = (FunctionSymbol)namespace.getSymbol( functionName );
            assert function != null: "Name conflict between a type/variable and function " + functionName;
        } else {
            function = namespace.addFunction( functionName );
        }
        
        function.addDeclaration( node );
        
        return data;
    }
}
