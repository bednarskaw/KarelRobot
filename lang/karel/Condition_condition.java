
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Condition_condition
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
  public static _Operation operation(Condition _phrase)
  {
    switch (_phrase)
    {
      case Condition.FrontIsClear() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Condition.FrontIsBlocked() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Condition.LeftIsClear() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Condition.LeftIsBlocked() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Condition.RightIsClear() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Condition.RightIsBlocked() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Condition.BackIsClear() ->
      {
        return (_Operation)() -> 
        {
        };
      }
      case Condition.BackIsBlocked() ->
      {
        return (_Operation)() -> 
        {
        };
      }
    }
  }
}
