/* Generated By:JJTree: Do not edit this line. ASTPrefixExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

public
class ASTPrefixExpression extends SimpleNode {
  public ASTPrefixExpression(int id) {
    super(id);
  }

  public ASTPrefixExpression(WandParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WandParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=1f2310a65c7ab3c27f2f85416bc9c6d8 (do not edit this line) */