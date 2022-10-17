// Generated from D:/Desktop/Compiler-Design-Implementation/grammar\MxParser.g4 by ANTLR 4.10.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#programSections}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramSections(MxParser.ProgramSectionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#globalVariableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVariableDefinition(MxParser.GlobalVariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MxParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(MxParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#builtInFunctionReturnVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInFunctionReturnVoid(MxParser.BuiltInFunctionReturnVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(MxParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCirculationStatement(MxParser.CirculationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forInitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitStatement(MxParser.ForInitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpression(MxParser.BasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(MxParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexExpression(MxParser.ComplexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#builtInFunctionWithReturnValue_Dot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInFunctionWithReturnValue_Dot(MxParser.BuiltInFunctionWithReturnValue_DotContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#builtInFunctionWithReturnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInFunctionWithReturnValue(MxParser.BuiltInFunctionWithReturnValueContext ctx);
}