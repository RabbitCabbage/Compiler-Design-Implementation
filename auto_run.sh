llvm-as IR.ll -o IR.bc
llvm-link IR.bc ./lib/buildin.bc -o total.bc
lli total.bc