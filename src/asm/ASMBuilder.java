package asm;

import IR.ClassIR;
import IR.FunctionIR;
import IR.GlobalVarIR;
import IR.Instruction.*;
import IR.LLVM;
import asm.Instruction.*;
import org.antlr.v4.runtime.misc.Pair;

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
        //首先存下来所有callee需要存的东西，共26条指令。
        BlockASM callee_save = new BlockASM("callee_save",0);
        MvInstruction mv_ra = new MvInstruction("t0","ra");
        callee_save.instrs.add(mv_ra);
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put("ra", current_function.stack_pointer);
        SwInstruction sw_ra = new SwInstruction("t0",current_function.stack_pointer);
        callee_save.instrs.add(sw_ra);
        for(int i=0;i<12;++i){
            StringBuilder s = new StringBuilder();
            s.append("s").append(i);
            MvInstruction mv_s = new MvInstruction("t0",s.toString());
            callee_save.instrs.add(mv_s);
            current_function.stack_pointer += 4;
            current_function.vreg_to_sp.put(s.toString(), current_function.stack_pointer);
            SwInstruction sw_s = new SwInstruction("t0",current_function.stack_pointer);
            callee_save.instrs.add(sw_s);
        }

        BlockASM callee_restore = new BlockASM("callee_restore",0);
        for(int i =0;i<12;++i){
            StringBuilder s = new StringBuilder();
            s.append("s").append(i);
            LwInstruction lw_s = new LwInstruction("t0",current_function.vreg_to_sp.get(s.toString()));
            callee_restore.instrs.add(lw_s);
            MvInstruction mv_s = new MvInstruction(s.toString(),"t0");
            callee_restore.instrs.add(mv_s);
        }
        LwInstruction lw_ra = new LwInstruction("t0",current_function.vreg_to_sp.get("ra"));
        callee_restore.instrs.add(lw_ra);
        MvInstruction mv_ra_back =  new MvInstruction("ra","t0");
        callee_restore.instrs.add(mv_ra_back);
        System.out.println(funcdef.funcdef.name);
        System.out.println(current_function.stack_pointer);

        //访问alloca，分配alloca所需要的栈空间
        funcdef.blocks.forEach(a->{
            a.instrs.forEach(b->{
                if(b.getClass().toString().equals("class IR.Instruction.AllocaInstruction"))b.accept(this);
            });
        });
        System.out.println(current_function.stack_pointer);

        funcdef.blocks.forEach(a->{
            current_block = new BlockASM(a.block_id.toString(),current_function.function_count);
            if(current_block.block_id.startsWith("entry")){
                current_block.instrs.addAll(callee_save.instrs);
            }
            a.instrs.forEach(b->{
                if(!b.getClass().toString().equals("class IR.Instruction.AllocaInstruction"))b.accept(this);
            });
            current_function.blocks.add(current_block);
        });
        System.out.println(current_function.stack_pointer);

        //确定函数的参数存在哪一个 a_reg, 或者是存在栈的sp是多少，从0开始计算, 如果别的函数调用的话，
        int areg_count = 0;//计算，总共只有8个a reg
        int offset = current_function.stack_pointer + (funcdef.para_names.size()-8)*4;
        //System.out.println(offset);
        for (String para_ir_reg : funcdef.para_names) {
            StringBuilder from = new StringBuilder();
            if(areg_count>=8){
                current_function.stack_pointer += 4;
                int para_ofs = offset - (areg_count-8) * 4;
                System.out.print("spill out ");
                System.out.println(para_ofs);
                from.append(para_ofs).append("(sp)");
            }
            else {
                from.append("a").append(areg_count);
            }
            areg_count++;
            current_function.para_to_areg_sp.put(para_ir_reg,from.toString());
        }
        //访问把函数的参数存到相应地方的那些store指令，store i32 %x, i32* %x.addr
        current_block = new BlockASM("store_para_block",0);//因为访问的时候都收录到current_block
        funcdef.blocks.get(0).instrs.forEach(b->{
            if(b.getClass().toString().equals("class IR.Instruction.StoreInstruction")&&!((StoreInstruction)b).asm_visited)b.accept(this);
        });
        //首先移动sp需要一个指令，但是还没加进来，存ra和s0~s11,总共需要26条指令，所以应该插入到第26位
        for(int i = current_block.instrs.size()-1;i>=0;--i){
            current_function.blocks.get(0).instrs.add(26,current_block.instrs.get(i));
        }
        current_function.stack_pointer += 4;
        System.out.println(current_function.stack_pointer);
        AddiInstruction addi_down = new AddiInstruction("sp","sp",-current_function.stack_pointer);
        AddiInstruction addi_up = new AddiInstruction("sp","sp",current_function.stack_pointer);
        current_function.blocks.get(0).instrs.add(0,addi_down);
        callee_restore.instrs.forEach(a->current_function.blocks.get(current_function.blocks.size()-1).instrs.add(current_function.blocks.get(current_function.blocks.size()-1).instrs.size()-1,a));
        current_function.blocks.get(current_function.blocks.size()-1).instrs.add(current_function.blocks.get(current_function.blocks.size()-1).instrs.size()-1,addi_up);
        functions.add(current_function);
    }
    public void visit(ClassIR classdef){

    }

    public void visit(AllocaInstruction instr){
        //current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
    }
    public void visit(BinaryInstruction instr){
        //current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
    }
    public void visit(BitcastInstruction instr){
        //current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
        // bitcast lw + sw
        LwInstruction lw = new LwInstruction("t0",current_function.vreg_to_sp.get(instr.reg_to_cast));
        current_block.instrs.add(lw);
        SwInstruction sw = new SwInstruction("t0",current_function.vreg_to_sp.get(instr.res_toString()));
        current_block.instrs.add(sw);
    }
    public void visit(BrInstruction instr){
        //current_block.instrs.add(new Comment(instr.toString()));
        if(instr.condition == null){
            JumpInstruction j = new JumpInstruction(instr.label1+"."+String.valueOf(current_function.function_count));
            current_block.instrs.add(j);
            return;
        } else {

        }
    }
    public void visit(CallInstruction instr){
        //current_block.instrs.add(new Comment(instr.toString()));
        //先把参数上传、
        int aug_count = 0;
        for (Pair<Boolean, Pair<Integer, String>> have_value_or_get_reg : instr.para_have_value_or_get_reg) {
            if(aug_count<8){ // 加载到a0~a7
                StringBuilder a = new StringBuilder();
                a.append('a').append(aug_count);
                if(have_value_or_get_reg.a){ // 拿到了值
                    LiInstruction li = new LiInstruction(a.toString(),have_value_or_get_reg.b.a);
                    current_block.instrs.add(li);
                } else {
                    LwInstruction lw = new LwInstruction(a.toString(),current_function.vreg_to_sp.get(have_value_or_get_reg.b.b));
                    current_block.instrs.add(lw);
                }
            } else {
                int offset = (aug_count - 7)* (-4);//从sp向下
                if(have_value_or_get_reg.a){// 拿到了值
                    LiInstruction li = new LiInstruction("t0",have_value_or_get_reg.b.a);
                    current_block.instrs.add(li);
                    SwInstruction sw = new SwInstruction("t0",offset);
                    current_block.instrs.add(sw);
                } else {
                    LwInstruction lw = new LwInstruction("t0",current_function.vreg_to_sp.get(have_value_or_get_reg.b.b));
                    current_block.instrs.add(lw);
                    SwInstruction sw = new SwInstruction("t0",offset);
                    current_block.instrs.add(sw);
                }
            }
            aug_count++;
        }
        //call 相关的函数
        CalInstruction call = new CalInstruction(instr.func_name);
        current_block.instrs.add(call);
        //如果需要返回值，从a0取出返回值
        if(!instr.return_type.equals("void")){
            current_function.stack_pointer += 4;
            current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
            MvInstruction mv = new MvInstruction("t0","a0");
            current_block.instrs.add(mv);
            SwInstruction sw = new SwInstruction("t0",current_function.vreg_to_sp.get(instr.res_toString()));
            current_block.instrs.add(sw);
        }
    }
    public void visit(GetElementPtrInstruction instr){
        //current_block.instrs.add(new Comment(instr.toString()));
        current_function.stack_pointer += 4;
        current_function.vreg_to_sp.put(instr.res_toString(), current_function.stack_pointer);
        if(instr.for_array){
            if(instr.offset_reg.startsWith("%")){
                //说明得到的offset是一个reg，要lw
                LwInstruction lw_ofs = new LwInstruction("t0",current_function.vreg_to_sp.get(instr.offset_reg));
                current_block.instrs.add(lw_ofs);
            } else {
                //得到了offset的数字,li
                LiInstruction li_ofs = new LiInstruction("t0",instr.offset_number);
                current_block.instrs.add(li_ofs);
            }
            SlliInstruction slli = new SlliInstruction("t0","t0",2);
            current_block.instrs.add(slli);
            LwInstruction lw_ptr = new LwInstruction("t1",current_function.vreg_to_sp.get(instr.array_reg));
            current_block.instrs.add(lw_ptr);
            ByInstruction add = new ByInstruction("+","t0","t1","t0");
            current_block.instrs.add(add);
            SwInstruction sw_ptr = new SwInstruction("t0",current_function.vreg_to_sp.get(instr.res_toString()));
            current_block.instrs.add(sw_ptr);
            current_function.reg_contain_memaddr.add(instr.res_toString());
        }
        else if(instr.for_struct){
            LiInstruction li_idx = new LiInstruction("t0",instr.index);
            current_block.instrs.add(li_idx);
            SlliInstruction slli = new SlliInstruction("t0","t0",2);
            current_block.instrs.add(slli);
            LwInstruction lw_ptr = new LwInstruction("t1",current_function.vreg_to_sp.get(instr.instance_reg));
            current_block.instrs.add(lw_ptr);
            ByInstruction add = new ByInstruction("+","t0","t1","t0");
            current_block.instrs.add(add);
            SwInstruction sw_ptr = new SwInstruction("t0",current_function.vreg_to_sp.get(instr.res_toString()));
            current_block.instrs.add(sw_ptr);
            current_function.reg_contain_memaddr.add(instr.res_toString());
        }
        else {
            StringBuilder name = new StringBuilder();
            name.append(instr.instance_reg);
            name.deleteCharAt(0);
            LuiInstruction lui = new LuiInstruction("t0", "%hi(" + name + ")");
            current_block.instrs.add(lui);
            AddiInstruction addi = new AddiInstruction("t0","t0","%lo("+name+")");
            current_block.instrs.add(addi);
            SwInstruction sw = new SwInstruction("t0",current_function.vreg_to_sp.get(instr.result_reg));
            current_block.instrs.add(sw);
        }
    }
    public void visit(LoadInstruction instr){
        //可能的形式是
        // load i32, i32* %hello
        // load i32, i32* @hello
        //current_block.instrs.add(new Comment(instr.toString()));
        if(instr.from_reg_name.startsWith("%")) {
            if(current_function.reg_contain_memaddr.contains(instr.from_reg_name)){
                int from_reg_offset = current_function.vreg_to_sp.get(instr.from_reg_name);
                LwInstruction lw_addr = new LwInstruction("t0", from_reg_offset);
                current_block.instrs.add(lw_addr);//先把值读出来，读到t0,下面就要以t0为偏转读数字了
                LwInstruction lw_num = new LwInstruction("t0","0(t0)");
                current_block.instrs.add(lw_num);//以t0为基准读出数字，并且还放在t0里面
                current_function.stack_pointer += 4;
                String res_reg = "%" + String.valueOf(instr.reg);
                current_function.vreg_to_sp.put(res_reg, current_function.stack_pointer);
                SwInstruction sw = new SwInstruction("t0", current_function.vreg_to_sp.get(res_reg));
                current_block.instrs.add(sw);//再把值写进去，写到resreg对应的
            }
            else {
                int from_reg_offset = current_function.vreg_to_sp.get(instr.from_reg_name);
                LwInstruction lw = new LwInstruction("t0", from_reg_offset);
                current_block.instrs.add(lw);//先把值读出来，读到t0
                current_function.stack_pointer += 4;
                String res_reg = "%" + String.valueOf(instr.reg);
                current_function.vreg_to_sp.put(res_reg, current_function.stack_pointer);
                SwInstruction sw = new SwInstruction("t0", current_function.vreg_to_sp.get(res_reg));
                current_block.instrs.add(sw);//再把值写进去，写到resreg对应的
            }
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
    public void visit(RetInstruction instr){
        //current_block.instrs.add(new Comment(instr.toString()));
        if(!instr.return_void){
            //把返回值存在a0里面,方法是从retval load到t0，再mv到a0
            LwInstruction lw = new LwInstruction("t0",current_function.vreg_to_sp.get(instr.register));
            current_block.instrs.add(lw);
            MvInstruction mv = new MvInstruction("a0","t0");
            current_block.instrs.add(mv);
        }
        RettInstruction ret = new RettInstruction();
        current_block.instrs.add(ret);
    }
    public void visit(StoreInstruction instr){
        if(!instr.get_value && !current_function.para_to_areg_sp.containsKey(instr.reg) && !current_function.vreg_to_sp.containsKey(instr.reg)){
            instr.asm_visited = false;
            return ;//就不访问了
        }else instr.asm_visited = true;
        //current_block.instrs.add(new Comment(instr.toString()));
        //可能的形式
        // store i32 %x, i32* %x.addr
        if(!instr.get_value && current_function.para_to_areg_sp.containsKey(instr.reg)){
            String from = current_function.para_to_areg_sp.get(instr.reg);
            if(from.startsWith("a")){
                SwInstruction sw = new SwInstruction(from, current_function.vreg_to_sp.get(instr.to_reg_name));
                current_block.instrs.add(sw);
            } else {
                LwInstruction lw = new LwInstruction("t0",from);
                current_block.instrs.add(lw);
                SwInstruction sw = new SwInstruction("t0",current_function.vreg_to_sp.get(instr.to_reg_name));
                current_block.instrs.add(sw);
            }
            return;
        }
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
            if(current_function.reg_contain_memaddr.contains(instr.to_reg_name)){
                //需要向内存写
                LwInstruction lw_addr = new LwInstruction("t1",current_function.vreg_to_sp.get(instr.to_reg_name));
                current_block.instrs.add(lw_addr);//首先得到地址，放在t1
                SwInstruction sw = new SwInstruction("t0","0(t1)");//然后以t1内容作为地址读一个数字
                current_block.instrs.add(sw);
            } else {
                SwInstruction sw = new SwInstruction("t0", current_function.vreg_to_sp.get(instr.to_reg_name));
                current_block.instrs.add(sw);
            }
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
