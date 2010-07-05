package wand.core;

import java.util.*;

public class WandTypeSystem {
    private static HashMap<WandBasicType,WandType> basicTypes;
    private static HashMap<String,WandType> typeMap;
    
    static {
        basicTypes = new HashMap<WandBasicType,WandType>();
        typeMap = new HashMap<String,WandType>();
        initBasicTypes( );
    }
    
    private static void initBasicTypes( ) {
        for ( WandBasicType type : WandBasicType.values() ) {
            initBasicType( type );
        }
    }
    
    private static void initBasicType( WandBasicType basicType ) {
        WandType type = addType( basicType.getTypeName() );
        type.setBasicType( basicType );
        basicTypes.put( basicType, type );
    }
    
    private static WandType addType( String name ) {
        WandType type = new WandType( name );
        typeMap.put( name, type );
        return type;
    }
    
    public static WandType getTypeByName( String name ) {
        return typeMap.get( name );
    }
}
