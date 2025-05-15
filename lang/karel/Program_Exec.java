
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Program_Exec
{
  public static interface _Operation
  {
    public Void apply();
  }
  public static interface _BeforeEffect
  {
    public void apply();
  }
  public static interface _AfterEffect
  {
    public void apply(Void _1);
  }
  public static _Operation operation(Program _phrase)
  {
    switch (_phrase)
    {
      case Program.Prog(var c) ->
      {
        var _1 = Command_Exec.operation(c);
        return (_Operation)() -> 
        {
          Void none;
          List<int[]> s0 =  new ArrayList<>(); ;
           try {
          File currentDir = new File(".");
          File[] jsonFiles = currentDir.listFiles((dir, name) -> name.endsWith(".json"));
          if (jsonFiles == null || jsonFiles.length == 0) {
              System.out.println("Error: No .json file found in current directory.");
              return null;
          }
          if (jsonFiles.length > 1) {
              System.out.println("Error: Multiple .json files found. Please keep only one.");
              return null;
          }

          FileReader reader = new FileReader(jsonFiles[0]);
          StringBuilder sb = new StringBuilder();
          int ch;
          while ((ch = reader.read()) != -1) sb.append((char) ch);
          reader.close();

          JSONObject json = new JSONObject(sb.toString());

           if (json.has("grid")) {
            JSONObject grid = json.getJSONObject("grid");
            if (grid.has("width")) {
              World.gridWidth = grid.getInt("width");
            }
            if (grid.has("height")) {
              World.gridHeight = grid.getInt("height");
            }
          }

          JSONObject robot = json.getJSONObject("robot");
          int startX = robot.getInt("x");
          int startY = robot.getInt("y");
          int startDir = robot.getInt("dir");
          int startBeepers = robot.getInt("beeperCount");

          JSONArray beepersArr = json.getJSONArray("beepers");
          for (int i = 0; i < beepersArr.length(); i++) {
            JSONObject b = beepersArr.getJSONObject(i);
            int bx = b.getInt("x");
            int by = b.getInt("y");
            World.beeperMap.add(Arrays.asList(bx, by));
          }

          s0.add(new int[]{startX, startY, startDir, startBeepers});
          captureStep(startX, startY, startDir, startBeepers);
        } catch (Exception e) {
          System.out.println("Error reading JSON: " + e.getMessage());
          s0.add(new int[]{0, 0, 0, 0});
          captureStep(0, 0, 0, 0);
        }

      System.out.println("Exec"); 
          List<int[]> s = _1.apply(s0);
          none =  null ;
          
      // Print parsed input
      System.out.println("Input passed to parser:");
      Scanner inputScanner = new Scanner(System.in);
      while (inputScanner.hasNextLine()) {
        String line = inputScanner.nextLine();
        System.out.println(line);
      }

      // Print parsed program
      System.out.println("\nParsed program:");
      String parsed = c.toString(); // 'c' is from Prog[c]
      System.out.println(parsed);

      List<String> actions = new ArrayList<>(Arrays.asList(parsed.split(":")));
      StringBuilder queue = new StringBuilder(parsed);
      int x = 0, y = 0, dir = 0;

      for (int i = 0; i < actions.size(); i++) {
        String action = actions.get(i);

        // Don't print by default if it's FORWARD-n, it prints manually
        if (!action.startsWith("FORWARD-")) {
          System.out.printf("<%s, ε, ((%d, %d), %d)>>%n", queue, x, y, dir);
        }

        if (action.equals("FORWARD")) {
          if (dir == 0) y += 1;
          else if (dir == 90) x += 1;
          else if (dir == 180) y -= 1;
          else if (dir == 270) x -= 1;

          if (x < 0 || x >= World.gridWidth || y < 0 || y >= World.gridHeight) {
              System.out.printf("Error: Karel moved outside the grid at (%d, %d)%n", x, y);
              return null;
          }
        }
        else if (action.equals("TRIGHT")) {
          dir = (dir + 90) % 360;
        }
        else if (action.equals("TLEFT")) {
          dir = (dir + 270) % 360;
        }
        else if (action.startsWith("FORWARD-")) {
          // Manual derivation print for FORWARD-n
          System.out.printf("<%s, ε, ((%d, %d), %d)>>%n", queue, x, y, dir);

          int step = Integer.parseInt(action.split("-")[1]);
          StringBuilder replacement;
          if (step == 2) {
            replacement = new StringBuilder("FORWARD:FORWARD");
          } else {
            replacement = new StringBuilder("FORWARD:FORWARD-" + (step - 1));
          }

          queue = new StringBuilder(queue.toString().replaceFirst("FORWARD-" + step, replacement.toString()));

          // Replace in list
          actions.remove(i);
          actions.add(i, "FORWARD");
          if (step == 2) {
            actions.add(i + 1, "FORWARD");
          } else {
            actions.add(i + 1, "FORWARD-" + (step - 1));
          }
          // Re-process first inserted FORWARD
          i--;
          continue;
        }

        // Remove action from queue
        int idx = queue.indexOf(action);
        if (idx == 0) {
          queue.delete(0, action.length());
          if (queue.length() > 0 && queue.charAt(0) == ':') queue.deleteCharAt(0);
        }
      }

      // Final derivation step
      System.out.printf("<ε, ((%d, %d), %d)>>%n", x, y, dir);
      System.out.println("Final Machine State:");
      System.out.printf("((%d, %d), %d)%n", x, y, dir);

      lang.karel.KarelVisualizer.createAndShowGUI(
        new lang.karel.KarelVisualizer(
          World.movement,
          World.beeperGrid,
          World.beeperInventory,
          World.gridWidth,
          World.gridHeight
        )
      );
    
          return none;
        };
      }
    }
  }
}
