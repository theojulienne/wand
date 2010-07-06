package wand.core;

public enum WandBasicType {
    // type      name    data size signed                    type mangle
    Void        ("void",    0,  0,  false,     WandTypeClass.Void, "v"   ),
    Boolean     ("bool",    1,  8,  false,  WandTypeClass.Boolean, "n"   ),
    Signed8     ("byte",    8,  8,  true,   WandTypeClass.Integer, "b"   ),
    Unsigned8   ("ubyte",   8,  8,  false,  WandTypeClass.Integer, "B"   ),
    Signed16    ("short",  16, 16,  true,   WandTypeClass.Integer, "s"   ),
    Unsigned16  ("ushort", 16, 16,  false,  WandTypeClass.Integer, "S"   ),
    Signed32    ("int",    32, 32,  true,   WandTypeClass.Integer, "i"   ),
    Unsigned32  ("uint",   32, 32,  false,  WandTypeClass.Integer, "I"   ),
    Signed64    ("long",   64, 64,  true,   WandTypeClass.Integer, "l"   ),
    Unsigned64  ("ulong",  64, 64,  false,  WandTypeClass.Integer, "L"   ),
    
    Float32     ("float",  32, 32,  true,     WandTypeClass.Float, "f"   ),
    Float64     ("double", 64, 64,  true,     WandTypeClass.Float, "d"   ),
    Float80     ("real",   80, 80,  true,     WandTypeClass.Float, "r"   ),
    
    Char        ("char",    8,  8,  true,   WandTypeClass.Integer, "c"   );
    
    private final String typeCode;
    private final int dataBits;
    private final int sizeBits;
    private final boolean signed;
    private final WandTypeClass generalType;
    private final String mangleChar;
    
    WandBasicType( String typeCode, int dataBits, int sizeBits, boolean signed, WandTypeClass generalType, String mangleChar ) {
        this.typeCode = typeCode;
        this.dataBits = dataBits;
        this.sizeBits = sizeBits;
        this.signed = signed;
        this.generalType = generalType;
        this.mangleChar = mangleChar;
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
    
    public boolean isBoolean() {
        return (generalType == WandTypeClass.Boolean);
    }
    
    public WandTypeClass getTypeClass() {
        return generalType;
    }
    
    public String getMangleChar() {
        return mangleChar;
    }
    
    public int getBitSize() {
        return sizeBits;
    }
    
    public int getDataSize() {
        return dataBits;
    }
    
    public boolean isSigned() {
        return signed;
    }
}
