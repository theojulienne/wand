package wand.core;

public enum WandBasicType {
    Void ("void"),
    Boolean ("bool"),
    Signed8 ("byte"),
    Unsigned8 ("ubyte"),
    Signed16 ("short"),
    Unsigned16 ("ushort"),
    Signed32 ("int"),
    Unsigned32 ("uint"),
    Signed64 ("long"),
    Unsigned64 ("ulong"),
    
    Float32 ("float"),
    Float64 ("double"),
    Float80 ("real"),
    
    Char ("char");
    
    private final String typeCode;
    
    WandBasicType( String typeCode ) {
        this.typeCode = typeCode;
    }
    
    public String getTypeName() {
        return typeCode;
    }
}
