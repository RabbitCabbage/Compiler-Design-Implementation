package asm.graph;

import asm.BlockASM;

import java.util.ArrayList;

//这是一个有向图，每一个节点记下的有prevs nexts
public class ControlFlowGraph {
    public ArrayList<BlockASM> blocks;
    public ControlFlowGraph(){
        blocks = new ArrayList<>();
    }
    public void addBlock(BlockASM block){
        blocks.add(block);
    }
    public void linkBlock(BlockASM prev, BlockASM next){
        prev.nexts.add(next);
        next.prevs.add(prev);
    }
}
