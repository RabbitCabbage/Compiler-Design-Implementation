package IR.Instruction;

public class BitcastInstruction extends InstructionIR{
    public String from_type;
    public String to_type;
    public String reg_to_cast;
    public int result_reg;
    public BitcastInstruction(String from, String to,String reg,int res){
        from_type = from;
        to_type = to;
        result_reg = res;
        reg_to_cast = reg;
    }
    @Override
    public String toString(){
        StringBuilder bitcast = new StringBuilder();
        bitcast.append("\t%").append(result_reg).append(" = bitcast ").append(from_type).append(" %").append(reg_to_cast).append(" to ").append(to_type).append("\n");
        return bitcast.toString();
    }
    public String res_toString(){
        StringBuilder res_reg = new StringBuilder();
        res_reg.append(result_reg);
        return res_reg.toString();
    }
}
