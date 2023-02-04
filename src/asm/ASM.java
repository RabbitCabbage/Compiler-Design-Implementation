package asm;

import java.util.concurrent.atomic.AtomicInteger;

public class ASM {
    public ASMBuilder builder;
    public ASM(ASMBuilder builder){
        this.builder = builder;
    }
    public String printASM(){
        StringBuilder text = new StringBuilder();
        text.append("\t.text\n");
        builder.functions.forEach(f->{
            text.append("\t.globl\t").append(f.IR_name).append("\n");
            text.append("\t.p2align\t2\n");
            text.append(f.IR_name).append("\n");
            f.blocks.forEach(b->{
                text.append(b.block_id).append(":\n");
                b.instrs.forEach(i->{
                    text.append(i.toString());
                });
            });
            text.append(".Lfunc_end").append(f.function_count).append(":\n");
        });
        if(!builder.stringConstants.isEmpty()) {
            text.append("#    --String Constants\n");
            text.append("\t.section\t.rodata\n");
        }
        for(String str: builder.stringConstants.keySet()){
            StringBuilder content = new StringBuilder();
            content.append(builder.stringConstants.get(str));
            content.deleteCharAt(content.length()-1);
            StringBuilder reg_name = new StringBuilder();
            reg_name.append(str);
            reg_name.deleteCharAt(0);
            text.append(".L").append(reg_name).append(":\n\t.asciz\t\"").append(content).append("\"\n");
        }
        if(!builder.globalVars.isEmpty()){
            text.append("#    --UnInitialized Global Variables;\n");
            text.append("\t.section\t.sbss\n");
        }
        for(var globalvar: builder.globalVars.values()){
            StringBuilder reg_name = new StringBuilder();
            reg_name.append(globalvar.declare.reg_name_for_global);
            reg_name.deleteCharAt(0);
            text.append(reg_name).append(":\n\t.word\t0\n");
        }
        return text.toString();
    }
}
