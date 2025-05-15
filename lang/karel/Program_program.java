
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Program_program
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
  public static _Operation operation(Program _phrase)
  {
    switch (_phrase)
    {
      case Program.Prog(var c) ->
      {
        var _1 = Command_command.operation(c);
        return (_Operation)() -> 
        {
          _1.apply();
        };
      }
    }
  }
}
