package wand.core;

public enum WandBasicType {
    // type      name    data size signed                    type
    Void        ("void",    0,  0,  false,     WandTypeClass.Void   ),
    Boolean     ("bool",    1,  8,  false,  WandTypeClass.Integer   ),
    Signed8     ("byte",    8,  8,  true,   WandTypeClass.Integer   ),
    Unsigned8   ("ubyte",   8,  8,  false,  WandTypeClass.Integer   ),
    Signed16    ("short",  16, 16,  true,   WandTypeClass.Integer   ),
    Unsigned16  ("ushort", 16, 16,  false,  WandTypeClass.Integer   ),
    Signed32    ("int",    32, 32,  true,   WandTypeClass.Integer   ),
    Unsigned32  ("uint",   32, 32,  false,  WandTypeClass.Integer   ),
    Signed64    ("long",   64, 64,  true,   WandTypeClass.Integer   ),
    Unsigned64  ("ulong",  64, 64,  false,  WandTypeClass.Integer   ),
    
    Float32     ("float",  32, 32,  true,     WandTypeClass.Float   ),
    Float64     ("double", 64, 64,  true,     WandTypeClass.Float   ),
    Float80     ("real",   80, 80,  true,     WandTypeClass.Float   ),
    
    Char        ("char",    8,  8,  true,   WandTypeClass.Integer   );
    
    private final String typeCode;
    private final int dataBits;
    private final int sizeBits;
    private final boolean signed;
    private final WandTypeClass generalType;
    
    WandBasicType( String typeCode, int dataBits, int sizeBits, boolean signed, WandTypeClass generalType ) {
        this.typeCode = typeCode;
        this.dataBits = dataBits;
        this.sizeBits = sizeBits;
        this.signed = signed;
        this.generalType = generalType;
    }
    
    public String getTypeName() {
        return typeCode;
    }
    
    public boolean isVoid() {
        return (generalType == WandTypeClass.Void);
    }
    
    public boolean isInteger() {
        return (generalType == WandTypeClass.Integer);
    }
    
    public boolean isFloat() {
        return (generalType == WandTypeClass.Float);
    }
    
    public int getBitSize() {
        return sizeBits;
    }
    
    public boolean isSigned() {
        return signed;
    }
}
