
package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
public sealed interface Command permits
Command.Forward, Command.ForwardDefault, Command.TurnLeft, Command.TurnRight, Command.Reset, Command.Skip, Command.Seq
{
  public record Forward(String _1) implements Command
  {
    public String toString()
    {
      var n = _1;
      String _result;
       _result = n == "1" ? "FORWARD" : "FORWARD-" + n;
      return _result;
    }
  }
  public record ForwardDefault() implements Command
  {
    public String toString()
    {
      String _result;
       _result = "FORWARD"; 
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
}
