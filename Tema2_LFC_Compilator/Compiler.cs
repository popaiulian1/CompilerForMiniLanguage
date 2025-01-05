using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

public class Compiler
{
    public static void Main(string[] args)
    {
        string input = System.IO.File.ReadAllText("input.txt");
        
        AntlrInputStream inputStream = new AntlrInputStream(input);
        MiniLangLexer lexer = new MiniLangLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.GetText();

        using (StreamWriter writer = new StreamWriter("tokens.txt"))
        {
            writer.WriteLine("Token, Lexeme, Line");
            foreach (var token in tokenStream.GetTokens())
            {
                if (token.Type == MiniLangLexer.Eof) continue;

                string tokenName = lexer.Vocabulary.GetSymbolicName(token.Type);
                
                writer.WriteLine($"<{tokenName}, \"{token.Text}\", {token.Line}>");
            }
            
            Console.WriteLine("Tokens saved to tokens.txt");
        }
        
        MiniLangParser parser = new MiniLangParser(tokenStream);

        IParseTree tree = parser.program();
        
        SyntaxCollector collector = new SyntaxCollector();
        collector.Visit(tree);
        
        collector.SaveGlobalVariables("global_variables.txt");
        Console.WriteLine("Global variables saved to global_variables.txt");
        collector.SaveFunctions("functions.txt");
        Console.WriteLine("Functions saved to functions.txt");
        
        //Console.WriteLine(tree.ToStringTree(parser));
    }
}