package wand.core;

import java.util.*;

public class WandTypeSystem {
    private static HashMap<WandBasicType,WandType> basicTypes;
    private static HashMap<String,WandType> typeMap;
    
    private static HashMap<String,WandNamespace> namespaces;
    
    static {
        basicTypes = new HashMap<WandBasicType,WandType>();
        typeMap = new HashMap<String,WandType>();
        namespaces = new HashMap<String,WandNamespace>();
        initBasicTypes( );
    }
    
    private static void initBasicTypes( ) {
        for ( WandBasicType type : WandBasicType.values() ) {
            initBasicType( type );
        }
    }
    
    private static void initBasicType( WandBasicType type ) {
        basicTypes.put( type, addType( type.getTypeName() ) );
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
