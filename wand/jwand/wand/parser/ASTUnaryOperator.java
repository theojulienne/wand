/* Generated By:JJTree: Do not edit this line. ASTUnaryOperator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

public
class ASTUnaryOperator extends SimpleNode {
  public ASTUnaryOperator(int id) {
    super(id);
  }

  public ASTUnaryOperator(WandParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WandParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=2368ee984d562ec27ec1347bb8805439 (do not edit this line) */
