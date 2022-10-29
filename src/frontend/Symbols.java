package frontend;

import java.util.HashMap;
import ast.ClassDefNode;
import ast.FunctionDefNode;

public class Symbols {
    public HashMap<String,FunctionDefNode> functionTypes;
    public HashMap<String,ClassDefNode> classTypes;

    public Symbols(){
        functionTypes = new HashMap<>();
        classTypes = new HashMap<>();
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
