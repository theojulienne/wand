package wand.core;

import wand.parser.*;

public abstract class WandNameMangler {
    public static String mangleFunction( WandFunctionDeclaration function ) {
        String namespaceMangled = mangleNamespace( function.getNamespace( ) );
        String functionMangled = function.getFunctionName( );
        
        // FIXME: types!
        StringBuilder mangler = new StringBuilder();
        ASTFunctionParameters params = function.getFunctionParameters( );
        for ( WandNode child: params ) {
            ASTFunctionParameter param = (ASTFunctionParameter)child;
            ASTType typeNode = param.getType( );
            WandType type = typeNode.getType( );
            mangler.append( mangleType( type ) );
            mangler.append( "_" );
        }
        String typesMangled = mangler.toString( );
        
        int compatKind = WandParserConstants.MODIFIER_COMPAT;
        if ( function.hasModifier(compatKind) && function.getModifierMeta(compatKind).equals("c") ) {
            // C compatibility
            return function.getFunctionName( );
        }
        
        return "_" + namespaceMangled + "__" + functionMangled + "__" + typesMangled;
    }
    
    public static String mangleNamespace( WandNamespace namespace ) {
        return namespace.getName( ).replace( '.', '_' );
    }
    
    public static String mangleType( WandType type ) {
        WandBasicType basicType = type.getBasicType( );
        return basicType.getMangleChar();
    }
}
