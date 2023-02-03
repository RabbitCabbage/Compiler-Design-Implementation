package asm;

import IR.ClassIR;
import IR.FunctionIR;
import IR.GlobalVarIR;
import IR.Instruction.*;
import IR.LLVM;
import asm.Instruction.MvInstruction;
import asm.Instruction.SwInstruction;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ASMBuilder {
    public ASMBuilder(){
        functions = new ArrayList<>();
    }
    public FunctionASM current_function;
    public BlockASM current_block;
    public ArrayList<FunctionASM> functions;
    public LinkedHashMap<String, GlobalVarIR> globalVars;
    public LinkedHashMap<String,String> stringConstants;
    int function_count = 0;
    public void visit(LLVM llvm){
        globalVars = llvm.globalVars;
        stringConstants = llvm.stringConstants;
        for(var funcdef: llvm.functions.values()) funcdef.accept(this);
        for(var clsdef: llvm.classes.values()) clsdef.accept(this);
    }
    public void visit(FunctionIR funcdef){
        current_function = new FunctionASM(funcdef);
        current_function.function_count = function_count++;
        funcdef.blocks.forEach(a->{
            current_block = new BlockASM(a.block_id.toString(),current_function.function_count);
            a.instrs.forEach(b->b.accept(this));
            current_function.blocks.add(current_block);
        });
        functions.add(current_function);
    }
    public void visit(ClassIR classdef){

    }

    public void visit(AllocaInstruction instr){
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
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
        if(instr.from_reg_name.startsWith("%")) {
            int from_reg_offset = current_function.vreg_to_sp.get(instr.from_reg_name);
            MvInstruction mv = new MvInstruction("t0", from_reg_offset);
            current_block.instrs.add(mv);//先把值读出来，读到t0
            current_function.stack_pointer += 4;
            String res_reg = "%" + String.valueOf(instr.reg);
            current_function.vreg_to_sp.put(res_reg, instr.reg);
            SwInstruction sw = new SwInstruction("t0", current_function.vreg_to_sp.get(res_reg));
            current_block.instrs.add(sw);//再把值写进去，写到resreg对应的
        } else {
            //todo 否则就是全局变量的访问
        }
    }
    public void visit(PhiInstruction instr){

    }
    public void visit(RetInstruction instr){

    }
    public void visit(StoreInstruction instr){
        if(instr.get_value){

        }
        else {
            MvInstruction mv = new MvInstruction("t0",current_function.vreg_to_sp.get(instr.reg));
            current_block.instrs.add(mv);
            SwInstruction sw = new SwInstruction("t0",current_function.vreg_to_sp.get(instr.to_reg_name));
            current_block.instrs.add(sw);
        }
    }
}
