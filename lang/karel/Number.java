
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public sealed interface Number permits
Number.Num
{
  public record Num(String _1) implements Number
  {
    public String toString()
    {
      var n = _1;
      String _result;
       _result = n; 
      return _result;
    }
  }
}
