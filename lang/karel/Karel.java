
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
        // Initial FORWARD-n print
        System.out.println("<FORWARD-" + n + ", ε, ((" + x + ", " + y + "), " + (direction * 90) + ")> =>>");

        for (int i = n; i > 2; i--) {
            // Decompose FORWARD-n to FORWARD:FORWARD-(n-1)
            System.out.println("<FORWARD:FORWARD-" + (i - 1) + ", ε, ((" + x + ", " + y + "), " + (direction * 90) + ")> =>>");
            execute(Instruction.FORWARD);  // Move
            System.out.println("<FORWARD-" + (i - 1) + ", ε, ((" + x + ", " + y + "), " + (direction * 90) + ")> =>>");
            recordMovementStep();  // ✅ Track move
        }

        // Final decomposition: FORWARD:FORWARD
        System.out.println("<FORWARD:FORWARD, ε, ((" + x + ", " + y + "), " + (direction * 90) + ")> =>>");
        execute(Instruction.FORWARD);  // Move
        System.out.println("<FORWARD, ε, ((" + x + ", " + y + "), " + (direction * 90) + ")> =>>");
        recordMovementStep();

        // Final move for the last FORWARD
        execute(Instruction.FORWARD);  // Move
        System.out.println("<ε, ε, ((" + x + ", " + y + "), " + (direction * 90) + ")> =>>");
        recordMovementStep();
    }

        // Call this ONLY after movement commands
        private void recordMovementStep() {
            int[] last = movementHistory.get(movementHistory.size() - 1);
            if (last[0] != x || last[1] != y || last[2] != direction) {
                movementHistory.add(new int[]{x, y, direction});
                beeperHistory.add(copyBeepers(beepersGrid));
                beeperInventoryHistory.add(beeperCount);
            }
        }

        // Call this after ALL commands to ensure step is tracked
        private void recordAnyStep() {
            movementHistory.add(new int[]{x, y, direction});
            beeperHistory.add(copyBeepers(beepersGrid));
            beeperInventoryHistory.add(beeperCount);
        }



        public void executeCommandList(List<String> commands) {
            while (!commands.isEmpty()) {
              String cmd = commands.remove(0);

              if (cmd.startsWith("FORWARD-")) {
                  int n = Integer.parseInt(cmd.substring(8));
                  if (n == 1) {
                      cmd = "FORWARD";  // ✅ Normalize FORWARD-1
                  } else if (n == 2) {
                      System.out.println("<FORWARD-2:" + String.join(":", commands) + ", ε, " + this + "> =>>");
                      commands.add(0, "FORWARD");
                      commands.add(0, "FORWARD");
                      continue;  // Skip printing cmd now, handled recursively
                  } else {
                      System.out.println("<FORWARD-" + n + ":" + String.join(":", commands) + ", ε, " + this + "> =>>");
                      commands.add(0, "FORWARD-" + (n - 1));
                      commands.add(0, "FORWARD");
                      continue;
                  }
              }


             if (cmd.equals("FORWARD")) {
                 System.out.println("<FORWARD:" + String.join(":", commands) + ", ε, " + this + "> =>>");
                 execute(Instruction.FORWARD);
             } else {
                 System.out.println("<" + cmd + ":" + String.join(":", commands) + ", ε, " + this + "> =>>");
                 execute(parseInstruction(cmd));  // this prints result for pick/put internally
             }
            }

            System.out.println("<ε, ε, " + this + "> =>>");
        }


public void execute(Instruction inst, int... params) {
    int oldX = x, oldY = y, oldDir = direction;

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

    if (inst == Instruction.FORWARD || inst == Instruction.TLEFT || inst == Instruction.TRIGHT || inst == Instruction.RESET) {
        recordMovementStep();
    } else {
        recordAnyStep();  // ✅ Beeper actions, SKIP, etc.
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
            if (beeperCount > 0) {
                if (!beepersGrid[x][y]) {
                    beepersGrid[x][y] = true;
                    beeperCount--;
                    // ✅ Remove: System.out.println("<PUTBEEPER, (" + x + ", " + y + ")>");
                } else {
                    System.out.println("❌ Cannot place beeper: Already exists at (" + x + ", " + y + ")");
                }
            } else {
                System.out.println("❌ Cannot place beeper: No beepers in inventory!");
            }
        }

        private Instruction parseInstruction(String cmd) {
            return switch (cmd) {
                case "TRIGHT" -> Instruction.TRIGHT;
                case "TLEFT" -> Instruction.TLEFT;
                case "RESET" -> Instruction.RESET;
                case "SKIP" -> Instruction.SKIP;
                case "PUTBEEPER" -> Instruction.PUTBEEPER;
                case "PICKBEEPER" -> Instruction.PICKBEEPER;
                default -> throw new IllegalArgumentException("Unknown cmd: " + cmd);
            };
        }


        private void pickBeeper() {
            if (beepersGrid[x][y]) {
                beepersGrid[x][y] = false;
                beeperCount++;
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
