package asm;

import IR.ClassIR;
import IR.FunctionIR;
import IR.GlobalVarIR;
import IR.Instruction.*;
import IR.LLVM;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ASMBuilder {
    public ASMBuilder(){
        functions = new ArrayList<>();
    }
    public FunctionASM current_function;
    public ArrayList<FunctionASM> functions;
    public LinkedHashMap<String, GlobalVarIR> globalVars;
    public LinkedHashMap<String,String> stringConstants;
    public void visit(LLVM llvm){
        globalVars = llvm.globalVars;
        stringConstants = llvm.stringConstants;
        for(var funcdef: llvm.functions.values()) funcdef.accept(this);
        for(var clsdef: llvm.classes.values()) clsdef.accept(this);
    }
    public void visit(FunctionIR funcdef){
        current_function = new FunctionASM(funcdef);
        funcdef.blocks.forEach(a->{
            a.instrs.forEach(b->b.accept(this));
        });
        functions.add(current_function);
    }
    public void visit(ClassIR classdef){

    }

    public void visit(AllocaInstruction instr){

    }
    public void visit(BinaryInstruction instr){

    }
    public void visit(BitcastInstruction instr){

    }
    public void visit(BrInstruction instr){

    }
    public void visit(CallInstruction instr){

    }
    public void visit(GetElementPtrInstruction instr){

    }
    public void visit(LoadInstruction instr){

    }
    public void visit(PhiInstruction instr){

    }
    public void visit(RetInstruction instr){

    }
    public void visit(StoreInstruction instr){

    }
}
