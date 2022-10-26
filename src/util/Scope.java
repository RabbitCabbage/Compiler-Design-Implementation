package util;

import util.error.SemanticError;

import java.util.HashMap;
//todo 存变量的值。

public class Scope {
    private HashMap<String,String> members;//建立从name到type的映射，可能是class，因此类型用string表示
    private Scope parent;

    public Scope(Scope parentscope){
        members = new HashMap<String,String>();
        this.parent = parentscope;
    }

    public boolean containVariable(String name, boolean toLookForInParent){//todo 仅提供在所有
        if (members.containsKey(name))return true;
        else if (parent != null && toLookForInParent){
            return parent.containVariable(name, toLookForInParent);
        }else return false;
    }

    public void defineVariable(String name,String type, Position pos){
        if (members.containsKey(name))
            throw new SemanticError("variable redefined",pos);
        else members.put(name,type);
    }

    public String getTypeFromName(String name, Position pos){
        if (members.containsKey(name)) return members.get(name);
        throw new SemanticError("no such variable: " + name, pos);
    }
}
