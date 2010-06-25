package wand.core;

import wand.parser.*;

public abstract class WandNameMangler {
    public static String mangleFunction( WandFunctionDeclaration function ) {
        String namespaceMangled = mangleNamespace( function.getNamespace( ) );
        String functionMangled = function.getFunctionName( );
        
        // FIXME: types!
        
        int compatKind = WandParserConstants.MODIFIER_COMPAT;
        if ( function.hasModifier(compatKind) && function.getModifierMeta(compatKind).equals("c") ) {
            // C compatibility
            return function.getFunctionName( );
        }
        
        return "_" + namespaceMangled + "__" + functionMangled;
    }
    
    public static String mangleNamespace( WandNamespace namespace ) {
        return namespace.getName( ).replace( '.', '_' );
    }
}
