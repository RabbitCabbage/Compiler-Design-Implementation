package IR;

import ast.DeclarationNode;
import frontend.Symbols;

public class IRTypeGetter {
    Symbols symbols;
    public IRTypeGetter(Symbols sym){
        symbols = sym;
    }

    public String getType(String typename) {
        if(typename.equals("int"))return "i32";
        if(typename.equals("void"))return typename;
        if(typename.equals("string"))return typename;
        if(typename.equals("bool"))return typename;
        else return "%struct."+typename;
    }
    public int getSize(String typename) {
        if(typename.equals("int"))return 4;
        if(typename.equals("void"))return 0;
        else return 0;//todo
    }

    public int getAlign(String typename){
        if(typename.equals("int"))return 4;
        if(typename.equals("void"))return 0;
        else return 0;//todo
    }
}
