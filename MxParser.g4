parser grammar MxParser;
options { tokenVocab = MxLexer; }

primaryExpression:
    literal
    | This
    | LeftParen expression RightParen
    | idExpression
    | lambdaExpression;

literal:
    IntegerLiteral
    | BooleanLiteral
    | StringLiteral
    | NullLiteral;

expression: assignmentExpression (Comma assignmentExpression)*;

assignmentExpression:


//todo main function
//todo lambda expression
//todo built in funcions
