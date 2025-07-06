
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Condition_Check
{
  public static interface _Operation
  {
    public boolean apply(List<int[]> _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(List<int[]> _1);
  }
  public static interface _AfterEffect
  {
    public void apply(List<int[]> _1, boolean _2);
  }
  public static _Operation operation(Condition _phrase)
  {
    switch (_phrase)
    {
      case Condition.FrontIsClear() ->
      {
        return (_Operation)(var s0) -> 
        {
          boolean b;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = s0.getLast()[2];
           b = canMove(x, y, dir); 
          return b;
        };
      }
      case Condition.FrontIsBlocked() ->
      {
        return (_Operation)(var s0) -> 
        {
          boolean b;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = s0.getLast()[2];
           b = !canMove(x, y, dir); 
          return b;
        };
      }
      case Condition.LeftIsClear() ->
      {
        return (_Operation)(var s0) -> 
        {
          boolean b;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = (s0.getLast()[2] + 270) % 360;
           b = canMove(x, y, dir); 
          return b;
        };
      }
      case Condition.LeftIsBlocked() ->
      {
        return (_Operation)(var s0) -> 
        {
          boolean b;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = (s0.getLast()[2] + 270) % 360;
           b = !canMove(x, y, dir); 
          return b;
        };
      }
      case Condition.RightIsClear() ->
      {
        return (_Operation)(var s0) -> 
        {
          boolean b;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = (s0.getLast()[2] + 90) % 360;
           b = canMove(x, y, dir); 
          return b;
        };
      }
      case Condition.RightIsBlocked() ->
      {
        return (_Operation)(var s0) -> 
        {
          boolean b;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = (s0.getLast()[2] + 90) % 360;
           b = !canMove(x, y, dir); 
          return b;
        };
      }
      case Condition.BackIsClear() ->
      {
        return (_Operation)(var s0) -> 
        {
          boolean b;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = (s0.getLast()[2] + 180) % 360;
           b = canMove(x, y, dir); 
          return b;
        };
      }
      case Condition.BackIsBlocked() ->
      {
        return (_Operation)(var s0) -> 
        {
          boolean b;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = (s0.getLast()[2] + 180) % 360;
           b = !canMove(x, y, dir); 
          return b;
        };
      }
    }
  }
}
