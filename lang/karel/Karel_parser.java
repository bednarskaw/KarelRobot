
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
import java.io.*;
import java.nio.charset.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
public final class Karel_parser
{
  private static class ErrorListener extends BaseErrorListener
  {
    private int errors = 0;
    public void syntaxError(Recognizer<?,?> recognizer,
      Object offendingSymbol, int line, int charPositionInLine,
      String msg, RecognitionException e)
    {
      errors++;
    }
  }
  public static Number parseNumber()
  {
     return parseNumber(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static Number parseNumber(File file) throws FileNotFoundException
  {
     return parseNumber(new FileReader(file));
  }
  public static Number parseNumber(String text)
  {
     return parseNumber(new StringReader(text));
  }
  public static Number parseNumber(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KarelLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KarelParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dNumber()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static Command parseCommand()
  {
     return parseCommand(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static Command parseCommand(File file) throws FileNotFoundException
  {
     return parseCommand(new FileReader(file));
  }
  public static Command parseCommand(String text)
  {
     return parseCommand(new StringReader(text));
  }
  public static Command parseCommand(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KarelLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KarelParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dCommand()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static Condition parseCondition()
  {
     return parseCondition(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static Condition parseCondition(File file) throws FileNotFoundException
  {
     return parseCondition(new FileReader(file));
  }
  public static Condition parseCondition(String text)
  {
     return parseCondition(new StringReader(text));
  }
  public static Condition parseCondition(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KarelLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KarelParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dCondition()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static Program parseProgram()
  {
     return parseProgram(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static Program parseProgram(File file) throws FileNotFoundException
  {
     return parseProgram(new FileReader(file));
  }
  public static Program parseProgram(String text)
  {
     return parseProgram(new StringReader(text));
  }
  public static Program parseProgram(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KarelLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KarelParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dProgram()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
}
