
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
          if (json.has("walls")) {
            JSONArray wallArr = json.getJSONArray("walls");
            for (int i = 0; i < wallArr.length(); i++) {
              JSONObject w = wallArr.getJSONObject(i);
              int x1 = w.getInt("x");
              int y1 = w.getInt("y");
              int x2 = w.getInt("x'");
              int y2 = w.getInt("y'");
              World.walls.add(Arrays.asList(x1, y1, x2, y2));
              World.walls.add(Arrays.asList(x2, y2, x1, y1));
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
          
      System.out.println("Input passed to parser:");
      Scanner inputScanner = new Scanner(System.in);
      while (inputScanner.hasNextLine()) {
        String line = inputScanner.nextLine();
        System.out.println(line);
      }

      System.out.println("\nParsed program:");
      String parsed = c.toString();
      System.out.println(parsed);

      System.out.println("\nDerived from execution:");

      List<String> actions = new ArrayList<>();
      String[] rawParts = parsed.split(":");
      for (int i = 0; i < rawParts.length; i++) {
        String part = rawParts[i];
        if (part.startsWith("WHILE(") || part.startsWith("IFELSE(")) {
          StringBuilder full = new StringBuilder(part);
          int depth = 0;
          for (char ch : part.toCharArray()) {
            if (ch == '(') depth++;
            else if (ch == ')') depth--;
          }
          while (depth > 0 && i + 1 < rawParts.length) {
            i++;
            full.append(":").append(rawParts[i]);
            for (char ch : rawParts[i].toCharArray()) {
              if (ch == '(') depth++;
              else if (ch == ')') depth--;
            }
          }
          actions.add(full.toString());
        } else {
          actions.add(part);
        }
      }

      int x = World.movement.get(0)[0];
      int y = World.movement.get(0)[1];
      int dir = World.movement.get(0)[2];

      for (int i = 0; i < actions.size(); i++) {
        String current = actions.get(i);

        if (current.startsWith("WHILE(")) {
          int startIdx = current.indexOf('(');
          int depth = 0;
          int endIdx = -1;
          for (int j = startIdx; j < current.length(); j++) {
            char ch = current.charAt(j);
            if (ch == '(') depth++;
            else if (ch == ')') depth--;
            if (depth == 0) {
              endIdx = j;
              break;
            }
          }
          if (endIdx == -1) throw new RuntimeException("No closing ')' found in WHILE(...)");

          String inner = current.substring(startIdx + 1, endIdx);
          int commaIdx = -1;
          depth = 0;
          for (int j = 0; j < inner.length(); j++) {
            char ch = inner.charAt(j);
            if (ch == '(') depth++;
            else if (ch == ')') depth--;
            else if (ch == ',' && depth == 0) {
              commaIdx = j;
              break;
            }
          }

          if (commaIdx == -1) throw new RuntimeException("Malformed WHILE: no top-level comma found");

          String cond = inner.substring(0, commaIdx).trim();
          String body = inner.substring(commaIdx + 1).trim();
          String unfolded = String.format("IFELSE(%s:%s, SKIP)", body, current);

          System.out.printf("<%s, ε, ((%d, %d), %d)>>%n", current, x, y, dir);
          System.out.printf("<%s:%s, ε, ((%d, %d), %d)>>%n", cond, unfolded, x, y, dir);

          actions.set(i, cond);
          actions.add(i + 1, unfolded);
          i--;
          continue;
        }

        if (current.startsWith("FORWARD-")) {
          int step = Integer.parseInt(current.split("-")[1]);

          // wypisz krok jako FORWARD-n
          String currentState = String.join(":", actions.subList(i, actions.size()));
          System.out.printf("<%s, ε, ((%d, %d), %d)>>%n", currentState, x, y, dir);

          // wykonanie nastąpi w kolejnych iteracjach
          actions.remove(i);
          actions.add(i, "FORWARD");
          if (step == 2) {
            actions.add(i + 1, "FORWARD");
          } else {
            actions.add(i + 1, "FORWARD-" + (step - 1));
          }

          i--; // wracamy na początek rozwinięcia
          continue;
        }


        if (i + 1 < actions.size() && actions.get(i + 1).startsWith("IFELSE(")) {
          String cond = current;
          String branch = actions.get(i + 1);
          boolean result = false;

          switch (cond) {
            case "FRONT-IS-CLEAR": result = canMove(x, y, dir); break;
            case "FRONT-IS-BLOCKED": result = !canMove(x, y, dir); break;
            case "LEFT-IS-CLEAR": result = canMove(x, y, (dir + 270) % 360); break;
            case "LEFT-IS-BLOCKED": result = !canMove(x, y, (dir + 270) % 360); break;
            case "RIGHT-IS-CLEAR": result = canMove(x, y, (dir + 90) % 360); break;
            case "RIGHT-IS-BLOCKED": result = !canMove(x, y, (dir + 90) % 360); break;
            case "BACK-IS-CLEAR": result = canMove(x, y, (dir + 180) % 360); break;
            case "BACK-IS-BLOCKED": result = !canMove(x, y, (dir + 180) % 360); break;
          }

          String content = branch.substring("IFELSE(".length(), branch.length() - 1);
          int depth2 = 0;
          int splitIndex = -1;
          for (int j = 0; j < content.length(); j++) {
            char ch = content.charAt(j);
            if (ch == '(') depth2++;
            else if (ch == ')') depth2--;
            else if (ch == ',' && depth2 == 0) {
              splitIndex = j;
              break;
            }
          }

          String part1 = content.substring(0, splitIndex).trim();
          String part2 = content.substring(splitIndex + 1).trim();
          String chosen = result ? part1 : part2;

          System.out.printf("<%s, %s, ((%d, %d), %d)>>%n", branch, cond, x, y, dir);

          actions.remove(i); // cond
          actions.remove(i); // IFELSE

          List<String> partsBack = new ArrayList<>();
          int depth = 0, start = 0;
          for (int j = 0; j < chosen.length(); j++) {
            char ch = chosen.charAt(j);
            if (ch == '(') depth++;
            else if (ch == ')') depth--;
            else if (ch == ':' && depth == 0) {
              String part = chosen.substring(start, j).trim();
              if (!part.isEmpty()) partsBack.add(part);
              start = j + 1;
            }
          }
          String last = chosen.substring(start).trim();
          if (!last.isEmpty()) partsBack.add(last);

          actions.addAll(i, partsBack);
          i--;
          continue;
        }

        if (current.trim().isEmpty()) continue;

        // Filtrowanie nadmiarowych rozwinięć
        if (!current.contains("WHILE(") && current.chars().filter(ch -> ch == ':').count() > 3) {
          System.out.printf("<ε, ε, ((%d, %d), %d)>>%n", x, y, dir);
          break;
        }

        String currentState = String.join(":", actions.subList(i, actions.size()));
        System.out.printf("<%s, ε, ((%d, %d), %d)>>%n", currentState, x, y, dir);

        // Wykonanie ruchu
        if (current.equals("FORWARD")) {
          if (dir == 0) y += 1;
          else if (dir == 90) x += 1;
          else if (dir == 180) y -= 1;
          else if (dir == 270) x -= 1;
        } else if (current.equals("TRIGHT")) {
          dir = (dir + 90) % 360;
        } else if (current.equals("TLEFT")) {
          dir = (dir + 270) % 360;
        }
      }

      System.out.printf("<ε, ε, ((%d, %d), %d)>>%n", x, y, dir);
      System.out.println("Final Machine State:");
      System.out.printf("((%d, %d), %d)%n", x, y, dir);

      lang.karel.KarelVisualizer.createAndShowGUI(
        new lang.karel.KarelVisualizer(
          World.movement,
          World.beeperGrid,
          World.beeperInventory,
          World.gridWidth,
          World.gridHeight,
          World.walls
        )
      );
    
          return none;
        };
      }
    }
  }
}
