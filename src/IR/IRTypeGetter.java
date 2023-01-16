package IR;

import ast.DeclarationNode;
import frontend.Symbols;

public class IRTypeGetter {
    Symbols symbols;
    public IRTypeGetter(Symbols sym){
        symbols = sym;
    }

    public String getType(String typename,int dim) {
        StringBuilder type = new StringBuilder();
        if(typename.equals("int"))type.append("i32");
        if(typename.equals("void"))return typename;
        if(typename.equals("string"))type.append("i8*");
        if(typename.equals("bool"))type.append(typename);
        else type.append("%struct."+typename);
        for(int i=0;i<i;++i){
            type.append("*");
        }
        return type.toString();
    }

    public String getStringPointer(String str,String reg){
        StringBuilder gep = new StringBuilder();
        gep.append("getelementptr inbounds ([").append(str.length()).append(" x i8], [").append(str.length()).append(" x i8]* @"+reg+", i32 0, i32 0)");
        return gep.toString();
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
