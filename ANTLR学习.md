grammar 名称和文件名要一致
Parser 规则（即 non-terminal）以小写字母开始
Lexer 规则（即 terminal）以大写字母开始
所有的 Lexer 规则无论写在哪里都会被重排到 Parser 规则之后
所有规则中若有冲突，先出现的规则优先匹配
用 'string' 单引号引出字符串
| 用于分隔两个产生式，(a|b) 括号用于指定子产生式，?+*用法同正则表达式
在产生式后面 # label 可以给某条产生式命名，在生成的代码中即可根据标签分辨不同产生式
不需要指定开始符号
规则以分号终结
/* block comment */ 以及 // line comment
默认的左结合，可以用 <assoc=right> 指定右结合
可以处理直接的左递归，不能处理间接的左递归
如果用 MUL: '*'; 指定了某个字符串的名字，在程序里面就能用这个名字了
用 fragment 可以给 Lexer 规则中的公共部分命名


把输入流包装一下喂给 Lexer，之后将 Token 流喂给 Parser，最后调用 ParseTree::<starting> 生成解析树。
解析树可以直接用 .toStringTree 按照 LISP 风格打印出来。

使用 Visitor 模式的话，就是新建 Visitor 对象，之后 visit(tree)。
使用 Listener 模式的话，需要一个 ParseTreeWalker 和一个 Listener 对象，然后用这个 walker 在树上用这个 Listener 行走。
把结构和行为分开