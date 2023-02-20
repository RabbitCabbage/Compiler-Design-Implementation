import asm.ASMBuilder;
import asm.ASMPrinter;
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
import util.BuiltinPrinter;
import util.SemaCheckListener;
import util.error.SemanticError;


public class Compiler {
    public static void main(String[] args) throws Exception {
//        InputStream input = System.in;
//        InputStream input = new FileInputStream("./testcases/codegen/sorting/bubble_sort.mx");
//        InputStream input = new FileInputStream("./testcases/codegen/shortest_path/dijkstra.mx");
        InputStream input = new FileInputStream("./testcases/basic.mx");
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
            File file1 = new File("IR.ll");
            if(!file1.exists())file1.createNewFile();
            FileWriter fw1 = new FileWriter("IR.ll");
            PrintWriter pw1 = new PrintWriter(fw1);
            pw1.print(ir.llvm.toDotLLVM());
            pw1.flush();
            File file2 = new File("output.s");
            if(!file2.exists())file2.createNewFile();
            FileWriter fw2 = new FileWriter("output.s");
            PrintWriter pw2 = new PrintWriter(fw2);
            ASMBuilder asm = new ASMBuilder();
            asm.visit(ir.llvm);
            pw2.print(new ASMPrinter(asm).print());
            pw2.flush();
            File file3 = new File("builtin.s");
            if(!file3.exists())file3.createNewFile();
            FileWriter fw3 = new FileWriter("builtin.s");
            PrintWriter pw3 = new PrintWriter(fw3);
            pw3.print(new BuiltinPrinter().toString());
            pw3.flush();;
        } catch (Error error) {
            System.err.println(error.toString());
            throw new RuntimeException();
        }
    }
}
