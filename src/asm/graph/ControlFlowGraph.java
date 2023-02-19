package asm.graph;

import java.util.ArrayList;

//这是一个有向图，每一个节点记下的有prevs nexts
public class ControlFlowGraph {
    public ArrayList<ASMBlock> blocks;
    public ControlFlowGraph(){
        blocks = new ArrayList<>();
    }
    public void addBlock(ASMBlock block){
        blocks.add(block);
    }
}
