
package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
public final class Karel
{
    public enum Instruction { FORWARD, FORWARD_N, TLEFT, TRIGHT, RESET, SKIP }

    public static class Machine {
        private int x = 0, y = 0, direction = 0;
        private List<int[]> movementHistory = new ArrayList<>();

        public int getX() { return x; }
        public int getY() { return y; }
        public int getDirection() { return direction; }
        public List<int[]> getHistory() { return movementHistory; }

        public Machine() {
            movementHistory.add(new int[]{x, y, direction}); // ✅ Store Initial Position
        }

        public void executeForward(int n) {
            for (int i = 0; i < n; i++) {
                execute(Instruction.FORWARD);
                if (movementHistory.isEmpty() || hasPositionChanged()) {  // ✅ Only store new positions
                    movementHistory.add(new int[]{x, y, direction});
                }
            }
        }

        public void execute(Instruction inst, int... params) {
            int oldX = x, oldY = y, oldDir = direction; // ✅ Track old position

            switch (inst) {
                case FORWARD:
                    move(1);
                    break;
                case TLEFT:
                    direction = (direction + 3) % 4;
                    break;
                case TRIGHT:
                    direction = (direction + 1) % 4;
                    break;
                case RESET:
                    x = 0; y = 0; direction = 0;
                    break;
                case SKIP:
                    break;
            }
            if (hasPositionChanged()) {  // ✅ Only store if position/direction changed
                movementHistory.add(new int[]{x, y, direction});
            }
        }

        private void move(int steps) {
            switch (direction) {
                case 0: y += steps; break;
                case 1: x += steps; break;
                case 2: y -= steps; break;
                case 3: x -= steps; break;
            }
        }

        private boolean hasPositionChanged() {  // ✅ Ensures no duplicate positions
            int[] last = movementHistory.get(movementHistory.size() - 1);
            return last[0] != x || last[1] != y || last[2] != direction;
        }

        @Override
        public String toString() {
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
