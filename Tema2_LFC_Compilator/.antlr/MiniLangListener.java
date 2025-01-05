// Generated from d:/FACULTATE AN2/Tema2_LFC_Compilator/Tema2_LFC_Compilator/MiniLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLangParser}.
 */
public interface MiniLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MiniLangParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MiniLangParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MiniLangParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MiniLangParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#globalVariable}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVariable(MiniLangParser.GlobalVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#globalVariable}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVariable(MiniLangParser.GlobalVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(MiniLangParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(MiniLangParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(MiniLangParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(MiniLangParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(MiniLangParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(MiniLangParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#compoundOperator}.
	 * @param ctx the parse tree
	 */
	void enterCompoundOperator(MiniLangParser.CompoundOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#compoundOperator}.
	 * @param ctx the parse tree
	 */
	void exitCompoundOperator(MiniLangParser.CompoundOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(MiniLangParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(MiniLangParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MiniLangParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MiniLangParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MiniLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MiniLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MiniLangParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MiniLangParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(MiniLangParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(MiniLangParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOp(MiniLangParser.LogicalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOp(MiniLangParser.LogicalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MiniLangParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MiniLangParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(MiniLangParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(MiniLangParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MiniLangParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MiniLangParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniLangParser.TypeContext ctx);
}