/* Generated By:JJTree: Do not edit this line. ASTDeclarations.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

public
class ASTDeclarations extends SimpleNode {
  public ASTDeclarations(int id) {
    super(id);
  }

  public ASTDeclarations(WandParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WandParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=9e4e8f5bb6c8a8d0e91851f6ef904851 (do not edit this line) */
