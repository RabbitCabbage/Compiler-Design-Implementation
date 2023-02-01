package IR;

import ast.ClassDefNode;
import ast.DeclarationNode;
import frontend.Symbols;

public class IRTypeGetter {
    Symbols symbols;
    LLVM llvm;
    public IRTypeGetter(Symbols sym,LLVM llvm){
        symbols = sym;
        this.llvm = llvm;
    }

    public String getType(String typename,int dim,String reg_name) {
        //System.out.println(typename);
        StringBuilder type = new StringBuilder();
        if(typename.equals("int"))type.append("i32");
        else if(typename.equals("void"))return typename;
        else if(typename.equals("string")){
            if(llvm.stringConstants.containsKey(reg_name)){
                type.append("[").append(llvm.stringConstants.get(reg_name).length()).append(" x i8]*");
            }else type.append("i8*");
        }
        else if(typename.equals("bool"))type.append("i1");
        else type.append("%struct."+typename);
        for(int i=0;i<dim;++i){
            type.append("*");
        }
        return type.toString();
    }

    public String getStringPointer(String str,String reg){
        StringBuilder gep = new StringBuilder();
        gep.append("getelementptr inbounds ([").append(str.length()).append(" x i8], [").append(str.length()).append(" x i8]* @"+reg+", i32 0, i32 0)");
        return gep.toString();
    }
    public int getSize(String typename,int dim) {
        if(dim >= 1) return 8;
        if(typename.equals("int")||typename.equals("i32"))return 4;
        if(typename.equals("void"))return 0;
        else {
            ClassDefNode cls = symbols.classTypes.get(typename);
            return cls.variablemap.size()*8;
        }
    }
}
