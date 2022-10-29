lexer grammar MxLexer;

BooleanLiteral: True_ | False_;

IntegerLiteral: DecimalLiteral;

StringLiteral: '"' CHAR* '"';

NullLiteral: NULL;

Bool: 'bool';

Int: 'int';

Void: 'void';

String: 'string';

False_: 'false';

True_: 'true';

New: 'new';

Class: 'class';

Public: 'public';

This: 'this';

NULL: 'null';

If: 'if';

Else: 'else';

For: 'for';

While: 'while';

Break: 'break';

Continue: 'continue';

Return: 'return';

//the first number cannot be 0
//there can be '/'' for the division of the long numbers;
DecimalLiteral: NONZERODIGIT ('\''? DIGIT)* | '0';

//`fragment` means the word DIGIT should not be referenced, except in lexer file;
fragment NONZERODIGIT: [1-9];

fragment DIGIT: [0-9];

fragment LETTER: [a-zA-Z];

fragment UNDERLINE: '_';

fragment CHAR: PRINTABLE|ESCAPE|WHITE;

fragment PRINTABLE: '\u0020'..'\u007E';

//转义字符
fragment ESCAPE: '\\n'|'\\t'|'\\"';

fragment WHITE: ' ';

LeftParen: '(';

RightParen: ')';

LeftBracket: '[';

RightBracket: ']';

LeftBrace: '{';

RightBrace: '}';

Plus: '+';

Minus: '-';

Star: '*';

Div: '/';

Mod: '%';

Caret: '^';

And: '&';

Or: '|';

Tilde: '~';

Not: '!';

Assign: '=';

Less: '<';

Greater: '>';

Equal: '==';

NotEqual: '!=';

LessEqual: '<=';

GreaterEqual: '>=';

AndAnd: '&&';

OrOr: '||';

PlusPlus: '++';

MinusMinus: '--';

Comma: ',';

Colon: ':';

Semicolon: ';';

LessLess: '<<';

GreaterGreater: '>>';

Dot: '.';

RightArrow: '->';


//identifiers for variables and functions and classes
Identifier: LETTER (LETTER | DIGIT | UNDERLINE)*;

fragment SIGN: [+-];

Whitespacetoskip: [ \t\n\r]+ -> skip;

Newline: ('\r' '\n'? | '\n') -> skip;

LineComment: '//' ~ [\r\n]* -> skip;

BlockComment: '/*' .*? '*/' -> skip;
