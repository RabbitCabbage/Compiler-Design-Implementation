package IR;

import ast.ClassDefNode;
import ast.DeclarationNode;
import org.antlr.v4.codegen.model.decl.Decl;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassIR {
    public ClassDefNode classdef;
    public ArrayList<FunctionIR> methods;
    public ArrayList<String> element_names;
    public ArrayList<DeclarationNode> elements;
    public ClassIR(ClassDefNode cls){
        classdef = cls;
        methods = new ArrayList<>();
        element_names = new ArrayList<>();
        elements = new ArrayList<>();
    }
}
