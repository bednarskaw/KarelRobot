
package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
public final class Command_
{
  public static interface _Operation
  {
    public Machine apply(Machine _1, List<Command> _2);
  }
  public static interface _BeforeEffect
  {
    public void apply(Machine _1, List<Command> _2);
  }
  public static interface _AfterEffect
  {
    public void apply(Machine _1, List<Command> _2, Machine _3);
  }
  public static _Operation operation(Command _phrase)
  {
    switch (_phrase)
    {
      case Command.Forward(var n) ->
      {
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
           System.out.println("<FORWARD-" + n + ", " + commands + ", " + machine + "> =>>"); 
           machine.executeForward(Integer.parseInt(n));
          machine0 = machine;
          return machine0;
        };
      }
      case Command.ForwardDefault() ->
      {
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
           System.out.println("<FORWARD, " + commands + ", " + machine + "> =>>"); 
           machine.execute(Instruction.FORWARD); 
          machine0 = machine;
          return machine0;
        };
      }
      case Command.TurnLeft() ->
      {
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
           System.out.println("<TLEFT, " + commands + ", " + machine + "> =>>"); 
           machine.execute(Instruction.TLEFT); 
          machine0 = machine;
          return machine0;
        };
      }
      case Command.TurnRight() ->
      {
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
           System.out.println("<TRIGHT, " + commands + ", " + machine + "> =>>"); 
           machine.execute(Instruction.TRIGHT); 
          machine0 = machine;
          return machine0;
        };
      }
      case Command.PutBeeper() ->
      {
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
           System.out.println("<PUTBEEPER, " + commands + ", " + machine + "> =>>"); 
           machine.execute(Instruction.PUTBEEPER); 
          machine0 = machine;
          return machine0;
        };
      }
      case Command.PickBeeper() ->
      {
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
           System.out.println("<PICKBEEPER, " + commands + ", " + machine + "> =>>"); 
           machine.execute(Instruction.PICKBEEPER); 
          machine0 = machine;
          return machine0;
        };
      }
      case Command.Seq(var c1, var c2) ->
      {
        var _1 = Command_.operation(c1);
        var _2 = Command_.operation(c2);
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
          Machine machine1 = _1.apply(machine, commands);
          machine0 = _2.apply(machine1, commands);
          return machine0;
        };
      }
      case Command.Reset() ->
      {
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
           System.out.println("<RESET:" + commands + ", " + machine + "> =>>"); 
           machine.execute(Instruction.RESET); 
          machine0 = machine;
          return machine0;
        };
      }
      case Command.Skip() ->
      {
        return (_Operation)(var machine, var commands) -> 
        {
          Machine machine0;
           System.out.println("<SKIP:" + commands + ", " + machine + "> =>>"); 
           machine.execute(Instruction.SKIP); 
          machine0 = machine;
          return machine0;
        };
      }
    }
  }
}
