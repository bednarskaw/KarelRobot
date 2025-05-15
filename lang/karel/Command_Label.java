
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Command_Label
{
  public static interface _Operation
  {
    public String apply();
  }
  public static interface _BeforeEffect
  {
    public void apply();
  }
  public static interface _AfterEffect
  {
    public void apply(String _1);
  }
  public static _Operation operation(Command _phrase)
  {
    switch (_phrase)
    {
      case Command.Forward() ->
      {
        return (_Operation)() -> 
        {
          String l;
          l =  "FORWARD" ;
          return l;
        };
      }
      case Command.ForwardN(var n) ->
      {
        var _1 = Number_N.operation(n);
        return (_Operation)() -> 
        {
          String l;
          Integer v = _1.apply();
          l =  "FORWARD-" + v ;
          return l;
        };
      }
      case Command.TurnLeft() ->
      {
        return (_Operation)() -> 
        {
          String l;
          l =  "TLEFT" ;
          return l;
        };
      }
      case Command.TurnRight() ->
      {
        return (_Operation)() -> 
        {
          String l;
          l =  "TRIGHT" ;
          return l;
        };
      }
      case Command.PutBeeper() ->
      {
        return (_Operation)() -> 
        {
          String l;
          l =  "PUTBEEPER" ;
          return l;
        };
      }
      case Command.PickBeeper() ->
      {
        return (_Operation)() -> 
        {
          String l;
          l =  "PICKBEEPER" ;
          return l;
        };
      }
      case Command.Reset() ->
      {
        return (_Operation)() -> 
        {
          String l;
          l =  "RESET" ;
          return l;
        };
      }
      case Command.Skip() ->
      {
        return (_Operation)() -> 
        {
          String l;
          l =  "SKIP" ;
          return l;
        };
      }
      case Command.Seq(var c1, var c2) ->
      {
        var _1 = Command_Label.operation(c1);
        var _2 = Command_Label.operation(c2);
        return (_Operation)() -> 
        {
          String l;
          String l1 = _1.apply();
          String l2 = _2.apply();
          l =  l1 + ":" + l2 ;
          return l;
        };
      }
    }
  }
}
