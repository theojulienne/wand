/* Generated By:JJTree: Do not edit this line. ASTQualifiedIdentifierList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

public
class ASTQualifiedIdentifierList extends SimpleNode {
  public ASTQualifiedIdentifierList(int id) {
    super(id);
  }

  public ASTQualifiedIdentifierList(WandParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WandParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=43c8d291549fd0f3e651a68021e2b29c (do not edit this line) */
