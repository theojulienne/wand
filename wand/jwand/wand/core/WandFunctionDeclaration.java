package wand.core;

import wand.parser.*;

public interface WandFunctionDeclaration {
    public String getFunctionName( );
    public WandNamespace getNamespace( );
    
    // FIXME: this should become un-AST
    public ASTType getReturnType( );
    public ASTFunctionParameters getFunctionParameters( );
    
    // FIXME: these should use an enum for modifier types instead of token kinds
    public boolean hasModifier( int kind );
    public String getModifierMeta( int kind );
}
