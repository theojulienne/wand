package wand.visitors;

import wand.core.*;
import wand.util.*;
import wand.parser.*;

public class TypeMapper extends WandVisitor {
    public TypeMapper( ) {
        
    }
    
    public Object visit(ASTBuiltinType node, Object data) {
        //System.out.println( "builtin type: " + node );
        
        String typeName = node.getTypeName( );
        
        WandType type = WandTypeSystem.getTypeByName( typeName );
        
        //System.out.println( " -> " + type );
        
        return data;
    }
    
    public Object visit(ASTArrayType node, Object data) {
        //System.out.println( "array type: " + node );
        return data;
    }
}
