/* Generated By:JJTree: Do not edit this line. ASTNullLiteral.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

public
class ASTNullLiteral extends ASTLiteral {
    public ASTNullLiteral(int id) {
        super(id);
    }

    public ASTNullLiteral(WandParser p, int id) {
        super(p, id);
    }
    
    /** Accept the visitor. **/
    public Object jjtAccept(WandParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

}
/* JavaCC - OriginalChecksum=e6a3436cc79d8430b4275ee086a0b39d (do not edit this line) */
