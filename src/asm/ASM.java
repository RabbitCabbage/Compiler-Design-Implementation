package asm;

import java.util.concurrent.atomic.AtomicInteger;

public class ASM {
    public ASMBuilder builder;
    public ASM(ASMBuilder builder){
        this.builder = builder;
    }
    public String printASM(){
        StringBuilder text = new StringBuilder();
        if(!builder.globalVars.isEmpty()||!builder.stringConstants.isEmpty()) {
            text.append("\t.data\n");
        }
        for(var globalvar: builder.globalVars.values()){
            StringBuilder reg_name = new StringBuilder();
            reg_name.append(globalvar.declare.reg_name_for_global);
            reg_name.deleteCharAt(0);
            text.append("\t.globl\t").append(reg_name).append("\n");
            text.append(reg_name).append(":\n\t.word\t0\n");
        }
        for(String str: builder.stringConstants.keySet()){
            StringBuilder content = new StringBuilder();
            content.append(builder.stringConstants.get(str));
            content.deleteCharAt(content.length()-1);
            String con = content.toString();
            con = con.replace("\\","\\\\");
            con = con.replace("\n","\\n");
            con = con.replace("\t","\\t");
            con = con.replace("\"","\\\"");
            con = con.replace("\0","\\0");
            StringBuilder reg_name = new StringBuilder();
            reg_name.append(str);
            reg_name.deleteCharAt(0);
            text.append("\t.globl\t").append(reg_name).append("\n");
            text.append(reg_name).append(":\n\t.asciz\t\"").append(con).append("\"\n");
        }
        text.append("\t.text\n");
        builder.functions.forEach(f->{
            text.append("\t.globl\t").append(f.IR_name).append("\n");
            text.append(f.IR_name).append(":\n");
            f.blocks.forEach(b->{
                text.append(b.block_id).append(":\n");
                b.instrs.forEach(i->{
                    text.append(i.toString());
                });
            });
        });
        return text.toString();
    }
}
