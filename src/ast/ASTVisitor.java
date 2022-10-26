package ast;


public class ASTVisitor{
    public void visit(RootNode it){}//我调用visit就会visit程序根节点
    //对应的在根节点上有一个函数accept就是让visitor来visit自己
    //会在每一个节点visit它所有可能往下的子节点，这里返回的
    public void visit(VariableDefNode it){}

    public void visit(FunctionDefNode it){}


    public void visit(IfStatementNode it){}

    public void visit(ReturnStatementNode it){}

    public void visit(ExpressionStatementNode it){}

    public void visit(BinaryExpressionNode it){}

    public void visit(AssignmentExpressionNode it){}

    public void visit(VariableExpressionNode it){}


    public void visit(ParameterNode parameterNode){}

    public void visit(ClassDefNode it){}

    public void visit(DeclarationNode it){}

    public void visit(SuiteNode it) {}

    public void visit(WhileStatementNode node) {}

    public void visit(ForStatementNode node) {}

    public void visit(PrefixExpressionNode node) {
    }

    public void visit(SuffixExpressionNode node) {
    }

    public void visit(FunctionCallExpressionNode node) {
    }

    public void visit(LambdaExpressionNode node) {
    }

    public void visit(ArrayIndexExpressionNode node) {
    }

    public void visit(ParenExpressionNode node) {
    }

    public void visit(PrimaryExpressionNode node) {
    }

    public void visit(MemberCallExpressionNode node) {
    }

    public void visit(NewExpressionNode node) {
    }

    public void visit(BreakStatementNode node) {
    }

    public void visit(ContinueStatementNode node) {
    }
}
