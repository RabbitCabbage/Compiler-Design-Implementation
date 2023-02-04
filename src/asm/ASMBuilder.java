package asm;

import IR.ClassIR;
import IR.FunctionIR;
import IR.GlobalVarIR;
import IR.Instruction.*;
import IR.Instruction.CallInstruction;
import IR.LLVM;
import asm.Instruction.*;

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
            a.instrs.forEach(b->{
                if(b.getClass().toString().equals("class IR.Instruction.AllocaInstruction"))b.accept(this);
            });
        });
        funcdef.blocks.forEach(a->{
            current_block = new BlockASM(a.block_id.toString(),current_function.function_count);
            a.instrs.forEach(b->{
                if(!b.getClass().toString().equals("class IR.Instruction.AllocaInstruction"))b.accept(this);
            });
            current_function.blocks.add(current_block);
        });
        functions.add(current_function);
    }
    public void visit(ClassIR classdef){

    }

    public void visit(AllocaInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
    }
    public void visit(BinaryInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
    }
    public void visit(BitcastInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
    }
    public void visit(BrInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
    }
    public void visit(CallInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
        if(!instr.return_type.equals("void")){
            current_function.stack_pointer += 4;
            current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
        }
    }
    public void visit(GetElementPtrInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
    }
    public void visit(LoadInstruction instr){
        //可能的形式是
        // load i32, i32* %hello
        // load i32, i32* @hello
        current_block.instrs.add(new Comment(instr.toString()));
        if(instr.from_reg_name.startsWith("%")) {
            int from_reg_offset = current_function.vreg_to_sp.get(instr.from_reg_name);
            LwInstruction lw = new LwInstruction("t0", from_reg_offset);
            current_block.instrs.add(lw);//先把值读出来，读到t0
            current_function.stack_pointer += 4;
            String res_reg = "%" + String.valueOf(instr.reg);
            current_function.vreg_to_sp.put(res_reg, instr.reg);
            SwInstruction sw = new SwInstruction("t0", current_function.vreg_to_sp.get(res_reg));
            current_block.instrs.add(sw);//再把值写进去，写到resreg对应的
        } else {
            StringBuilder name = new StringBuilder();
            name.append(instr.from_reg_name);
            name.deleteCharAt(0);
            LuiInstruction lui = new LuiInstruction("t1", "%hi(" + name + ")");
            current_block.instrs.add(lui);
            LwInstruction lw = new LwInstruction("t0","%lo("+name+")(t1)");
            current_block.instrs.add(lw);
            current_function.stack_pointer += 4;
            String res_reg = "%" + String.valueOf(instr.reg);
            current_function.vreg_to_sp.put(res_reg, current_function.stack_pointer);
            SwInstruction sw = new SwInstruction("t0", current_function.vreg_to_sp.get(res_reg));
            current_block.instrs.add(sw);//再把值写进去，写到resreg对应的
        }
    }
    public void visit(PhiInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
    }
    public void visit(RetInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
    }
    public void visit(StoreInstruction instr){
        current_block.instrs.add(new Comment(instr.toString()));
        //可能的形式
        // store i32 100, i32* %hello;
        // store i32 %0, i32* %hello
        // store i32 100, i32* @global
        // store i32 %0, i32* @global
        if(instr.get_value){//rs存到t0
            LiInstruction li = new LiInstruction("t0",instr.number);
            current_block.instrs.add(li);
        }
        else {
            LwInstruction lw = new LwInstruction("t0",current_function.vreg_to_sp.get(instr.reg));
            current_block.instrs.add(lw);
        }
        if(instr.to_reg_name.startsWith("%")) {
            SwInstruction sw = new SwInstruction("t0", current_function.vreg_to_sp.get(instr.to_reg_name));
            current_block.instrs.add(sw);
        } else {
            StringBuilder name = new StringBuilder();
            name.append(instr.to_reg_name);
            name.deleteCharAt(0);
            LuiInstruction lui = new LuiInstruction("t1", "%hi(" + name + ")");
            current_block.instrs.add(lui);
            SwInstruction sw = new SwInstruction("t0","%lo("+name+")(t1)");
            current_block.instrs.add(sw);
        }
    }
}
