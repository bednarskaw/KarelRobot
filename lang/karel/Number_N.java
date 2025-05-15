
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Number_N
{
  public static interface _Operation
  {
    public Integer apply();
  }
  public static interface _BeforeEffect
  {
    public void apply();
  }
  public static interface _AfterEffect
  {
    public void apply(Integer _1);
  }
  public static _Operation operation(Number _phrase)
  {
    switch (_phrase)
    {
      case Number.Num(var n) ->
      {
        return (_Operation)() -> 
        {
          Integer i;
          i = Integer.valueOf(n);
          return i;
        };
      }
    }
  }
}
