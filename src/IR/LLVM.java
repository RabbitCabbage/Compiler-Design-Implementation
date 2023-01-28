package IR;

import ast.ParameterNode;
import frontend.Symbols;

import java.util.LinkedHashMap;

public class LLVM {
    //其主要功能是为了储存，并将相关的信息打印成llvm形式
    //现在的思路就是考虑llvm需要那些信息，需要以什么样的形式组织出来
    //我就在跑ast的时候去收集和组织这些信息
    public LinkedHashMap<String, FunctionIR> functions;
    public LinkedHashMap<String, ClassIR> classes;
    public LinkedHashMap<String, GlobalVarIR> globalVars;
    public LinkedHashMap<String,String> stringConstants;
    public Symbols symbols;
    IRTypeGetter getter;

    public LLVM(Symbols symbols){
        functions = new LinkedHashMap<>();
        classes = new LinkedHashMap<>();
        globalVars = new LinkedHashMap<>();
        stringConstants = new LinkedHashMap<>();
        this.symbols = symbols;
        getter = new IRTypeGetter(symbols, this);
    }
    public String toDotLLVM(){
        StringBuilder text = new StringBuilder();
        for(String regname: stringConstants.keySet()){
            text.append("@"+regname).append(" = private unnamed_addr constant [").append(stringConstants.get(regname).length()).append(" x i8] "+"c\""+stringConstants.get(regname)+"\""+"\n");
        }
        for(var vardef :globalVars.values()){
            text.append(vardef.declare.info_for_global);
        }
        for(var clsdef: classes.values()){
            text.append("%struct.").append(clsdef.classdef.name).append(" = type {");
            for(var vardef: clsdef.classdef.variablemap.values()){
                text.append(getter.getType(vardef.type,vardef.dim,null)+"*").append(", ");
            }
            text.deleteCharAt(text.length()-1);
            text.deleteCharAt(text.length()-1);
            text.append("}\n");
            for(FunctionIR fcdef: clsdef.methods){
                text.append("define ").append(getter.getType(fcdef.funcdef.returntype,fcdef.funcdef.returndim,null)).append(" @").append(fcdef.funcdef.name).append("(");
                int count = 0;
                text.append("%struct.").append(clsdef.classdef.name).append(" %").append(count);
                count = count + 1;
                text.append(", ");
                for(ParameterNode para: fcdef.funcdef.parameterlist){
                    text.append(getter.getType(para.type,para.dim,null)).append(" %").append(count);
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
        //System.out.println(text.toString());
        //System.out.println("****************************************");
        for(var fcdef: functions.values()){
            text.append("define ").append(getter.getType(fcdef.funcdef.returntype,fcdef.funcdef.returndim,null)).append(" @").append(fcdef.funcdef.name).append("(");
            int count = 0;
            for(ParameterNode para: fcdef.funcdef.parameterlist){
                text.append(getter.getType(para.type,para.dim,null)).append(" ").append(para.declare.name);
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
                    //System.out.println("new block");
                    text.append(a.block_id).append(":\n");
                    a.instrs.forEach(b->text.append(b.toString()));
                });
            }
            text.append("}\n");
        }
        text.append("\n");
        text.append("declare void @print(i8*)\n" +
                "declare void @println(i8*)\n" +
                "declare void @printInt(i32)\n" +
                "declare void @printlnInt(i32)\n" +
                "declare i8* @getString()\n" +
                "declare i32 @getInt()\n" +
                "declare i8* @toString(i32)\n" +
                "declare i32 @getArraySize(i8*)\n" +
                "declare i32 @string_length(i8*)\n" +
                "declare i8* @string_substring(i8*,i32,i32)\n" +
                "declare i32 @string_parseInt(i8*)\n" +
                "declare i32 @string_ord(i8*,i32)\n" +
                "declare i8* @malloc_(i32)\n" +
                "declare i8* @string_concat(i8*,i8*)\n" +
                "declare i8 @string_equal(i8*,i8*)\n" +
                "declare i8 @string_nequal(i8*,i8*)\n" +
                "declare i8 @string_lessthan(i8*,i8*)\n" +
                "declare i8 @string_greaterthan(i8*,i8*)\n" +
                "declare i8 @string_notgreaterthan(i8*, i8*)\n" +
                "declare i8 @string_notlessthan(i8*,i8*)\n");
        return text.toString();
    }
}
