
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Command_command
{
  public static interface _Operation
  {
    public void apply();
  }
  public static interface _BeforeEffect
  {
    public void apply();
  }
  public static interface _AfterEffect
  {
    public void apply();
  }
  public static _Operation operation(Command _phrase)
  {
    switch (_phrase)
    {
      case Command.Forward() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.ForwardN(var n) ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.TurnLeft() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.TurnRight() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.Reset() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.Skip() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.PutBeeper() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.PickBeeper() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.Seq(var c1, var c2) ->
      {
        var _1 = Command_command.operation(c1);
        var _2 = Command_command.operation(c2);
        return (_Operation)() -> 
        {
          _1.apply();
          _2.apply();
        };
      }
      case Command.IfElse(var b, var c1, var c2) ->
      {
        var _1 = Condition_condition.operation(b);
        var _2 = Command_command.operation(c1);
        var _3 = Command_command.operation(c2);
        return (_Operation)() -> 
        {
          _1.apply();
          _2.apply();
          _3.apply();
        };
      }
      case Command.While(var b, var c) ->
      {
        var _1 = Condition_condition.operation(b);
        var _2 = Command_command.operation(c);
        return (_Operation)() -> 
        {
          _1.apply();
          _2.apply();
        };
      }
    }
  }
}
