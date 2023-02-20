package asm.graph;

import asm.instruction.MvInstruction;
import asm.operand.Register;

import java.util.HashSet;
import java.util.Objects;

public class InterferenceGraph {
    public HashSet<Edge> edges = new HashSet<>();
    //interference graph的节点本质上是Register，但是因为node除了 Reg之外还要有别的信息，这个信息直接附加到reg里面
    //也就是每一个reg都会联系到一个node上面
    static public class Node{
        public Register reg;
        public int degree;
        public HashSet<Node> adjNodeSet;
        public HashSet<MvInstruction> mvInstrRelated;
        public double weight_to_be_spill;
        public boolean precolored = false;
        public Node(Register reg){
            this.reg = reg;
            degree = 0;
            adjNodeSet = new HashSet<>();
            mvInstrRelated = new HashSet<>();
        }
         public void precolor(){
            this.precolored = true;
            this.degree = Integer.MAX_VALUE;
        }
    }
    // 冲突图是一个无向图，所以每一条边要加两个不同方向的两条边
    static public class Edge{
        public Register reg1;
        public Register reg2;
        public Edge(Register reg1,Register reg2){
            this.reg1 = reg1;
            this.reg2 = reg2;
        }
        @Override
        public boolean equals(Object o){
            return o instanceof Edge e && (e.reg1 == reg1 && e.reg2 == reg2);
        }
    }
    public void addEdge(Register reg1,Register reg2){
        if(reg1 == reg2) return;
        Edge edge = new Edge(reg1, reg2);
        // 主要是将这条边加入到边集合里面，并且在reg1reg2的邻接节点加入
        if(!edges.contains(edge)){
            Edge re_edge = new Edge(reg2,reg1);
            edges.add(edge);
            edges.add(re_edge);
            //加入到reg1和reg2的临界集合里面
        }
    }
}
