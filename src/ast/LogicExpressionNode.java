package ast;

import util.Position;
import util.Type;

public class LogicExpressionNode extends ExpressionNode{
    public ExpressionNode lhs,rhs;

    public enum logicOp{
        eq, neq, less, greater, lesseq, greatereq, andand, oror
    }

    public logicOp opcode;

    public LogicExpressionNode(ExpressionNode lhs, ExpressionNode rhs, logicOp op, Type booltype, Position pos){
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        opcode = op;
        type = booltype;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
