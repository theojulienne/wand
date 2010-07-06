package wand.core;

import java.util.*;

public class WandTypeSet {
    private List<WandType> types = new ArrayList<WandType>();
    
    public WandTypeSet( ) {
        
    }
    
    public void addType( WandType type ) {
        types.add( type );
    }
    
    public int getNumTypes( ) {
        return types.size( );
    }
    
    public WandType getType( int index ) {
        return types.get( index );
    }
    
    public boolean canImplicitlyCoerce( WandTypeSet source ) {
        boolean coercible = (getNumTypes() == source.getNumTypes());
        
        if ( coercible ) {
            for ( int i = 0; i < getNumTypes(); i++ ) {
                WandType sourceType = source.getType( i );
                WandType thisType = this.getType( i );
                
                if ( !thisType.canImplicitlyCoerce( sourceType ) ) {
                    coercible = false;
                }
            }
        }
        
        return coercible;
    }
    
    public boolean equals( WandTypeSet other ) {
        boolean sameSet = (getNumTypes() == other.getNumTypes());
        
        for ( int i = 0; i < getNumTypes(); i++ ) {
            WandType otherType = other.getType( i );
            WandType thisType = this.getType( i );
            
            sameSet = sameSet && otherType.equals( thisType );
        }
        
        return sameSet;
    }
    
    public String toString( ) {
        return types.toString( );
    }
}
