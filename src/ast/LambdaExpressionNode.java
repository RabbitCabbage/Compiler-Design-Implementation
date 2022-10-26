package ast;

import util.Position;

import java.util.ArrayList;

public class LambdaExpressionNode extends ExpressionNode{
    public ArrayList<ParameterNode> parameters;
    public ArrayList<ExpressionNode> auguments;
    public SuiteNode stmts;

    public LambdaExpressionNode(Position pos, SuiteNode stmts){
        super(pos);
        this.stmts = stmts;
        parameters = new ArrayList<>();
        auguments = new ArrayList<>();
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
