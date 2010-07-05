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
    
}
