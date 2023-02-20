package asm;

import asm.instruction.AddiInstruction;
import asm.instruction.LuiInstruction;
import asm.operand.*;
import ir.ClassIR;
import ir.FunctionIR;
import ir.Instruction.*;
import ir.LLVM;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ASMBuilder {
    public int function_count = 0;
    public FunctionASM current_function;
    public BlockASM current_block;
    public ArrayList<FunctionASM> functions = new ArrayList<>();
    public LinkedHashMap<String, StringConstant> stringConstants = new LinkedHashMap<>();
    public LinkedHashMap<String, GlobalVar> globalVars = new LinkedHashMap<>();
    int tmp_vreg = 0;
    public VirtualRegister getTemporaryVreg(){
        String tmp_name = "kunkun"+String.valueOf(tmp_vreg++);
        VirtualRegister vreg = new VirtualRegister(tmp_name);
        return vreg;
    }
    public void visit(LLVM llvm){
        llvm.stringConstants.keySet().forEach(s->stringConstants.put(s,new StringConstant(s,llvm.stringConstants.get(s))));
        llvm.globalVars.keySet().forEach(g->globalVars.put(llvm.globalVars.get(g).declare.reg_name_for_global,new GlobalVar(g)));
        for(var funcdef: llvm.functions.values()) funcdef.accept(this);
        for(var clsdef: llvm.classes.values()) clsdef.accept(this);
    }
    public void visit(FunctionIR funcdef){
        current_function = new FunctionASM(funcdef);
        current_block = null;
        current_function.function_count = function_count++;
        current_block = new BlockASM("entry", current_function.function_count);
        funcdef.blocks.forEach(block->{
            block.instrs.forEach(inst->{
                if(inst instanceof AllocaInstruction)inst.accept(this);
            });
        });
        funcdef.blocks.forEach(block->{
            if(current_block==null)current_block = new BlockASM(block.block_id.toString(), current_function.function_count);
            block.instrs.forEach(inst->{
                if(!(inst instanceof AllocaInstruction))inst.accept(this);
            });
            current_function.cfg.blocks.add(current_block);
            current_block = null;
        });
        functions.add(current_function);
        current_function = null;
    }
    public Operand getOperand(String operand_str){
        if(operand_str.startsWith("%")){
            if(current_function.spilledVars.containsKey(operand_str))return current_function.spilledVars.get(operand_str);
            else if(current_function.virtualVar.containsKey(operand_str))return current_function.virtualVar.get(operand_str);
        }
        else if(operand_str.startsWith("@")){
            //global 变量本身不能作为有效的operand，所以我们应该，给它一个合适的vreg，并且是tmp的vreg
            // 建立一个新的vreg给这个全局变量
            VirtualRegister vreg_for_global = getTemporaryVreg();
            Relocation hi = new Relocation(globalVars.get(operand_str).global_var_name, Relocation.RelocationType.hi);
            LuiInstruction lui = new LuiInstruction(hi,vreg_for_global);
            AddiInstruction addi = new AddiInstruction(vreg_for_global,vreg_for_global,)
        }
        else if(operand_str.equals("null")){
             return PhysicalRegister.getPhysicalReg("zero");
        }
        return new Immediate(Integer.getInteger(operand_str));
    }
    public void visit(AllocaInstruction instr){
        current_function.stack_pointer += 4;
        current_function.spilledVars.put(instr.res_toString(),new StackPointer(current_function.stack_pointer));
    }
    public void visit(StoreInstruction instr){
        //from reg to to_reg_name
        var from = getOperand(instr.reg);
        var to = getOperand((instr.to_reg_name));
        // from: imm vreg null
        // to: global sp
        // 直接加一个Mv指令可以解决所有问题

    }
    public void visit(LoadInstruction instr){
    }
    public void visit(BitcastInstruction instr){
    }
    public void visit(RetInstruction instr){
    }
    public void visit(CallInstruction instr){
    }
    public void visit(BrInstruction instr){
    }
    public void visit(GetElementPtrInstruction instr){
    }
    public void visit(BinaryInstruction instr){
        VirtualRegister add = new VirtualRegister(instr.res_toString());
        current_function.virtualVar.put(instr.res_toString(),add);
    }
    public void visit(ClassIR classdef){}
}
