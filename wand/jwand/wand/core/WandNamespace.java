package wand.core;

import java.util.*;

public class WandNamespace {
    private String[] name;
    private Map<String,WandNode> symbolTable = new HashMap<String,WandNode>();
}
