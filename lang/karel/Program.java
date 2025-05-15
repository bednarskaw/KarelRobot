
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public sealed interface Program permits
Program.Prog
{
  public record Prog(Command _1) implements Program
  {
    public String toString()
    {
      var c = _1;
      String _result;
       _result = c.toString(); 
      return _result;
    }
  }
}
