package frontend;

import java.util.HashMap;
import java.util.LinkedHashMap;

import IR.FunctionIR;
import ast.ClassDefNode;
import ast.FunctionDefNode;
import ast.SuiteNode;
import util.Position;

public class Symbols {
    public HashMap<String,FunctionDefNode> functionTypes;
    public HashMap<String,ClassDefNode> classTypes;
    public HashMap<String, Integer> function_name_to_count;
    public LinkedHashMap<String, FunctionIR> ir_function_names;


    public Symbols(){
        functionTypes = new HashMap<>();
        classTypes = new HashMap<>();
        function_name_to_count = new HashMap<>();
        ir_function_names = new LinkedHashMap<>();
        //增加一个处理global
        SuiteNode func_body = new SuiteNode(new Position(0,0));
        FunctionDefNode init_global_func = new FunctionDefNode("void",0,"kunkun_initialize_global_declarations",func_body,null,new Position(0,0));
        FunctionIR init_global = new FunctionIR(init_global_func);
        init_global.IR_name = "kunkun_initialize_global_declarations";
        ir_function_names.put("kunkun_initialize_global_declarations",init_global);

    }

    public boolean functionTypeUsed(String id){
        return functionTypes.containsKey(id);
       }

    public boolean classTypeUsed(String id){
        return classTypes.containsKey(id);
    }

    public void addClassType(String id, ClassDefNode classnode){
        classTypes.put(id, classnode);
    }

    public void addFunctionType(String id, FunctionDefNode functionnode){
        functionTypes.put(id, functionnode);
    }

}
