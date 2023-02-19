package asm.operand;

import asm.graph.ControlFlowGraph;
import asm.graph.IGBuilder;
import asm.graph.IGNode;
import asm.graph.InterferenceGraph;
import asm.instruction.MvInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class RegAllocator {
    public ControlFlowGraph cfg;
    public Queue<IGNode> simplify_worklist;
    public Queue<IGNode> freeze_worklist;
    public Queue<IGNode> spill_worklist;
    public ArrayList<IGNode> spilled_nodes;
    public ArrayList<IGNode> coalesced_nodes;
    public Stack<IGNode> select_stack;
    public HashMap<IGNode, PhysicalRegister> colored_nodes;
    public ArrayList<IGNode> precolored;
    public Queue<MvInstruction> mv_worklist;
    public ArrayList<MvInstruction> coalesced_mvs;
    public ArrayList<MvInstruction> constrained_mvs;
    public ArrayList<MvInstruction> frozen_mvs;
    public ArrayList<MvInstruction> active_mvs;
    public RegAllocator(ControlFlowGraph cfg){
        this.cfg = cfg;
    }
    void livenessAnalysis(){}
    void makeWorklists(){}
    void simplify(){}
    void coalesce(){}
    void freeze(){}
    void selectSpill(){}
    void assignColors(){}
    void rewriteCFG(){}
    public void graphColoring(){
        //先对CFG进行活跃性分析
        livenessAnalysis();
        //再建立冲突图
        IGBuilder ig_builder = new IGBuilder();
        InterferenceGraph ig = ig_builder.build(cfg);
        //建立起需要用到的工作表
        makeWorklists();
        //再用reg allocator处理冲突图。
        do{
            if(!simplify_worklist.isEmpty())simplify();
            else if(!mv_worklist.isEmpty()) coalesce();
            else if(!freeze_worklist.isEmpty()) freeze();
            else if(!spill_worklist.isEmpty()) selectSpill();
        }while(!simplify_worklist.isEmpty()||!mv_worklist.isEmpty()||!freeze_worklist.isEmpty()||!spill_worklist.isEmpty());
    }
    public ControlFlowGraph ask_cfg(){
        return cfg;
    }
}
