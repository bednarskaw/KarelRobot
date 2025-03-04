
package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
public final class Karel
{

    public enum Instruction { FORWARD, TLEFT, TRIGHT, RESET, SKIP }
    public static class Machine
    {
      private int x = 0, y = 0, direction = 0; // 0: North, 1: East, 2: South, 3: West
      public int getX() { return x; }
      public int getY() { return y; }
      public int getDirection() { return direction; }
      // Handle both FORWARD and FORWARD-N
      public void executeForward(int n)
      {
        if (n == 1) {
            System.out.println("<FORWARD, E, " + this + "> =>>");
            execute(Instruction.FORWARD);
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println("<FORWARD, E, " + this + "> =>>");
                execute(Instruction.FORWARD);
            }
        }
      }

      public void execute(Instruction inst, int... params)
      {
        switch (inst)
        {
          case FORWARD:
            move(1);
            break;
          case TLEFT:
            direction = (direction + 3) % 4; // Turn counterclockwise
            break;
          case TRIGHT:
            direction = (direction + 1) % 4; // Turn clockwise
            break;
          case RESET:
            x = 0; y = 0; direction = 0;
            break;
          case SKIP:
            break; // Do nothing
        }
      }

      private void move(int steps)
      {
        switch (direction)
        {
          case 0: y += steps; break; // North
          case 1: x += steps; break; // East
          case 2: y -= steps; break; // South
          case 3: x -= steps; break; // West
        }
      }

      @Override
      public String toString()
      {
        return "((" + x + ", " + y + "), " + (direction * 90) + ")";
      }
    }
  
      public static class Program {
          private final Command command;

          public Program(Command command) {
              this.command = command;
          }

          public Command getCommand() {
              return command;
          }
      }
  
}
