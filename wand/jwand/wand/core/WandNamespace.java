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
    
    public String getName( ) {
        return this.name;
    }
    
    public boolean containsName( String name ) {
        return symbolTable.containsKey( name );
    }
    
    public WandSymbol getSymbol( String name ) {
        return symbolTable.get( name );
    }
    
    public FunctionSymbol addFunction( String name ) {
        FunctionSymbol symbol = new FunctionSymbol( this, name );
        
        symbolTable.put( name, symbol );
        
        return symbol;
    }
    
    public Set<String> getSymbols( ) {
        return symbolTable.keySet( );
    }
}
