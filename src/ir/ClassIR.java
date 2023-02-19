package ir;

import asm.ASMBuilder;
import ast.ClassDefNode;
import ast.DeclarationNode;

import java.util.ArrayList;

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
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
