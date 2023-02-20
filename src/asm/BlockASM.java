package asm;

import asm.instruction.InstructionASM;
import asm.operand.Register;

import java.util.ArrayList;

//this is the basic block in control flow graph
// every basic block stands for an asm instruction
// every block record its use and def and in_live and out_Live
public class BlockASM {
    public String block_id;
    //这个block的出口入口活跃变量
    //考虑两个指令节点ab的in_live和out_live
    // 这个block的live_out跟这个block里面第一个的相同
    // 这个block的live_in 跟这个block最后一个相同
    public ArrayList<InstructionASM> instrs;//这个节点所代表的instruction
    public ArrayList<Register> def_value;//在这个节点被定值的变量
    public ArrayList<Register> use_value;//在这个节点用到值的变量
    public ArrayList<Register> out_live;//在这个节点出口活跃的变量
    public ArrayList<Register> in_live;//在这个节点入口活跃的变量
    public ArrayList<BlockASM> prevs;
    public ArrayList<BlockASM> nexts;
    public BlockASM(String block_name,int function_count){
        def_value = new ArrayList<>();
        use_value = new ArrayList<>();
        out_live = new ArrayList<>();
        in_live = new ArrayList<>();
        instrs = new ArrayList<>();
        prevs = new ArrayList<>();
        nexts = new ArrayList<>();
        block_id = block_name + String.valueOf(function_count);
    }
    public void add_prev(BlockASM prev){prevs.add(prev);}
    public void add_next(BlockASM next){nexts.add(next);}
    public void add_instr(InstructionASM instr){instrs.add(instr);}
}
