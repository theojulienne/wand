/* Generated By:JJTree: Do not edit this line. ASTIdentifier.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

import wand.generators.*;

public
class ASTIdentifier extends SimpleNode {
    private String identifier;
    
    public ASTIdentifier(int id) {
        super(id);
    }
    
    public ASTIdentifier(WandParser p, int id) {
        super(p, id);
    }
    
    public void setIdentifier( String id ) {
        this.identifier = id;
    }
    
    public String getIdentifier( ) {
        return this.identifier;
    }
    
    public Generator getGenerator( ) {
        return GeneratorFactory.getGeneratorFactory( ).getIdentifierGenerator( );
    }
    
    public String toString( ) {
        return "<Identifier: " + identifier + ">";
    }
    
    /** Accept the visitor. **/
    public Object jjtAccept(WandParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=0290de3c411cff96e7c461efdd3a12c7 (do not edit this line) */
