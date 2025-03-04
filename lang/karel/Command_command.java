
package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
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
      case Command.Forward(var n) ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Command.ForwardDefault() ->
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
    }
  }
}
