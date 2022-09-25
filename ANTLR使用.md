例子
```
expression
    :   expression op=('++' | '--')                  # PostfixIncDec    // Precedence 1
    |   expression '(' parameterList? ')'            # FunctionCall
    |   expression '[' expression ']'                # Subscript
    |   expression '.' Identifier                    # MemberAccess

    |   <assoc=right> op=('++'|'--') expression      # UnaryExpr        // Precedence 2
    |   <assoc=right> op=('+' | '-') expression      # UnaryExpr
    |   <assoc=right> op=('!' | '~') expression      # UnaryExpr
    |   <assoc=right> 'new' creator                  # New

    |   expression op=('*' | '/' | '%') expression   # BinaryExpr       // Precedence 3
    |   expression op=('+' | '-') expression         # BinaryExpr       // Precedence 4
    |   expression op=('<<'|'>>') expression         # BinaryExpr       // Precedence 5
    |   expression op=('<' | '>') expression         # BinaryExpr       // Precedence 6
    |   expression op=('<='|'>=') expression         # BinaryExpr
    |   expression op=('=='|'!=') expression         # BinaryExpr       // Precedence 7
    |   expression op='&' expression                 # BinaryExpr       // Precedence 8
    |   expression op='^' expression                 # BinaryExpr       // Precedence 9
    |   expression op='|' expression                 # BinaryExpr       // Precedence 10
    |   expression op='&&' expression                # BinaryExpr       // Precedence 11
    |   expression op='||' expression                # BinaryExpr       // Precedence 12

    |   <assoc=right> expression op='=' expression   # BinaryExpr       // Precedence 14

    |   Identifier                                   # Identifier
    |   constant                                     # Literal
    |   '(' expression ')'                           # SubExpression
    ```
    ```
    @Override
public void exitBinaryExpr(MillParser.BinaryExprContext ctx) {
    BinaryExpr.BinaryOp op;
    switch (ctx.op.getType()) {
        case MillParser.Star: op = BinaryExpr.BinaryOp.MUL; break;
        case MillParser.Div: op = BinaryExpr.BinaryOp.DIV; break;
        case MillParser.Mod: op = BinaryExpr.BinaryOp.MOD; break;
        case MillParser.Plus: op = BinaryExpr.BinaryOp.ADD; break;
        case MillParser.Minus: op = BinaryExpr.BinaryOp.SUB; break;
        case MillParser.LeftShift: op = BinaryExpr.BinaryOp.SHL; break;
        case MillParser.RightShift: op = BinaryExpr.BinaryOp.SHR; break;
        case MillParser.Less: op = BinaryExpr.BinaryOp.LT; break;
        case MillParser.Greater: op = BinaryExpr.BinaryOp.GT; break;
        case MillParser.LessEqual: op = BinaryExpr.BinaryOp.LE; break;
        case MillParser.GreaterEqual: op = BinaryExpr.BinaryOp.GE; break;
        case MillParser.Equal: op = BinaryExpr.BinaryOp.EQ; break;
        case MillParser.NotEqual: op = BinaryExpr.BinaryOp.NE; break;
        case MillParser.And: op = BinaryExpr.BinaryOp.BITWISE_AND; break;
        case MillParser.Caret: op = BinaryExpr.BinaryOp.XOR; break;
        case MillParser.Or: op = BinaryExpr.BinaryOp.BITWISE_OR; break;
        case MillParser.AndAnd: op = BinaryExpr.BinaryOp.LOGICAL_AND; break;
        case MillParser.OrOr: op = BinaryExpr.BinaryOp.LOGICAL_OR; break;
        case MillParser.Assign: op = BinaryExpr.BinaryOp.ASSIGN; break;
        default: throw new RuntimeException("Unknown binary operator.");
    }
    map.put(ctx, new BinaryExpr(
            op,
            (Expr)map.get(ctx.expression(0)),
            (Expr)map.get(ctx.expression(1)),
            new SourcePosition(ctx.op),
            new SourcePosition(ctx.expression(0)),
            new SourcePosition(ctx.expression(1))
    ));
}
```
获得行号列号
```
public class SourcePosition {
    public final int line;
    public final int column;

    public SourcePosition(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public SourcePosition(Token token) {
        this.line = token.getLine();
        this.column = token.getCharPositionInLine();
    }

    public SourcePosition(ParserRuleContext ctx) {
        this(ctx.start);
    }

    public SourcePosition(TerminalNode terminal) {
        this(terminal.getSymbol());
    }

    @Override
    public String toString() {
        return "Line " + line + " Column " + column;
    }
}
```