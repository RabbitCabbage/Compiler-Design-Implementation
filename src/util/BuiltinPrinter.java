package util;

public class BuiltinPrinter {
    public String toString(){
        String builtin_dot_s = "\t.text\n" +
                "\t.file\t\"builtin.c\"\n" +
                "\t.globl\tprint                   # -- Begin function print\n" +
                "\t.p2align\t2\n" +
                "\t.type\tprint,@function\n" +
                "print:                                  # @print\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -16\n" +
                "\t.cfi_def_cfa_offset 16\n" +
                "\tsw\tra, 12(sp)\n" +
                "\tsw\ts0, 8(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 16\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tlw\ta1, -16(s0)\n" +
                "\tlui\ta0, %hi(.L.str)\n" +
                "\taddi\ta0, a0, %lo(.L.str)\n" +
                "\tcall\tprintf\n" +
                "\tlw\ts0, 8(sp)\n" +
                "\tlw\tra, 12(sp)\n" +
                "\taddi\tsp, sp, 16\n" +
                "\tret\n" +
                ".Lfunc_end0:\n" +
                "\t.size\tprint, .Lfunc_end0-print\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tprintln                 # -- Begin function println\n" +
                "\t.p2align\t2\n" +
                "\t.type\tprintln,@function\n" +
                "println:                                # @println\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -16\n" +
                "\t.cfi_def_cfa_offset 16\n" +
                "\tsw\tra, 12(sp)\n" +
                "\tsw\ts0, 8(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 16\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tlw\ta1, -16(s0)\n" +
                "\tlui\ta0, %hi(.L.str.1)\n" +
                "\taddi\ta0, a0, %lo(.L.str.1)\n" +
                "\tcall\tprintf\n" +
                "\tlw\ts0, 8(sp)\n" +
                "\tlw\tra, 12(sp)\n" +
                "\taddi\tsp, sp, 16\n" +
                "\tret\n" +
                ".Lfunc_end1:\n" +
                "\t.size\tprintln, .Lfunc_end1-println\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tprintInt                # -- Begin function printInt\n" +
                "\t.p2align\t2\n" +
                "\t.type\tprintInt,@function\n" +
                "printInt:                               # @printInt\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -16\n" +
                "\t.cfi_def_cfa_offset 16\n" +
                "\tsw\tra, 12(sp)\n" +
                "\tsw\ts0, 8(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 16\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -12(s0)\n" +
                "\tlw\ta1, -12(s0)\n" +
                "\tlui\ta0, %hi(.L.str.2)\n" +
                "\taddi\ta0, a0, %lo(.L.str.2)\n" +
                "\tcall\tprintf\n" +
                "\tlw\ts0, 8(sp)\n" +
                "\tlw\tra, 12(sp)\n" +
                "\taddi\tsp, sp, 16\n" +
                "\tret\n" +
                ".Lfunc_end2:\n" +
                "\t.size\tprintInt, .Lfunc_end2-printInt\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tprintlnInt              # -- Begin function printlnInt\n" +
                "\t.p2align\t2\n" +
                "\t.type\tprintlnInt,@function\n" +
                "printlnInt:                             # @printlnInt\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -16\n" +
                "\t.cfi_def_cfa_offset 16\n" +
                "\tsw\tra, 12(sp)\n" +
                "\tsw\ts0, 8(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 16\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -12(s0)\n" +
                "\tlw\ta1, -12(s0)\n" +
                "\tlui\ta0, %hi(.L.str.3)\n" +
                "\taddi\ta0, a0, %lo(.L.str.3)\n" +
                "\tcall\tprintf\n" +
                "\tlw\ts0, 8(sp)\n" +
                "\tlw\tra, 12(sp)\n" +
                "\taddi\tsp, sp, 16\n" +
                "\tret\n" +
                ".Lfunc_end3:\n" +
                "\t.size\tprintlnInt, .Lfunc_end3-printlnInt\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tgetString               # -- Begin function getString\n" +
                "\t.p2align\t2\n" +
                "\t.type\tgetString,@function\n" +
                "getString:                              # @getString\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -16\n" +
                "\t.cfi_def_cfa_offset 16\n" +
                "\tsw\tra, 12(sp)\n" +
                "\tsw\ts0, 8(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 16\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\taddi\ta0, zero, 256\n" +
                "\tmv\ta1, zero\n" +
                "\tcall\tmalloc\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tlw\ta1, -16(s0)\n" +
                "\tlui\ta0, %hi(.L.str)\n" +
                "\taddi\ta0, a0, %lo(.L.str)\n" +
                "\tcall\t__isoc99_scanf\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ts0, 8(sp)\n" +
                "\tlw\tra, 12(sp)\n" +
                "\taddi\tsp, sp, 16\n" +
                "\tret\n" +
                ".Lfunc_end4:\n" +
                "\t.size\tgetString, .Lfunc_end4-getString\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tgetInt                  # -- Begin function getInt\n" +
                "\t.p2align\t2\n" +
                "\t.type\tgetInt,@function\n" +
                "getInt:                                 # @getInt\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -16\n" +
                "\t.cfi_def_cfa_offset 16\n" +
                "\tsw\tra, 12(sp)\n" +
                "\tsw\ts0, 8(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 16\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tlui\ta0, %hi(.L.str.2)\n" +
                "\taddi\ta0, a0, %lo(.L.str.2)\n" +
                "\taddi\ta1, s0, -12\n" +
                "\tcall\t__isoc99_scanf\n" +
                "\tlw\ta0, -12(s0)\n" +
                "\tlw\ts0, 8(sp)\n" +
                "\tlw\tra, 12(sp)\n" +
                "\taddi\tsp, sp, 16\n" +
                "\tret\n" +
                ".Lfunc_end5:\n" +
                "\t.size\tgetInt, .Lfunc_end5-getInt\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\ttoString                # -- Begin function toString\n" +
                "\t.p2align\t2\n" +
                "\t.type\ttoString,@function\n" +
                "toString:                               # @toString\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -16\n" +
                "\t.cfi_def_cfa_offset 16\n" +
                "\tsw\tra, 12(sp)\n" +
                "\tsw\ts0, 8(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 16\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -12(s0)\n" +
                "\taddi\ta0, zero, 256\n" +
                "\tmv\ta1, zero\n" +
                "\tcall\tmalloc\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta2, -12(s0)\n" +
                "\tlui\ta1, %hi(.L.str.2)\n" +
                "\taddi\ta1, a1, %lo(.L.str.2)\n" +
                "\tcall\tsprintf\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ts0, 8(sp)\n" +
                "\tlw\tra, 12(sp)\n" +
                "\taddi\tsp, sp, 16\n" +
                "\tret\n" +
                ".Lfunc_end6:\n" +
                "\t.size\ttoString, .Lfunc_end6-toString\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tmalloc_                 # -- Begin function malloc_\n" +
                "\t.p2align\t2\n" +
                "\t.type\tmalloc_,@function\n" +
                "malloc_:                                # @malloc_\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -12(s0)\n" +
                "\tsw\ta1, -16(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\taddi\ta0, a0, 4\n" +
                "\tsrai\ta1, a0, 31\n" +
                "\tcall\tmalloc\n" +
                "\tsw\ta0, -24(s0)\n" +
                "\tlw\ta0, -24(s0)\n" +
                "\taddi\ta0, a0, 4\n" +
                "\tlw\ta2, -16(s0)\n" +
                "\tmv\ta1, zero\n" +
                "\tcall\tmemset\n" +
                "\tlw\ta0, -24(s0)\n" +
                "\tsw\ta0, -32(s0)\n" +
                "\tlw\ta0, -12(s0)\n" +
                "\tlw\ta1, -32(s0)\n" +
                "\tsw\ta0, 0(a1)\n" +
                "\tlw\ta0, -24(s0)\n" +
                "\taddi\ta0, a0, 4\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end7:\n" +
                "\t.size\tmalloc_, .Lfunc_end7-malloc_\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tgetArraySize            # -- Begin function getArraySize\n" +
                "\t.p2align\t2\n" +
                "\t.type\tgetArraySize,@function\n" +
                "getArraySize:                           # @getArraySize\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\taddi\ta0, a0, -4\n" +
                "\tsw\ta0, -24(s0)\n" +
                "\tlw\ta0, -24(s0)\n" +
                "\tlw\ta0, 0(a0)\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end8:\n" +
                "\t.size\tgetArraySize, .Lfunc_end8-getArraySize\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_length           # -- Begin function string_length\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_length,@function\n" +
                "string_length:                          # @string_length\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -16\n" +
                "\t.cfi_def_cfa_offset 16\n" +
                "\tsw\tra, 12(sp)\n" +
                "\tsw\ts0, 8(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 16\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tcall\tstrlen\n" +
                "\tlw\ts0, 8(sp)\n" +
                "\tlw\tra, 12(sp)\n" +
                "\taddi\tsp, sp, 16\n" +
                "\tret\n" +
                ".Lfunc_end9:\n" +
                "\t.size\tstring_length, .Lfunc_end9-string_length\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_substring        # -- Begin function string_substring\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_substring,@function\n" +
                "string_substring:                       # @string_substring\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -48\n" +
                "\t.cfi_def_cfa_offset 48\n" +
                "\tsw\tra, 44(sp)\n" +
                "\tsw\ts0, 40(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 48\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tsw\ta1, -20(s0)\n" +
                "\tsw\ta2, -24(s0)\n" +
                "\tlw\ta0, -24(s0)\n" +
                "\tlw\ta1, -20(s0)\n" +
                "\tsub\ta0, a0, a1\n" +
                "\taddi\ta0, a0, 1\n" +
                "\tsrai\ta1, a0, 31\n" +
                "\tcall\tmalloc\n" +
                "\tsw\ta0, -32(s0)\n" +
                "\tlw\ta0, -20(s0)\n" +
                "\tsw\ta0, -36(s0)\n" +
                "\tj\t.LBB10_1\n" +
                ".LBB10_1:                               # %for.cond\n" +
                "                                        # =>This Inner Loop Header: Depth=1\n" +
                "\tlw\ta0, -36(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tbge\ta0, a1, .LBB10_4\n" +
                "\tj\t.LBB10_2\n" +
                ".LBB10_2:                               # %for.body\n" +
                "                                        #   in Loop: Header=BB10_1 Depth=1\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta1, -36(s0)\n" +
                "\tadd\ta0, a0, a1\n" +
                "\tlb\ta0, 0(a0)\n" +
                "\tlw\ta2, -32(s0)\n" +
                "\tlw\ta3, -20(s0)\n" +
                "\tsub\ta1, a1, a3\n" +
                "\tadd\ta1, a2, a1\n" +
                "\tsb\ta0, 0(a1)\n" +
                "\tj\t.LBB10_3\n" +
                ".LBB10_3:                               # %for.inc\n" +
                "                                        #   in Loop: Header=BB10_1 Depth=1\n" +
                "\tlw\ta0, -36(s0)\n" +
                "\taddi\ta0, a0, 1\n" +
                "\tsw\ta0, -36(s0)\n" +
                "\tj\t.LBB10_1\n" +
                ".LBB10_4:                               # %for.end\n" +
                "\tlw\ta0, -32(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tlw\ta2, -20(s0)\n" +
                "\tsub\ta1, a1, a2\n" +
                "\tadd\ta0, a0, a1\n" +
                "\tsb\tzero, 0(a0)\n" +
                "\tlw\ta0, -32(s0)\n" +
                "\tlw\ts0, 40(sp)\n" +
                "\tlw\tra, 44(sp)\n" +
                "\taddi\tsp, sp, 48\n" +
                "\tret\n" +
                ".Lfunc_end10:\n" +
                "\t.size\tstring_substring, .Lfunc_end10-string_substring\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_parseInt         # -- Begin function string_parseInt\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_parseInt,@function\n" +
                "string_parseInt:                        # @string_parseInt\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlui\ta1, %hi(.L.str.2)\n" +
                "\taddi\ta1, a1, %lo(.L.str.2)\n" +
                "\taddi\ta2, s0, -20\n" +
                "\tcall\t__isoc99_sscanf\n" +
                "\tlw\ta0, -20(s0)\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end11:\n" +
                "\t.size\tstring_parseInt, .Lfunc_end11-string_parseInt\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_ord              # -- Begin function string_ord\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_ord,@function\n" +
                "string_ord:                             # @string_ord\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tsw\ta1, -20(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta1, -20(s0)\n" +
                "\tadd\ta0, a0, a1\n" +
                "\tlb\ta0, 0(a0)\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end12:\n" +
                "\t.size\tstring_ord, .Lfunc_end12-string_ord\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_concat           # -- Begin function string_concat\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_concat,@function\n" +
                "string_concat:                          # @string_concat\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -48\n" +
                "\t.cfi_def_cfa_offset 48\n" +
                "\tsw\tra, 44(sp)\n" +
                "\tsw\ts0, 40(sp)\n" +
                "\tsw\ts1, 36(sp)\n" +
                "\tsw\ts2, 32(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\t.cfi_offset s1, -12\n" +
                "\t.cfi_offset s2, -16\n" +
                "\taddi\ts0, sp, 48\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -24(s0)\n" +
                "\tsw\ta1, -32(s0)\n" +
                "\tlw\ta0, -24(s0)\n" +
                "\tcall\tstrlen\n" +
                "\tmv\ts1, a0\n" +
                "\tmv\ts2, a1\n" +
                "\tlw\ta0, -32(s0)\n" +
                "\tcall\tstrlen\n" +
                "\tadd\ta1, s2, a1\n" +
                "\tadd\ta2, s1, a0\n" +
                "\tsltu\ta0, a2, s1\n" +
                "\tadd\ta1, a1, a0\n" +
                "\taddi\ta0, a2, 1\n" +
                "\tsltu\ta2, a0, a2\n" +
                "\tadd\ta1, a1, a2\n" +
                "\tcall\tmalloc\n" +
                "\tsw\ta0, -40(s0)\n" +
                "\tlw\ta0, -40(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tcall\tstrcpy\n" +
                "\tlw\ta0, -40(s0)\n" +
                "\tlw\ta1, -32(s0)\n" +
                "\tcall\tstrcat\n" +
                "\tlw\ta0, -40(s0)\n" +
                "\tlw\ts2, 32(sp)\n" +
                "\tlw\ts1, 36(sp)\n" +
                "\tlw\ts0, 40(sp)\n" +
                "\tlw\tra, 44(sp)\n" +
                "\taddi\tsp, sp, 48\n" +
                "\tret\n" +
                ".Lfunc_end13:\n" +
                "\t.size\tstring_concat, .Lfunc_end13-string_concat\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_equal            # -- Begin function string_equal\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_equal,@function\n" +
                "string_equal:                           # @string_equal\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tsw\ta1, -24(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tcall\tstrcmp\n" +
                "\tseqz\ta0, a0\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end14:\n" +
                "\t.size\tstring_equal, .Lfunc_end14-string_equal\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_nequal           # -- Begin function string_nequal\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_nequal,@function\n" +
                "string_nequal:                          # @string_nequal\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tsw\ta1, -24(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tcall\tstrcmp\n" +
                "\tsnez\ta0, a0\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end15:\n" +
                "\t.size\tstring_nequal, .Lfunc_end15-string_nequal\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_lessthan         # -- Begin function string_lessthan\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_lessthan,@function\n" +
                "string_lessthan:                        # @string_lessthan\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tsw\ta1, -24(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tcall\tstrcmp\n" +
                "\tsrli\ta0, a0, 31\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end16:\n" +
                "\t.size\tstring_lessthan, .Lfunc_end16-string_lessthan\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_greaterthan      # -- Begin function string_greaterthan\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_greaterthan,@function\n" +
                "string_greaterthan:                     # @string_greaterthan\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tsw\ta1, -24(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tcall\tstrcmp\n" +
                "\tsgtz\ta0, a0\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end17:\n" +
                "\t.size\tstring_greaterthan, .Lfunc_end17-string_greaterthan\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_notgreaterthan   # -- Begin function string_notgreaterthan\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_notgreaterthan,@function\n" +
                "string_notgreaterthan:                  # @string_notgreaterthan\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tsw\ta1, -24(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tcall\tstrcmp\n" +
                "\tslti\ta0, a0, 1\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end18:\n" +
                "\t.size\tstring_notgreaterthan, .Lfunc_end18-string_notgreaterthan\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.globl\tstring_notlessthan      # -- Begin function string_notlessthan\n" +
                "\t.p2align\t2\n" +
                "\t.type\tstring_notlessthan,@function\n" +
                "string_notlessthan:                     # @string_notlessthan\n" +
                "\t.cfi_startproc\n" +
                "# %bb.0:                                # %entry\n" +
                "\taddi\tsp, sp, -32\n" +
                "\t.cfi_def_cfa_offset 32\n" +
                "\tsw\tra, 28(sp)\n" +
                "\tsw\ts0, 24(sp)\n" +
                "\t.cfi_offset ra, -4\n" +
                "\t.cfi_offset s0, -8\n" +
                "\taddi\ts0, sp, 32\n" +
                "\t.cfi_def_cfa s0, 0\n" +
                "\tsw\ta0, -16(s0)\n" +
                "\tsw\ta1, -24(s0)\n" +
                "\tlw\ta0, -16(s0)\n" +
                "\tlw\ta1, -24(s0)\n" +
                "\tcall\tstrcmp\n" +
                "\tnot\ta0, a0\n" +
                "\tsrli\ta0, a0, 31\n" +
                "\tlw\ts0, 24(sp)\n" +
                "\tlw\tra, 28(sp)\n" +
                "\taddi\tsp, sp, 32\n" +
                "\tret\n" +
                ".Lfunc_end19:\n" +
                "\t.size\tstring_notlessthan, .Lfunc_end19-string_notlessthan\n" +
                "\t.cfi_endproc\n" +
                "                                        # -- End function\n" +
                "\t.type\tMAX_LEN,@object         # @MAX_LEN\n" +
                "\t.section\t.rodata,\"a\",@progbits\n" +
                "\t.globl\tMAX_LEN\n" +
                "\t.p2align\t2\n" +
                "MAX_LEN:\n" +
                "\t.word\t256                     # 0x100\n" +
                "\t.size\tMAX_LEN, 4\n" +
                "\n" +
                "\t.type\t.L.str,@object          # @.str\n" +
                "\t.section\t.rodata.str1.1,\"aMS\",@progbits,1\n" +
                ".L.str:\n" +
                "\t.asciz\t\"%s\"\n" +
                "\t.size\t.L.str, 3\n" +
                "\n" +
                "\t.type\t.L.str.1,@object        # @.str.1\n" +
                ".L.str.1:\n" +
                "\t.asciz\t\"%s\\n\"\n" +
                "\t.size\t.L.str.1, 4\n" +
                "\n" +
                "\t.type\t.L.str.2,@object        # @.str.2\n" +
                ".L.str.2:\n" +
                "\t.asciz\t\"%d\"\n" +
                "\t.size\t.L.str.2, 3\n" +
                "\n" +
                "\t.type\t.L.str.3,@object        # @.str.3\n" +
                ".L.str.3:\n" +
                "\t.asciz\t\"%d\\n\"\n" +
                "\t.size\t.L.str.3, 4\n" +
                "\n" +
                "\t.ident\t\"clang version 10.0.0-4ubuntu1 \"\n" +
                "\t.section\t\".note.GNU-stack\",\"\",@progbits\n";
        return builtin_dot_s;
    }
}
