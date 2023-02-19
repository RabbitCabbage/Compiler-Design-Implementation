package ir.Instruction;

import asm.ASMBuilder;

public class BinaryInstruction extends InstructionIR{
    public String opcode;
    public String lhs_reg;
    public String rhs_reg;
    public int result_reg;
    public String type;
    public BinaryInstruction(String opcode, String lhs_reg,String rhs_reg,String t,int result){
        this.opcode = opcode;
        this.lhs_reg = lhs_reg;
        this.rhs_reg = rhs_reg;
        result_reg = result;
        type = t;
    }
    public String res_toString(){
        StringBuilder reg = new StringBuilder();
        reg.append("%");
        if(opcode.equals("+"))reg.append("add").append(result_reg);
        else if(opcode.equals("-"))reg.append("sub").append(result_reg);
        else if(opcode.equals("*"))reg.append("mul").append(result_reg);
        else if(opcode.equals("/"))reg.append("sdiv").append(result_reg);
        else if(opcode.equals("%"))reg.append("srem").append(result_reg);
        else if(opcode.equals("<<"))reg.append("shl").append(result_reg);
        else if(opcode.equals(">>"))reg.append("ashr").append(result_reg);
        else if(opcode.equals("&"))reg.append("and").append(result_reg);
        else if(opcode.equals("|"))reg.append("or").append(result_reg);
        else if(opcode.equals("^"))reg.append("xor").append(result_reg);
        else if(opcode.equals("==")||opcode.equals("!=")||opcode.equals("<")||opcode.equals("<=")||opcode.equals(">")||opcode.equals(">="))
            reg.append("cmp").append(result_reg);
        //System.out.println(reg.toString());
        return reg.toString();    }
    public String toString(){
        //System.out.println(lhs_reg);
        //System.out.println(rhs_reg);
        StringBuilder binary = new StringBuilder();
        if(opcode.equals("+"))binary.append("\t%").append("add").append(result_reg).append(" = add ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("-"))binary.append("\t%").append("sub").append(result_reg).append(" = sub ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("*"))binary.append("\t%").append("mul").append(result_reg).append(" = mul ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("/"))binary.append("\t%").append("sdiv").append(result_reg).append(" = sdiv ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("%"))binary.append("\t%").append("srem").append(result_reg).append(" = srem ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("<<"))binary.append("\t%").append("shl").append(result_reg).append(" = shl ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals(">>"))binary.append("\t%").append("ashr").append(result_reg).append(" = ashr ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("&"))binary.append("\t%").append("and").append(result_reg).append(" = and ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("|"))binary.append("\t%").append("or").append(result_reg).append(" = or ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("^"))binary.append("\t%").append("xor").append(result_reg).append(" = xor ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("=="))binary.append("\t%").append("cmp").append(result_reg).append(" = ").append("icmp eq ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("!="))binary.append("\t%").append("cmp").append(result_reg).append(" = ").append("icmp ne ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("<"))binary.append("\t%").append("cmp").append(result_reg).append(" = ").append("icmp slt ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals("<="))binary.append("\t%").append("cmp").append(result_reg).append(" = ").append("icmp sle ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals(">"))binary.append("\t%").append("cmp").append(result_reg).append(" = ").append("icmp sgt ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        else if(opcode.equals(">="))binary.append("\t%").append("cmp").append(result_reg).append(" = ").append("icmp sge ").append(type).append(" ").append(lhs_reg).append(", ").append(rhs_reg).append("\n");
        return binary.toString();
    }
    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
