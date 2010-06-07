/* Generated By:JJTree: Do not edit this line. ASTFunctionDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wand.core.WandNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wand.parser;

import wand.generators.*;

public
class ASTFunctionDeclaration extends ASTDeclaration {
    private String functionName = null;
    
    public ASTFunctionDeclaration(int id) {
        super(id);
    }

    public ASTFunctionDeclaration(WandParser p, int id) {
        super(p, id);
    }
    
    public Generator getGenerator( ) {
        return GeneratorFactory.getGeneratorFactory( ).getFunctionGenerator( );
    }
    
    public void setFunctionName( String name ) {
        this.functionName = name;
    }
    
    public String getFunctionName( ) {
        return this.functionName;
    }
    
    public ASTType getReturnType( ) {
        return (ASTType) jjtGetChild( 0 );
    }
    
    public ASTFunctionParameters getFunctionParameters( ) {
        return (ASTFunctionParameters) jjtGetChild( 1 );
    }
    
    public ASTBlock getFunctionBody( ) {
        return (ASTBlock) jjtGetChild( 2 );
    }
    
    /** Accept the visitor. **/
    public Object jjtAccept(WandParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

}
/* JavaCC - OriginalChecksum=5f943141d3ae60d1bd20a16b105fcd86 (do not edit this line) */
