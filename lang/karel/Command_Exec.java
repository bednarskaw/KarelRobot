
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Command_Exec
{
  public static interface _Operation
  {
    public List<int[]> apply(List<int[]> _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(List<int[]> _1);
  }
  public static interface _AfterEffect
  {
    public void apply(List<int[]> _1, List<int[]> _2);
  }
  public static _Operation operation(Command _phrase)
  {
    switch (_phrase)
    {
      case Command.Forward() ->
      {
        return (_Operation)(var s0) -> 
        {
          List<int[]> s;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = s0.getLast()[2];
          int beeper = s0.getLast()[3];
           if (dir == 0) y += 1;
        else if (dir == 90) x += 1;
        else if (dir == 180) y -= 1;
        else if (dir == 270) x -= 1;
        s0.add(new int[]{x, y, dir, beeper});
        captureStep(x, y, dir, beeper); 
          s = s0;
          return s;
        };
      }
      case Command.ForwardN(var n) ->
      {
        var _1 = Number_N.operation(n);
        return (_Operation)(var s0) -> 
        {
          List<int[]> s;
          Integer steps = _1.apply();
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = s0.getLast()[2];
          int beeper = s0.getLast()[3];
           for (int i = 0; i < steps; i++) {
          if (dir == 0) y += 1;
          else if (dir == 90) x += 1;
          else if (dir == 180) y -= 1;
          else if (dir == 270) x -= 1;
          s0.add(new int[]{x, y, dir, beeper});
          captureStep(x, y, dir, beeper);
        } 
          s = s0;
          return s;
        };
      }
      case Command.TurnLeft() ->
      {
        return (_Operation)(var s0) -> 
        {
          List<int[]> s;
          int dir = (s0.getLast()[2] + 270) % 360;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int beeper = s0.getLast()[3];
           s0.add(new int[]{x, y, dir, beeper});
        captureStep(x, y, dir, beeper); 
          s = s0;
          return s;
        };
      }
      case Command.TurnRight() ->
      {
        return (_Operation)(var s0) -> 
        {
          List<int[]> s;
          int dir = (s0.getLast()[2] + 90) % 360;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int beeper = s0.getLast()[3];
           s0.add(new int[]{x, y, dir, beeper});
        captureStep(x, y, dir, beeper); 
          s = s0;
          return s;
        };
      }
      case Command.PickBeeper() ->
      {
        return (_Operation)(var s0) -> 
        {
          List<int[]> s;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = s0.getLast()[2];
          int beeperCount = s0.getLast()[3];
           List<Integer> pos = Arrays.asList(x, y);
        if (World.beeperMap.contains(pos)) {
          World.beeperMap.remove(pos);
          beeperCount += 1;
        }
        s0.add(new int[]{x, y, dir, beeperCount});
        captureStep(x, y, dir, beeperCount); 
          s = s0;
          return s;
        };
      }
      case Command.PutBeeper() ->
      {
        return (_Operation)(var s0) -> 
        {
          List<int[]> s;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = s0.getLast()[2];
          int beeperCount = s0.getLast()[3];
           if (beeperCount > 0) {
          beeperCount -= 1;
          World.beeperMap.add(Arrays.asList(x, y));
        }
        s0.add(new int[]{x, y, dir, beeperCount});
        captureStep(x, y, dir, beeperCount); 
          s = s0;
          return s;
        };
      }
      case Command.Reset() ->
      {
        return (_Operation)(var s0) -> 
        {
          List<int[]> s;
           s0.clear(); s0.add(new int[]{0, 0, 0, 0});
        captureStep(0, 0, 0, 0); 
          s = s0;
          return s;
        };
      }
      case Command.Skip() ->
      {
        return (_Operation)(var s0) -> 
        {
          List<int[]> s;
          int x = s0.getLast()[0];
          int y = s0.getLast()[1];
          int dir = s0.getLast()[2];
          int beeperCount = s0.getLast()[3];
           captureStep(x, y, dir, beeperCount); 
          s = s0;
          return s;
        };
      }
      case Command.Seq(var c1, var c2) ->
      {
        var _1 = Command_Exec.operation(c1);
        var _2 = Command_Exec.operation(c2);
        return (_Operation)(var s) -> 
        {
          List<int[]> s2;
          List<int[]> s1 = _1.apply(s);
          s2 = _2.apply(s1);
          return s2;
        };
      }
    }
  }
}
