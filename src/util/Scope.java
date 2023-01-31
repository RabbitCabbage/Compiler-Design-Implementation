package util;

import ast.DeclarationNode;
import util.error.SemanticError;

import java.util.HashMap;
import java.util.function.BiConsumer;
//todo 存变量的值。

public class Scope {
    public HashMap<String, DeclarationNode> members;//建立从name到type的映射，可能是class，因此类型用string表示
    public Scope parent;
    public boolean is_loop = false;
    public boolean is_class = false;
    public String class_name;

    public boolean function_paras_defined = false;
    public HashMap <String, String> variable_name_to_reg_name;//在这个scope内部从变量名到寄存器名称的映射

    public Scope(Scope parentscope) {
        members = new HashMap<>();
        this.parent = parentscope;
        variable_name_to_reg_name = new HashMap<>();
        if (parentscope != null) this.is_loop = parentscope.is_loop;//在whilestatement中可能会有嵌套suite，因此是不是训话需要有继承性
    }

    public boolean containVariable(String name, boolean toLookForInParent) {
//        for (String key : members.keySet()) {
//            System.out.println(key);
//        }
        if (members.containsKey(name)) return true;
        else if (parent != null && toLookForInParent) {
            return parent.containVariable(name, toLookForInParent);
        }
        return false;
    }

    public Scope findScopeContaining(String name){
        if(this.containVariable(name,false))return this;
        else {
            if(parent==null)return null;
            else return parent.findScopeContaining(name);
        }
    }

    public DeclarationNode findVariable(String name, boolean toLookForInParent) {
        if (members.containsKey(name)) return members.get(name);
        else if (parent != null && toLookForInParent) {
            return parent.findVariable(name, toLookForInParent);
        }
        return null;
    }

    public void defineVariable(String name, DeclarationNode delcare, Position pos) {
        if (members.containsKey(name))
            throw new SemanticError("variable redefined", pos);
        else members.put(name, delcare);
    }
}
