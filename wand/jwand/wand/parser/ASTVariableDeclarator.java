/* Generated By:JJTree: Do not edit this line. ASTVariableDeclarator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

import wand.core.*;

public
class ASTVariableDeclarator extends SimpleNode {
    public ASTVariableDeclarator(int id) {
        super(id);
    }
    
    public ASTVariableDeclarator(WandParser p, int id) {
        super(p, id);
    }
    
    public WandNode getIdentifier( ) {
        return (WandNode) jjtGetChild( 0 );
    }
    
    public WandNode getInitializer( ) {
        return (WandNode) jjtGetChild( 1 );
    }
    
    /** Accept the visitor. **/
    public Object jjtAccept(WandParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=14ce856b3caef73fc675449ee75275a5 (do not edit this line) */
