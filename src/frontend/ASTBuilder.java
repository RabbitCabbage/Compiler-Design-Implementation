package frontend;

import ast.*;
import parser.MxParserBaseVisitor;
import parser.MxParser;
import util.Position;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.PrimaryExpressionNode.ExpressionType;
import util.error.SemanticError;

import java.util.List;

public class ASTBuilder extends MxParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(MxParser.ProgramContext ctx) {
        RootNode root = new RootNode(new Position(ctx));
        List<MxParser.ProgramSectionContext> list = ctx.programSection();
        //programSection返回的是一个含有很多ProgramSectionContext的list
        //遍历这个ProgramSectionContext的List，每一个元素都可以 调用三个函数
        // 得到FunctionDefinitionContext ClassDefinitionContext GlobalVariableDefinitionContext
        for (MxParser.ProgramSectionContext section : list) {
            if (section.functionDefinition() != null) {
                //这里调用的函数是MxParser中的一个函数，visit某个context然后生成对应的一个节点
                root.funcdefs.add((FunctionDefNode) visit(section.functionDefinition()));
            } else if (section.classDefinition() != null) {
                root.classdefs.add((ClassDefNode) visit(section.classDefinition()));
            } else if (section.variableDefinition() != null) {
                root.vardefs.add((VariableDefNode) visit(section.variableDefinition()));
            }
        }
        return root;
    }

    @Override
    public ASTNode visitClassDefinition(MxParser.ClassDefinitionContext ctx) {
        ClassDefNode classdef = new ClassDefNode(new Position(ctx), ctx.Identifier().getText());
        if (ctx.constructFunctionDef() != null) {
            ctx.constructFunctionDef().forEach(a -> classdef.methoddefs.add((FunctionDefNode) visit(a)));
        } else {
            SuiteNode suite = new SuiteNode(new Position(ctx));
            FunctionDefNode default_ = new FunctionDefNode(null, 0, ctx.Identifier().getText(), suite, classdef, new Position(ctx));
            default_.is_constructor = true;
            classdef.methoddefs.add(default_);
        }
        if (ctx.functionDefinition() != null)
            ctx.functionDefinition().forEach(a -> classdef.methoddefs.add((FunctionDefNode) visit(a)));
        if (ctx.variableDefinition() != null)
            ctx.variableDefinition().forEach(a -> classdef.vardefs.add((VariableDefNode) visit(a)));
        return classdef;
    }

    @Override
    public ASTNode visitFunctionDefinition(MxParser.FunctionDefinitionContext ctx) {
        SuiteNode suite = (SuiteNode) visit(ctx.suite());
        FunctionDefNode funcdef = new FunctionDefNode(ctx.variableType().basicType().getText(), ctx.variableType().LeftBracket().size(), ctx.Identifier().getText(), suite, null, new Position(ctx));
        if (ctx.parameter() != null) {
            ctx.parameter().forEach(a -> funcdef.parameterlist.add((ParameterNode) visit(a)));
        }
        return funcdef;
    }

    @Override
    public ASTNode visitParameter(MxParser.ParameterContext ctx) {
        return new ParameterNode(new Position(ctx), ctx.variableType().basicType().getText(), ctx.variableType().LeftBracket().size(), (DeclarationNode) visit(ctx.declaration()));
    }


    @Override
    public ASTNode visitConstructFunctionDef(MxParser.ConstructFunctionDefContext ctx) {
        SuiteNode suite = (SuiteNode) visit(ctx.suite());
        FunctionDefNode funcdef = new FunctionDefNode(null, 0, ctx.Identifier().getText(), suite, null, new Position(ctx));
        funcdef.is_constructor = true;
        funcdef.returntype = null;
        if (ctx.parameter() != null) {
            ctx.parameter().forEach(a -> funcdef.parameterlist.add((ParameterNode) visit(a)));
        }
        return funcdef;
    }

    @Override
    public ASTNode visitSuite(MxParser.SuiteContext ctx) {
        SuiteNode block = new SuiteNode(new Position(ctx));
        if (!ctx.statement().isEmpty()) {
            for (ParserRuleContext stmt : ctx.statement()) {
                StatementNode tmp = (StatementNode) visit(stmt);
                block.stmts.add(tmp);
            }
        }
        return block;
    }

    @Override
    public ASTNode visitIfStatement(MxParser.IfStatementContext ctx) {
        StatementNode thenstmt = (StatementNode) visit(ctx.trueStatement);
        StatementNode elsestmt = null;
        if(ctx.expression()==null)
            throw new SemanticError("the condition of if statement should not be empty",new Position(ctx));
        ExpressionNode condition = (ExpressionNode) visit(ctx.expression());
        if (ctx.falseStatement != null) elsestmt = (StatementNode) visit(ctx.falseStatement);
        return new IfStatementNode(condition, thenstmt, elsestmt, new Position(ctx));
    }

    @Override
    public ASTNode visitReturnStatement(MxParser.ReturnStatementContext ctx) {
        ExpressionNode value = null;
        if (ctx.expression() != null) value = (ExpressionNode) visit(ctx.expression());
        return new ReturnStatementNode(value, new Position(ctx));
    }

    @Override
    public ASTNode visitBreakStatement(MxParser.BreakStatementContext ctx) {
        return new BreakStatementNode(new Position(ctx));
    }

    @Override
    public ASTNode visitContinueStatement(MxParser.ContinueStatementContext ctx) {
        return new ContinueStatementNode(new Position(ctx));
    }

    @Override
    public ASTNode visitExpressionStatement(MxParser.ExpressionStatementContext ctx) {
        return new ExpressionStatementNode((ExpressionNode) visit(ctx.expression()), new Position(ctx));
    }

    @Override
    public ASTNode visitEmptyStatement(MxParser.EmptyStatementContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx) {
        PrimaryExpressionNode primary = new PrimaryExpressionNode(new Position(ctx), ctx.basicExpression().getText());
        if (ctx.basicExpression().BooleanLiteral() != null) {
            primary.dim = 0;
            primary.exprtype = ExpressionType.boolLiteralExpr;
            primary.type = "bool";
        }
        if (ctx.basicExpression().StringLiteral() != null)  {
            primary.dim = 0;
            primary.exprtype = ExpressionType.stringLiteralExpr;
            primary.type = "string";
        }
        if (ctx.basicExpression().IntegerLiteral() != null)  {
            primary.dim = 0;
            primary.exprtype = ExpressionType.integerLiteralExpr;
            primary.type = "int";
        }
        if (ctx.basicExpression().NullLiteral() != null)  {
            primary.dim = 0;
            primary.exprtype = ExpressionType.nullLiteralExpr;
            primary.type = "null";
        }
        else if (ctx.basicExpression().Identifier() != null)  {
            primary.exprtype = ExpressionType.identifierExpr;
        }
        else if (ctx.basicExpression().This() != null)  {
            primary.exprtype = ExpressionType.thisExpr;
        }
        return primary;
    }

    @Override
    public ASTNode visitSuffixExpression(MxParser.SuffixExpressionContext ctx) {
        return new SuffixExpressionNode(new Position(ctx), (ExpressionNode) visit(ctx.expression()), ctx.op.getText());
    }

    @Override
    public ASTNode visitPrefixExpression(MxParser.PrefixExpressionContext ctx) {
        return new PrefixExpressionNode(new Position(ctx), (ExpressionNode) visit(ctx.expression()), ctx.op.getText());
    }

    @Override
    public ASTNode visitFunctionCallExpression(MxParser.FunctionCallExpressionContext ctx) {
        CallExpressionNode funccall = new CallExpressionNode(new Position(ctx), (ExpressionNode) visit(ctx.expression(0)));
        for (int i = 1; i < ctx.expression().size(); ++i) {
            funccall.auguments.add((ExpressionNode) visit(ctx.expression(i)));
        }
        return funccall;
    }

    @Override
    public ASTNode visitParenExpression(MxParser.ParenExpressionContext ctx) {
        return new ParenExpressionNode(new Position(ctx), (ExpressionNode) visit(ctx.expression()));
    }

    @Override
    public ASTNode visitMemberCallExpression(MxParser.MemberCallExpressionContext ctx) {
       return new MemberCallExpressionNode(new Position(ctx), (ExpressionNode) visit(ctx.expression()), ctx.Identifier().getText());
    }

    @Override
    public ASTNode visitBinaryExpression(MxParser.BinaryExpressionContext ctx) {
        ExpressionNode lhs = (ExpressionNode) visit(ctx.expression(0)), rhs = (ExpressionNode) visit(ctx.expression(1));
        String op = ctx.op.getText();
        return new BinaryExpressionNode(lhs, rhs, op, new Position(ctx));
    }


    @Override
    public ASTNode visitAssignmentExpression(MxParser.AssignmentExpressionContext ctx) {
        ExpressionNode lhs = (ExpressionNode) visit(ctx.expression(0));
        ExpressionNode rhs = (ExpressionNode) visit(ctx.expression(1));
        return new AssignmentExpressionNode(lhs, rhs, new Position(ctx));
    }

    @Override
    public ASTNode visitArrayIndexingExpression(MxParser.ArrayIndexingExpressionContext ctx) {
        return new ArrayIndexExpressionNode(new Position(ctx), (ExpressionNode) visit(ctx.expression(0)), (ExpressionNode) visit(ctx.expression(1)));
    }

    @Override
    public ASTNode visitVariableDefinition(MxParser.VariableDefinitionContext ctx) {
        //System.out.println(ctx.variableType().LeftBracket().size());
        //System.out.println(ctx.declaration(0).Identifier());
        VariableDefNode vardef = new VariableDefNode(ctx.variableType().basicType().getText(), new Position(ctx), ctx.variableType().LeftBracket().size());
        //System.out.println(vardef.typename);
        //System.out.println(vardef.dim);
        ctx.declaration().forEach(a -> vardef.declarations.add((DeclarationNode) visit(a)));
        return vardef;
    }

    @Override
    public ASTNode visitDeclaration(MxParser.DeclarationContext ctx) {
        //System.out.println(ctx.Identifier());
        if(ctx.expression()!=null)return new DeclarationNode(ctx.Identifier().getText(), (ExpressionNode) visit(ctx.expression()), new Position(ctx));
        else return new DeclarationNode(ctx.Identifier().getText(), null, new Position(ctx));
    }

    @Override
    public ASTNode visitWhileStatement(MxParser.WhileStatementContext ctx) {
        if(ctx.expression()==null)
            throw  new SemanticError("the condition in while statement should not be empty",new Position(ctx));
        ExpressionNode condition = (ExpressionNode) visit(ctx.expression());
        StatementNode stmt = (StatementNode) visit(ctx.statement());
        return new WhileStatementNode(condition, stmt, new Position(ctx));
    }

    @Override
    public ASTNode visitForStatement(MxParser.ForStatementContext ctx) {
        VariableDefNode vardef = null;
        ExpressionNode init = null, condition = null, next = null;
        if (ctx.forInitStatement().vardef != null) vardef = (VariableDefNode) visit(ctx.forInitStatement().vardef);
        if (ctx.forInitStatement().init != null) init = (ExpressionNode) visit(ctx.forInitStatement().init);
        if (ctx.condition != null) condition = (ExpressionNode) visit(ctx.condition);
        if (ctx.next != null) next = (ExpressionNode) visit(ctx.next);
        StatementNode stmts = (StatementNode) visit(ctx.statement());
        return new ForStatementNode(vardef, init, condition, next, new Position(ctx), stmts);
    }

    @Override
    public ASTNode visitLambdaExpression(MxParser.LambdaExpressionContext ctx) {
        LambdaExpressionNode lambda = new LambdaExpressionNode(new Position(ctx), (SuiteNode) visit(ctx.lambdaExpression_().suite()));
        ctx.lambdaExpression_().parameter().forEach(a -> lambda.parameters.add((ParameterNode) visit(a)));
        ctx.lambdaExpression_().expression().forEach(a -> lambda.auguments.add((ExpressionNode) visit(a)));
        return lambda;
    }

    @Override
    public ASTNode visitNewExpression(MxParser.NewExpressionContext ctx){
        NewExpressionNode newexpr = new NewExpressionNode(new Position(ctx),ctx.newExpression_().newType().basicType().getText(),ctx.newExpression_().newType().LeftBracket().size());
        ctx.newExpression_().newType().expression().forEach(a->newexpr.expression.add((ExpressionNode)visit(a)));
        //这个arraylist里面装的是维数的初始化表达式们
        //System.out.println(newexpr.dim);
        return newexpr;
    }
}