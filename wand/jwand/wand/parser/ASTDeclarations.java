/* Generated By:JJTree: Do not edit this line. ASTDeclarations.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

public
class ASTDeclarations extends SimpleNode {
    public ASTDeclarations(int id) {
        super(id);
    }
    
    public ASTDeclarations(WandParser p, int id) {
        super(p, id);
    }
    
    public void addDeclaration( ASTDeclaration declaration ) {
        System.out.println( "addDeclaration( "+declaration+" );" );
    }
}
/* JavaCC - OriginalChecksum=f5b70d2b1b755b2577252666e38442d0 (do not edit this line) */
