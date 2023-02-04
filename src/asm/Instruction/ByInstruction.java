package asm.Instruction;

public class ByInstruction extends InstructionASM{
    public String opcode;
    public String reg_1;
    public String reg_2;
    public String to_reg_name;
    public ByInstruction(String op,String rs1,String rs2,String rd){
        opcode = op;
        reg_1 = rs1;
        reg_2 = rs2;
        to_reg_name = rd;
    }
    public String toString(){
        StringBuilder by = new StringBuilder();
        if(opcode.equals("+"))by.append("\tadd\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("-"))by.append("\tsub\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("*"))by.append("\tmul\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("/"))by.append("\tdiv\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("%"))by.append("\trem\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("<<"))by.append("\tsll\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals(">>"))by.append("\tsra\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("&"))by.append("\tand\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("|"))by.append("\tor\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("^"))by.append("\txor\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals("<"))by.append("\tslt\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        else if(opcode.equals(">"))by.append("\tslt\t").append(to_reg_name).append(",\t").append(reg_2).append(",\t").append(reg_1).append("\n");
        else if(opcode.equals("<=")){
            by.append("\tslt\t").append(reg_1).append(",\t").append(reg_2).append(",\t").append(reg_1).append("\n");
            by.append("\txori\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(1).append("\n");
        } else if(opcode.equals(">=")){
            by.append("\tslt\t").append(reg_1).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
            by.append("\txori\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(1).append("\n");
        } else if(opcode.equals("==")){
            by.append("\tsub\t").append(reg_1).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
            SeqzInstruction seqz = new SeqzInstruction(to_reg_name,reg_1);
            by.append(seqz.toString());
        } else if(opcode.equals("!=")){
            by.append("\tsub\t").append(reg_1).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
            SnezInstruction snez = new SnezInstruction(to_reg_name,reg_1);
            by.append(snez.toString());
        }
        return by.toString();
    }
}
