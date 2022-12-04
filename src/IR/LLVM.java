package IR;

import ast.ParameterNode;
import frontend.Symbols;

import java.util.HashMap;

public class LLVM {
    //其主要功能是为了储存，并将相关的信息打印成llvm形式
    //现在的思路就是考虑llvm需要那些信息，需要以什么样的形式组织出来
    //我就在跑ast的时候去收集和组织这些信息
    public HashMap<String, FunctionIR> functions;
    public HashMap<String, ClassIR> classes;
    public HashMap<String, GlobalVarIR> globalVars;
    public Symbols symbols;
    IRTypeGetter getter;

    public LLVM(Symbols symbols){
        functions = new HashMap<>();
        classes = new HashMap<>();
        globalVars = new HashMap<>();
        this.symbols = symbols;
        getter = new IRTypeGetter(symbols);
    }
    public String toDotLLVM(){
        StringBuilder text = new StringBuilder();
        int global_string = 0;
        for(var vardef :globalVars.values()){
            if(!vardef.declare.type.equals("string")) {
                text.append("@").append(vardef.declare.name).append(" = global ").append(getter.getType(vardef.declare.type)).append(" ").append(vardef.declare.init.valueIR.values.get(0).number_value).append("\n");
            } else {
                text.append("@.str");
                if(global_string!=0){text.append(".").append(global_string++);}
                else global_string++;
                text.append("= private unnamed_addr constant [").append(vardef.declare.init.valueIR.values.get(0).string_value.length()).append(" x i8] ").append(vardef.declare.init.valueIR.values.get(0).string_value).append("\n");
                text.append("@").append(vardef.declare.name).append(" = global i8* getelementptr inbounds ([").append(vardef.declare.init.valueIR.values.get(0).string_value.length()).append(" x i8], [").append(vardef.declare.init.valueIR.values.get(0).string_value.length()).append(" x i8]* @.str.").append(global_string-1).append(", i32 0, i32 0)\n");
            }
        }
        for(var clsdef: classes.values()){
            text.append("%struct.").append(clsdef.classdef.name).append(" = type{");
            for(var vardef: clsdef.classdef.variablemap.values()){
                text.append(getter.getType(vardef.type)).append(", ");
            }
            text.deleteCharAt(text.length()-1);
            text.deleteCharAt(text.length()-1);
            text.append("}\n");
            for(FunctionIR fcdef: clsdef.methods){
                text.append("define ").append(getter.getType(fcdef.funcdef.returntype)).append(" @").append(fcdef.funcdef.name).append("(");
                int count = 0;
                text.append("%struct.").append(clsdef.classdef.name).append(" %").append(count);
                count = count + 1;
                text.append(", ");
                for(ParameterNode para: fcdef.funcdef.parameterlist){
                    text.append(getter.getType(para.type)).append(" %").append(count);
                    count = count + 1;
                    text.append(", ");
                }
                text.deleteCharAt(text.length() - 1);
                text.deleteCharAt(text.length() - 1);
                text.append("){\n");
                if(fcdef.funcdef.stmts != null){
                    //先把所有的statment收集到StatementIR里面
                    fcdef.blocks.forEach(a->{
                        text.append(a.block_id).append(":\n");
                        a.instrs.forEach(b->text.append(b.toString()));
                    });
                }
                text.append("}\n");
            }
        }
        text.append("\n");
        for(var fcdef: functions.values()){
            text.append("define ").append(getter.getType(fcdef.funcdef.returntype)).append(" @").append(fcdef.funcdef.name).append("(");
            int count = 0;
            for(ParameterNode para: fcdef.funcdef.parameterlist){
                text.append(getter.getType(para.type)).append(" %").append(para.declare.name);
                count = count + 1;
                text.append(", ");
            }
            if(!fcdef.funcdef.parameterlist.isEmpty()){
                text.deleteCharAt(text.length()-1);
                text.deleteCharAt(text.length()-1);
            }
            text.append("){\n");
            if(fcdef.funcdef.stmts != null){
                //先把所有的statment收集到StatementIR里面
                fcdef.blocks.forEach(a->{
                    text.append(a.block_id).append(":\n");
                    a.instrs.forEach(b->text.append(b.toString()));
                });
            }
            text.append("}\n");
        }
        text.append("\n");
        return text.toString();
    }
}
