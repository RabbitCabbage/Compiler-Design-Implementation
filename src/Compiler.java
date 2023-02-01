import ast.RootNode;
import backend.IRBuilder;
import frontend.ASTBuilder;
import frontend.SemanticChecker;
import frontend.SymbolCollector;
import frontend.Symbols;
import org.antlr.v4.runtime.CharStreams;

import java.io.*;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.MxLexer;
import parser.MxParser;
import util.SemaCheckListener;
import util.error.SemanticError;


public class Compiler {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
//        InputStream input = new FileInputStream("./testcases/codegen/t9.mx");
//        InputStream input = new FileInputStream(args[0]);
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
            IRBuilder ir = new IRBuilder(symbols);
            ir.visit(programnode);
            File file = new File("IR.ll");
            if(!file.exists())file.createNewFile();
            FileWriter fw = new FileWriter("IR.ll");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(ir.llvm.toDotLLVM());
            pw.flush();
        } catch (Error error) {
            System.err.println(error.toString());
            throw new RuntimeException();
        }
    }
}
