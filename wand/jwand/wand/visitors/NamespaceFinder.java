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
        
        System.out.println( "program: " + node );
        
        // FIXME: only if no NamespaceDeclaration node exists?
        namespace = WandNamespace.getGlobalNamespace( );
        
        visitChildren( node, data );
        
        node.setNamespace( namespace );
        node.importNamespace( namespace );
        
        return data;
    }
    
    public Object visit(ASTNamespaceDeclaration node, Object data) {
        System.out.println( "namespace: " + node );
        
        namespace = WandNamespace.getNamespace( node.getQualifiedName( ) );
        program.importNamespace( namespace );
        
        return data;
    }
}
