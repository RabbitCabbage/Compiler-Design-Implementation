package IR.Instruction;

public class LoadInstruction extends InstructionIR{
    public int reg;
    public String name;
    public String type;
    public boolean global;
    public LoadInstruction(int reg,String name,String type,boolean global){
        super();
        this.reg = reg;
        this.name = name;
        this.type = type;
        this.global = global;
    }
    @Override
    public String toString(){
        StringBuilder load = new StringBuilder();
        if(!global)load.append("\t%").append(reg).append(" = load ").append(type).append(", "+type+"* %"+name+"\n");
        else load.append("\t%").append(reg).append(" = load ").append(type).append(", "+type+"* @"+name+"\n");
        return load.toString();
    }
}
