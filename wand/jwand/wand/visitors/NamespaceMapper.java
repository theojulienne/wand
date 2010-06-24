package wand.visitors;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class NamespaceMapper extends WandVisitor {
    private ASTProgram program;
    
    public NamespaceMapper( ) {
        
    }
    
    public Object visit(ASTProgram node, Object data) {
        program = node;
        
        visitChildren( node, data );
        
        return data;
    }
    
    public Object visit(ASTUsingStatement node, Object data) {
        System.out.println( "using statement: " + node );
        
        String qualifiedName = node.getQualifiedName( );
        
        // FIXME: real compile error
        assert WandNamespace.namespaceExists(qualifiedName): "Namespace '"+qualifiedName+"' does not exist.";
        
        WandNamespace namespace = WandNamespace.getNamespace( qualifiedName );
        program.importNamespace( namespace );
        
        return data;
    }
}
