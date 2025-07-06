
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public sealed interface Condition permits
Condition.FrontIsClear, Condition.FrontIsBlocked, Condition.LeftIsClear, Condition.LeftIsBlocked, Condition.RightIsClear, Condition.RightIsBlocked, Condition.BackIsClear, Condition.BackIsBlocked
{
  public record FrontIsClear() implements Condition
  {
    public String toString()
    {
      String _result;
       _result = "FRONT-IS-CLEAR"; 
      return _result;
    }
  }
  public record FrontIsBlocked() implements Condition
  {
    public String toString()
    {
      String _result;
       _result = "FRONT-IS-BLOCKED"; 
      return _result;
    }
  }
  public record LeftIsClear() implements Condition
  {
    public String toString()
    {
      String _result;
       _result = "LEFT-IS-CLEAR"; 
      return _result;
    }
  }
  public record LeftIsBlocked() implements Condition
  {
    public String toString()
    {
      String _result;
       _result = "LEFT-IS-BLOCKED"; 
      return _result;
    }
  }
  public record RightIsClear() implements Condition
  {
    public String toString()
    {
      String _result;
       _result = "RIGHT-IS-CLEAR"; 
      return _result;
    }
  }
  public record RightIsBlocked() implements Condition
  {
    public String toString()
    {
      String _result;
       _result = "RIGHT-IS-BLOCKED"; 
      return _result;
    }
  }
  public record BackIsClear() implements Condition
  {
    public String toString()
    {
      String _result;
       _result = "BACK-IS-CLEAR"; 
      return _result;
    }
  }
  public record BackIsBlocked() implements Condition
  {
    public String toString()
    {
      String _result;
       _result = "BACK-IS-BLOCKED"; 
      return _result;
    }
  }
}
