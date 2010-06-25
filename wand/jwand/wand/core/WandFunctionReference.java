package wand.core;

import wand.parser.*;

public class WandFunctionReference extends SimpleNode {
    private WandFunctionDeclaration declaration;
    
    public WandFunctionReference( WandFunctionDeclaration declaration ) {
        super( -1 );
        
        this.declaration = declaration;
    }
    
    public String toString( ) {
        return "<WandFunctionReference: " + declaration + ">";
    }
    
    public WandFunctionDeclaration getDeclaration( ) {
        return declaration;
    }
    
    public Object jjtAccept(WandParserVisitor visitor, Object data) {
        data = visitor.visit(this, data);
        childrenAccept( visitor, data );
        return data;
    }
}
