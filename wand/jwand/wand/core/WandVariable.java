package wand.core;

import wand.parser.*;

public class WandVariable extends ASTIdentifier {
    public WandVariable( String identifier ) {
        super( -1 );
        this.setIdentifier( identifier );
    }
    
    public String toString( ) {
        return "<WandVariable: " + getIdentifier() + ">";
    }
    
    public Object jjtAccept(WandParserVisitor visitor, Object data) {
        data = visitor.visit(this, data);
        childrenAccept( visitor, data );
        return data;
    }
}
