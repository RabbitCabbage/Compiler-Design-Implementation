package IR;

import ast.ClassDefNode;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassIR {
    public ClassDefNode classdef;
    public ArrayList<FunctionIR> methods;
    public ClassIR(ClassDefNode cls){
        classdef = cls;
        methods = new ArrayList<>();
        if(!cls.methoddefs.isEmpty())cls.methoddefs.forEach(a->methods.add(new FunctionIR(a)));
    }
}
