package IR;

import ast.DeclarationNode;

public class GlobalVarIR {
    public DeclarationNode declare;
    public GlobalVarIR(DeclarationNode decl){
        declare = decl;
    }
}
