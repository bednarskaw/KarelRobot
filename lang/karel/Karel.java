
package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
public final class Karel
{
    public enum Instruction { FORWARD, TLEFT, TRIGHT, RESET, SKIP, PUTBEEPER, PICKBEEPER }

    public static class Machine {
        private int x = 0, y = 0, direction = 0;
        private boolean[][] beepersGrid = new boolean[10][10];
        private int beeperCount = 0;
        private List<int[]> movementHistory = new ArrayList<>();
        private List<boolean[][]> beeperHistory = new ArrayList<>();
        private List<Integer> beeperInventoryHistory = new ArrayList<>();

        public int getX() { return x; }
        public int getY() { return y; }
        public int getDirection() { return direction; }
        public int getBeeperCount() { return beeperCount; }
        public boolean[][] getBeepersGrid() { return beepersGrid; }
        public List<int[]> getHistory() { return movementHistory; }
        public List<boolean[][]> getBeeperHistory() { return beeperHistory; }
        public List<Integer> getBeeperInventoryHistory() { return beeperInventoryHistory; }

        public Machine(boolean[][] initialBeepers) {
            movementHistory.add(new int[]{x, y, direction});
            beeperHistory.add(copyBeepers(initialBeepers));
            beeperInventoryHistory.add(beeperCount);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    beepersGrid[i][j] = initialBeepers[i][j];
                }
            }
        }


        public void executeForward(int n) {
            for (int i = 0; i < n; i++) {
                execute(Instruction.FORWARD);
                if (movementHistory.isEmpty() || hasPositionChanged()) {
                    movementHistory.add(new int[]{x, y, direction});
                }
            }
        }

        public void execute(Instruction inst, int... params) {
            int oldX = x, oldY = y, oldDir = direction;
            boolean[][] oldBeepers = copyBeepers(beepersGrid);

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
                    beeperCount = 0;
                    break;
                case SKIP:
                    break;
                 case PUTBEEPER:
                    putBeeper();
                    break;
                case PICKBEEPER:
                    pickBeeper();
                    break;
            }
            if (hasPositionChanged()) {
                movementHistory.add(new int[]{x, y, direction});
                beeperHistory.add(copyBeepers(beepersGrid));
                beeperInventoryHistory.add(beeperCount);
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

        private boolean hasPositionChanged() {
            int[] last = movementHistory.get(movementHistory.size() - 1);
            return last[0] != x || last[1] != y || last[2] != direction;
        }

        private boolean[][] copyBeepers(boolean[][] original) {
            boolean[][] copy = new boolean[10][10];
            for (int i = 0; i < 10; i++) {
                System.arraycopy(original[i], 0, copy[i], 0, 10);
            }
            return copy;
        }

        private void putBeeper() {
            if (beeperCount > 0) { // ✅ Only allow placing a beeper if the robot has one
                if (!beepersGrid[x][y]) {
                    beepersGrid[x][y] = true;
                    beeperCount--;  // ✅ Decrease beeper inventory
                    System.out.println("<PUTBEEPER, (" + x + ", " + y + ")>");
                } else {
                    System.out.println("❌ Cannot place beeper: Already exists at (" + x + ", " + y + ")");
                }
            } else {
                System.out.println("❌ Cannot place beeper: No beepers in inventory!");
            }
        }

        private void pickBeeper() {
            if (beepersGrid[x][y]) {
                beepersGrid[x][y] = false;
                beeperCount++;  // ✅ Increase beeper inventory
                System.out.println("<PICKBEEPER, (" + x + ", " + y + ")>");
            } else {
                System.out.println("❌ Cannot pick beeper: No beeper at (" + x + ", " + y + ")");
            }
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
