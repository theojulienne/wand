package wand.core;

import java.util.*;

public class WandNamespace {
    private String name;
    private Map<String,WandSymbol> symbolTable = new HashMap<String,WandSymbol>();
    
    private static HashMap<String,WandNamespace> namespaces;
    
    static {
        namespaces = new HashMap<String,WandNamespace>();
    }
    
    public static WandNamespace getNamespace( String name ) {
        if ( !namespaces.containsKey( name ) ) {
            namespaces.put( name, new WandNamespace( name ) );
        }
        
        return namespaces.get( name );
    }
    
    public static WandNamespace getGlobalNamespace( ) {
        return getNamespace( "" );
    }
    
    public static boolean namespaceExists( String name ) {
        return namespaces.containsKey( name );
    }
    
    private WandNamespace( String name ) {
        this.name = name;
    }
}
