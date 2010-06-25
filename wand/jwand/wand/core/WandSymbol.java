package wand.core;

public abstract class WandSymbol {
    private String name;
    private WandNamespace namespace;
    
    protected WandSymbol( WandNamespace namespace, String name ) {
        this.name = name;
        this.namespace = namespace;
    }
    
    public String getName( ) {
        return this.name;
    }
    
    public WandNamespace getNamespace( ) {
        return this.namespace;
    }
    
}
