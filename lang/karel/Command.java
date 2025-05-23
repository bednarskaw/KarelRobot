
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public sealed interface Command permits
Command.Forward, Command.ForwardN, Command.TurnLeft, Command.TurnRight, Command.PutBeeper, Command.PickBeeper, Command.Reset, Command.Skip, Command.Seq, Command.IfElse, Command.While
{
  public record Forward() implements Command
  {
    public String toString()
    {
      String _result;
       _result = "FORWARD"; 
      return _result;
    }
  }
  public record ForwardN(Number _1) implements Command
  {
    public String toString()
    {
      var n = _1;
      String _result;
       _result = "FORWARD-" + n; 
      return _result;
    }
  }
  public record TurnLeft() implements Command
  {
    public String toString()
    {
      String _result;
       _result = "TLEFT"; 
      return _result;
    }
  }
  public record TurnRight() implements Command
  {
    public String toString()
    {
      String _result;
       _result = "TRIGHT"; 
      return _result;
    }
  }
  public record PutBeeper() implements Command
  {
    public String toString()
    {
      String _result;
       _result = "PUTBEEPER"; 
      return _result;
    }
  }
  public record PickBeeper() implements Command
  {
    public String toString()
    {
      String _result;
       _result = "PICKBEEPER"; 
      return _result;
    }
  }
  public record Reset() implements Command
  {
    public String toString()
    {
      String _result;
       _result = "RESET"; 
      return _result;
    }
  }
  public record Skip() implements Command
  {
    public String toString()
    {
      String _result;
       _result = "SKIP"; 
      return _result;
    }
  }
  public record Seq(Command _1, Command _2) implements Command
  {
    public String toString()
    {
      var c1 = _1;
      var c2 = _2;
      String _result;
       _result = c1 + ":" + c2; 
      return _result;
    }
  }
  public record IfElse(Condition _1, Command _2, Command _3) implements Command
  {
    public String toString()
    {
      var b = _1;
      var c1 = _2;
      var c2 = _3;
      String _result;
       _result = b + ":IFELSE(" + c1 + ", " + c2 + ")"; 
      return _result;
    }
  }
  public record While(Condition _1, Command _2) implements Command
  {
    public String toString()
    {
      var b = _1;
      var c = _2;
      String _result;
       _result = "WHILE(" + b + ", " + c + ")"; 
      return _result;
    }
  }
}
