package frontend;

import ast.*;
import parser.MxParserBaseVisitor;
import parser.MxParser;
import util.Type;
import util.Scope;
import util.Position;
import util.GlobalScope;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.BinaryExpressionNode.binaryOp;
import ast.LogicExpressionNode.logicOp;
import ast.BuiltInFunctionExpressionNode.functionType;

import java.util.Iterator;
import java.util.List;

public class ASTBuilder extends MxParserBaseVisitor<ASTNode>{
    private GlobalScope globalscope;
    public ASTBuilder(GlobalScope gs){
        globalscope = gs;
    };

    Type intType,boolType;

    @Override public ASTNode visitProgram(MxParser.ProgramContext ctx) {
        RootNode root = new RootNode(new Position(ctx),(MainFunctionNode)visit(ctx.mainFunctionDefinition()));
        List<MxParser.ProgramSectionContext> list = ctx.programSection();
        //programSection返回的是一个含有很多ProgramSectionContext的list
        //遍历这个ProgramSectionContext的List，每一个元素都可以 调用三个函数
        // 得到FunctionDefinitionContext ClassDefinitionContext GlobalVariableDefinitionContext
        for (MxParser.ProgramSectionContext section : list) {
            if (section.functionDefinition() != null) {
                //这里调用的函数是MxParser中的一个函数，visit某个context然后生成对应的一个节点
                root.funcdefs.add((FunctionDefNode)visit(section.functionDefinition()));
            } else if (section.classDefinition() != null) {
                root.classdefs.add((ClassDefNode)visit(section.classDefinition()));
            } else if (section.variableDefinition() != null) {
                root.vardefs.add((VariableDefNode)visit(section.variableDefinition()));
            }
        }
        return root;
    }

    @Override public ASTNode visitClassDefinition(MxParser.ClassDefinitionContext ctx){
        ClassDefNode classdef = new ClassDefNode(new Position(ctx), ctx.Identifier().toString());
        ctx.functionDefinition().forEach(a -> classdef.methoddefs.add((FunctionDefNode)visit(a)));
        ctx.variableDefinition().forEach(a -> classdef.vardefs.add((VariableDefNode)visit(a)));
        return classdef;
    }

    @Override public ASTNode visitFunctionDefinition(MxParser.FunctionDefinitionContext ctx){
        ParameterNode parameters = null;
        if(ctx.parameter()!=null) {
            ctx.parameter().forEach(a -> parameters.paralist.put(a.typeName().toString(),a.Identifier().toString()));
        }
        return new FunctionDefNode(ctx.typeName().toString(),ctx.Identifier().toString(),parameters,new Position(ctx));
    }

    @Override public ASTNode visitMainFunctionDefinition(MxParser.MainFunctionDefinitionContext ctx){
        MainFunctionNode root = new MainFunctionNode(new Position(ctx));
        if(ctx.suite()!=null){
            //接下来对于main函数函数体中的每一个statement都进行访问，
            //每一个都添加到main函数的statement的array list里面，并且visit这些node
            ctx.suite().statement().forEach(a ->root.stmts.add((StatementNode)visit(a)));
        }
        return root;
    }

    @Override public ASTNode visitBaseVariableDefinition(MxParser.BaseVariableDefinitionContext ctx){
        //因为在构建CST的过程中一些没有必要保留的语法层面就可以不要了
        //比如这里的variable definition，就直接拆分成identifier和expression，建立这种子节点才有意义
        ExpressionNode expression = null;
        String typename = null;
        //todo 有不止一个怎么做到分别进行处理
        return new VariableDefNode(typename, ctx.Identifier().toString(), expression, new Position(ctx));
    }

    @Override public ASTNode visitSuite(MxParser.SuiteContext ctx){
        BlockStatementNode block = new BlockStatementNode(new Position(ctx));
        if(!ctx.statement().isEmpty()){
            for(ParserRuleContext stmt: ctx.statement()){
                StatementNode tmp =(StatementNode)visit(stmt);
                if(tmp != null) block.stmts.add(tmp);
            }
        }
        return block;
    }

    @Override public ASTNode visitBuiltInFunctionReturnVoid(MxParser.BuiltInFunctionReturnVoidContext ctx) {
        
    }

    @Override public ASTNode visitIfStatement(MxParser.IfStatementContext ctx){
        StatementNode thenstmt = (StatementNode)visit(ctx.trueStatement);
        StatementNode elsestmt = null;
        ExpressionNode condition = (ExpressionNode)visit(ctx.expression());
        if(ctx.falseStatement!=null)elsestmt = (StatementNode)visit(ctx.falseStatement);
        return new IfStatementNode(condition, thenstmt, elsestmt, new Position(ctx));
    }

    @Override public ASTNode visitReturnStatement(MxParser.ReturnStatementContext ctx){
        ExpressionNode value = null;
        if(ctx.expression() != null) value = (ExpressionNode)visit(ctx.expression());
        return new ReturnStatementNode(value, new Position(ctx));
    }

    @Override public ASTNode visitExpressionStatement(MxParser.ExpressionStatementContext ctx){
        return new ExpressionStatementNode((ExpressionNode)visit(ctx.expression()), new Position(ctx));
    }

    @Override public ASTNode visitEmptyStatement(MxParser.EmptyStatementContext ctx){
        return null;
    }

    @Override public ASTNode visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx){
        return visit(ctx.basicExpression());
    }

    @Override public ASTNode visitBinaryExpression(MxParser.BinaryExpressionContext ctx){
        ExpressionNode lhs = (ExpressionNode) visit(ctx.complexExpression(0)),
                rhs = (ExpressionNode) visit(ctx.complexExpression(1));
        binaryOp op = null;
        if(ctx.Plus() != null) op = binaryOp.add;
        else if(ctx.Minus() != null) op = binaryOp.sub;
        else if(ctx.Mod() != null) op = binaryOp.mod;
        else if(ctx.Star() != null) op = binaryOp.mul;
        else if(ctx.Div() != null) op = binaryOp.div;
        else if(ctx.LessLess() != null) op = binaryOp.leftshift;
        else if(ctx.GreaterGreater() != null) op = binaryOp.rightshift;
        else if(ctx.And() != null) op = binaryOp.and;
        else if(ctx.Caret() != null) op = binaryOp.caret;
        else if(ctx.Or() != null) op = binaryOp.or;
        return new BinaryExpressionNode(lhs,rhs,op,intType,new Position(ctx));
    }

    @Override public ASTNode visitLogicExpression(MxParser.LogicExpressionContext ctx){
        ExpressionNode lhs = (ExpressionNode) visit(ctx.complexExpression(0)),
                rhs = (ExpressionNode) visit(ctx.complexExpression(1));
        logicOp op = null;
        if(ctx.Equal() != null) op = logicOp.eq;
        else if(ctx.NotEqual() != null) op = logicOp.neq;
        else if(ctx.Less() != null) op = logicOp.less;
        else if(ctx.Greater() != null) op = logicOp.greater;
        else if(ctx.LessEqual() != null) op = logicOp.lesseq;
        else if(ctx.GreaterEqual() != null) op = logicOp.greatereq;
        else if(ctx.AndAnd() != null) op = logicOp.andand;
        else if(ctx.OrOr() != null) op = logicOp.oror;
        return new LogicExpressionNode(lhs,rhs,op,boolType,new Position((ctx)));
    }

    @Override public ASTNode visitAssignmentExpression(MxParser.AssignmentExpressionContext ctx){
        ExpressionNode lhs = (ExpressionNode)visit(ctx.complexExpression(0));
        ExpressionNode rhs = (ExpressionNode)visit(ctx.complexExpression(1));
        return new AssignmentExpressionNode(lhs,rhs,new Position(ctx));
    }

    @Override public ASTNode visitBasicExpression(MxParser.BasicExpressionContext ctx){
        if(ctx.Literal() != null)return visit(ctx.Literal());
        if(ctx.This() != null) return visit(ctx.This());
        if(ctx.lambdaExpression()!=null) return (LambdaExpressionNode)visit(ctx.lambdaExpression());
        if(ctx.newExpression()!=null)return (NewExpressionNode)visit(ctx.newExpression());
        if(ctx.builtInFunctionWithReturnValue()!=null)return (BuiltInFunctionExpressionNode)visit(ctx.builtInFunctionWithReturnValue());
        else return new VariableExpressionNode(ctx.Identifier().toString(), new Position(ctx));
    }

    @Override public ASTNode visitBuiltInFunctionWithReturnValue(MxParser.BuiltInFunctionWithReturnValueContext ctx){
        if(ctx.GetInt()!=null)return new BuiltInFunctionExpressionNode(null, BuiltInFunctionExpressionNode.functionType.getint, new Position(ctx));
        else if(ctx.GetString()!=null)return new BuiltInFunctionExpressionNode(null, BuiltInFunctionExpressionNode.functionType.getstring,new Position(ctx));
        else return new BuiltInFunctionExpressionNode((ExpressionNode)visit(ctx.complexExpression()), functionType.tostring, new Position(ctx));
    }
}
