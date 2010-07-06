package wand.core;

public class WandType {
    private String name;
    private WandBasicType basicType;
    
    public WandType( String name ) {
        super( );
        this.name = name;
    }
    
    public void setBasicType( WandBasicType basicType ) {
        this.basicType = basicType;
    }
    
    public WandBasicType getBasicType( ) {
        return this.basicType;
    }
    
    public String toString() {
        return "<WandType: " + name + ">";
    }
    
    public boolean canImplicitlyCoerce( WandType source ) {
        WandBasicType sourceType = source.getBasicType( );
        boolean coercible = false;
        
        if ( sourceType != null ) {
            // assume not coercible unless we find a case we allow
            coercible = false;
            
            if ( sourceType == basicType ) {
                // same type, always fine
                coercible = true;
            } else if ( sourceType.getTypeClass() == basicType.getTypeClass() ) {
                // same underlying type (eg, integer or floating point)
                // allow casting if the destination type is larger (or the same)
                coercible = (sourceType.getDataSize() <= basicType.getDataSize());
            } else if ( sourceType.getTypeClass() == WandTypeClass.Boolean &&
                        basicType.getTypeClass() == WandTypeClass.Integer ) {
                // boolean -> integer is acceptable (NOT the reverse)
                coercible = true;
            } else if ( sourceType.getTypeClass() == WandTypeClass.Integer &&
                        basicType.getTypeClass() == WandTypeClass.Float ) {
                // integer -> float is acceptable (NOT the reverse)
                coercible = true;
            }
        } else {
            // Object implicit coercion, based on interface/superclasses
            coercible = false;
        }
        
        return coercible;
    }
    
    public boolean equals( WandType other ) {
        WandBasicType otherType = other.getBasicType( );
        boolean sameType = false;
        
        if ( otherType != null ) {
            sameType = (otherType == basicType);
        }
        
        return sameType;
    }
}
