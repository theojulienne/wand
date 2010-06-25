package wand.core;

import java.util.*;

import wand.parser.*;

public class FunctionSymbol extends WandSymbol implements Iterable<ASTFunctionDeclaration> {
    private List<ASTFunctionDeclaration> declarations = new ArrayList<ASTFunctionDeclaration>( );
    
    public FunctionSymbol( WandNamespace namespace, String name ) {
        super( namespace, name );
    }
    
    public void addDeclaration( ASTFunctionDeclaration declaration ) {
        declaration.setNamespace( getNamespace( ) );
        declarations.add( declaration );
        System.out.println( "Function " + getName() + " now contains declaration: " + declaration );
    }
    
    public ASTFunctionDeclaration getFirstDeclaration( ) {
        return declarations.get( 0 );
    }
    
    public Iterator<ASTFunctionDeclaration> iterator() {
        return declarations.iterator( );
    }
}
