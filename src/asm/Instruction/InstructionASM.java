package asm.instruction;

import asm.operand.Register;

import java.util.ArrayList;

public abstract class InstructionASM {
    public ArrayList<Register> def_value;
    public ArrayList<Register> use_value;
    public ArrayList<Register> out_live;
    public ArrayList<Register> in_live;
    public InstructionASM(){
        def_value = new ArrayList<>();
        use_value = new ArrayList<>();
        out_live = new ArrayList<>();
        in_live = new ArrayList<>();
    }
    public abstract  String toString();
}
