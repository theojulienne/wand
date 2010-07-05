package wand.core;

import wand.parser.*;

public class WandVariable extends ASTIdentifier {
    private WandType type;
    
    public WandVariable( String identifier, WandType type ) {
        super( -1 );
        this.setIdentifier( identifier );
        
        this.type = type;
    }
    
    public String toString( ) {
        return "<WandVariable: " + getIdentifier() + ">";
    }
    
    public WandType getExpressionType() {
        return type;
    }
    
    public Object jjtAccept(WandParserVisitor visitor, Object data) {
        data = visitor.visit(this, data);
        childrenAccept( visitor, data );
        return data;
    }
}
