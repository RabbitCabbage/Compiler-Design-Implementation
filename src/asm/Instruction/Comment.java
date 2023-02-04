package asm.Instruction;

public class Comment extends InstructionASM{
    public String comment;
    public Comment(String comment){
        StringBuilder c = new StringBuilder();
        c.append(comment);
        c.deleteCharAt(0);
        this.comment = c.toString();
    }
    public String toString(){
        return "\t#\t--"+comment;
    }
}
