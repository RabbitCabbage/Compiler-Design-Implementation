package asm;

import asm.graph.*;
import asm.operand.PhysicalRegister;
import asm.operand.RegAllocator;
import ir.LLVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class ASM {
    public ControlFlowGraph cfg;

    public ASM(LLVM ir){
        //先建立控制流图
        CFGBuilder cfg_builder = new CFGBuilder();
        RegAllocator allocator = new RegAllocator(cfg_builder.build(ir););
        allocator.graphColoring();
        cfg = allocator.ask_cfg();
    }

    public String print(){
        StringBuilder text = new StringBuilder();
        cfg.blocks.forEach(a->a.instrs.forEach(b->text.append(b.toString())));
        return text.toString();
    }
}
