package wand.util;

import java.util.*;

import wand.core.*;

public class Scope {
    private Scope parentScope = null;
    private Map<String,WandNode> symbolTable = null;
    
    public Scope( ) {
        this( null );
    }
    
    public Scope( Scope parent ) {
        super( );
        setParentScope( parent );
    }
    
    public void setParentScope( Scope parent ) {
        parentScope = parent;
    }
    
    public Scope getParentScope( ) {
        return parentScope;
    }
    
    public WandNode lookup( String name ) {
        if ( symbolTable == null ) {
            return null;
        }
        
        if ( symbolTable.containsKey( name ) ) {
            return symbolTable.get( name );
        }
        
        if ( parentScope != null ) {
            return parentScope.lookup( name );
        }
        
        return null;
    }
    
    public void add( String name, WandNode node ) {
        if ( symbolTable == null ) {
            symbolTable = new HashMap<String,WandNode>();
        }
        
        symbolTable.put( name, node );
        System.out.println( "mapping " + name + " to " + node );
    }
    
    public void remove( String name ) {
        symbolTable.remove( name );
    }
    
}
