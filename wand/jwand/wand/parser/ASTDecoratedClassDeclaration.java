/* Generated By:JJTree: Do not edit this line. ASTDecoratedClassDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

public
class ASTDecoratedClassDeclaration extends SimpleNode {
  public ASTDecoratedClassDeclaration(int id) {
    super(id);
  }

  public ASTDecoratedClassDeclaration(WandParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WandParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=0ac307af2efaf2aed29d67b2909f058f (do not edit this line) */
