/* Generated By:JJTree: Do not edit this line. ASTIntegerLiteral.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

public
class ASTIntegerLiteral extends ASTLiteral {
    private Integer literal;
    
    public ASTIntegerLiteral(int id) {
        super(id);
    }
    
    public ASTIntegerLiteral(WandParser p, int id) {
        super(p, id);
    }
    
    public Integer getInteger( ) {
        return literal;
    }
    
    public void fromString( String str ) {
        int radix = 10;
        int contentStart = 0;
        
        if ( str.startsWith( "0b" ) ) {
            radix = 2;
            contentStart = 2;
        } else if ( str.startsWith( "0x" ) ) {
            radix = 16;
            contentStart = 2;
        } else if ( str.startsWith( "0" ) ) {
            radix = 8;
            contentStart = 1;
        }
        
        literal = Integer.parseInt( str.substring(contentStart), radix );
    }
    
    /** Accept the visitor. **/
    public Object jjtAccept(WandParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

}
/* JavaCC - OriginalChecksum=35f4ae5bb98de94141b200b0030f0d1b (do not edit this line) */
