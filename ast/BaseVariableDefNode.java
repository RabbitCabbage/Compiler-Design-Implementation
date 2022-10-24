package ast;

import util.Position;

public class VariableDefNode extends StatementNode{
    public String name, typename;
    public ExpressionNode init;

    public VariableDefNode(String tn, String n, ExpressionNode init, Position pos){
        super(pos);
        name = n;
        typename = tn;
        this.init = init;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
