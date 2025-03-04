
package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
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
