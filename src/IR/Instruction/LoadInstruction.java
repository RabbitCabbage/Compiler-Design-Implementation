package IR.Instruction;

public class LoadInstruction extends InstructionIR{
    public int reg;
    public String name;
    public String type;

    public LoadInstruction(int reg,String name,String type){
        super();
        this.reg = reg;
        this.name = name;
        this.type = type;
    }
    @Override
    public String toString(){
        StringBuilder load = new StringBuilder();
        load.append("\t%").append(reg).append(" = load ").append(type).append(", "+type+"* %"+name+"\n");
        return load.toString();
    }
}
