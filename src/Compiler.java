import ast.RootNode;
import frontend.ASTBuilder;
import frontend.SemanticChecker;
import frontend.SymbolCollector;
import frontend.Symbols;
import org.antlr.v4.runtime.CharStreams;

import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.MxLexer;
import parser.MxParser;
import util.SemaCheckListener;
import util.error.SemanticError;


public class Compiler {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
//        String name = "test.mx";
//        InputStream input = new FileInputStream("./testcases/sema/basic-package/basic-0.mx");
        try {
            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new SemaCheckListener());
            MxParser parser = new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new SemaCheckListener());
            ParseTree parseroot = parser.program();
            ASTBuilder builder = new ASTBuilder();
            RootNode programnode = (RootNode) builder.visit(parseroot);
            Symbols symbols = new Symbols();
            new SymbolCollector(symbols).visit(programnode);
            new SemanticChecker(symbols).visit(programnode);
        } catch (Error error) {
            System.err.println(error.toString());
            throw new RuntimeException();
        }
    }
}
