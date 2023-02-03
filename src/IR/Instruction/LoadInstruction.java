package IR.Instruction;

import asm.ASMBuilder;

public class LoadInstruction extends InstructionIR{
    public int reg;
    public String from_reg_name;
    public String type;
    public LoadInstruction(int reg,String from_reg_name,String type){
        super();
        this.reg = reg;
        this.from_reg_name = from_reg_name;
        this.type = type;
    }
    @Override
    public String toString(){
        StringBuilder load = new StringBuilder();
        load.append("\t%").append(reg).append(" = load ").append(type).append(", "+type+"* "+from_reg_name+"\n");
        return load.toString();
    }

    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
