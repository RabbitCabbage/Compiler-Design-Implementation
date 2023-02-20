package asm.operand;

import asm.graph.InterferenceGraph.Node;

public abstract class Register extends Operand{
    public Node node_in_ig = new Node(this); //在interference graph中的节点信息
    public abstract String toString();
}
