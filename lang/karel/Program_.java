
package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
public final class Program_
{
  public static interface _Operation
  {
    public Machine apply(Machine _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(Machine _1);
  }
  public static interface _AfterEffect
  {
    public void apply(Machine _1, Machine _2);
  }
  public static _Operation operation(Program _phrase)
  {
    switch (_phrase)
    {
      case Program.Prog(var c) ->
      {
        var _1 = Command_.operation(c);
        return (_Operation)(var machine) -> 
        {
          Machine machine0;
          machine0 = _1.apply(machine,  List.of(c) );
          return machine0;
        };
      }
    }
  }
}
