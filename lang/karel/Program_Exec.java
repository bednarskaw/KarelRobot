
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
      List<String> actions = new ArrayList<>(Arrays.asList(parsed.split(":")));
      StringBuilder queue = new StringBuilder(parsed);
      int x = 0, y = 0, dir = 0;

      for (int i = 0; i < actions.size(); i++) {
        String current = actions.get(i);

        // 🔁 Obsługa FORWARD-n
        if (current.startsWith("FORWARD-")) {
          // 1. Wypisz stan z nierozwiniętym makrem
          System.out.printf("<%s, ε, ((%d, %d), %d)>>%n", queue, x, y, dir);

          // 2. Rozwiń makro
          int step = Integer.parseInt(current.split("-")[1]);
          StringBuilder replacement = (step == 2)
              ? new StringBuilder("FORWARD:FORWARD")
              : new StringBuilder("FORWARD:FORWARD-" + (step - 1));

          queue = new StringBuilder(queue.toString().replaceFirst("FORWARD-" + step, replacement.toString()));
          actions.remove(i);
          actions.add(i, "FORWARD");
          if (step == 2) {
            actions.add(i + 1, "FORWARD");
          } else {
            actions.add(i + 1, "FORWARD-" + (step - 1));
          }

          i--; // przetwarzamy rozwinięty krok od nowa
          continue;
        }


        // 🖨️ Wyświetl konfigurację przed wykonaniem
        System.out.printf("<%s, ε, ((%d, %d), %d)>>%n", queue, x, y, dir);

        // 🔀 Obsługa BRANCH po warunku
        if (i + 1 < actions.size() && actions.get(i + 1).startsWith("BRANCH(")) {
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

          String content = branch.substring("BRANCH(".length(), branch.length() - 1);
          String[] parts = content.split(",", 2);
          String chosen = result ? parts[0].trim() : parts[1].trim();

          // 🖨️ Rozwinięcie BRANCH
          System.out.printf("<%s, %s, ((%d, %d), %d)>>%n", branch, cond, x, y, dir);
          System.out.printf("<%s, ε, ((%d, %d), %d)>>%n", chosen, x, y, dir);

          // 🧭 Ruch w zależności od wyboru
          if (chosen.equals("FORWARD")) {
            if (dir == 0) y += 1;
            else if (dir == 90) x += 1;
            else if (dir == 180) y -= 1;
            else if (dir == 270) x -= 1;
          } else if (chosen.equals("TLEFT")) {
            dir = (dir + 270) % 360;
          } else if (chosen.equals("TRIGHT")) {
            dir = (dir + 90) % 360;
          }

          // Zamiana BRANCH+warunek na ε
          actions.remove(i);       // warunek
          actions.remove(i);       // BRANCH
          actions.add(i, "ε");     // ε
          queue = new StringBuilder(String.join(":", actions));
          continue;
        }

        // 🚶 Ruch dla zwykłych komend
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

        // 🔧 Usuń z kolejki
        int idx = queue.indexOf(current);
        if (idx == 0) {
          queue.delete(0, current.length());
          if (queue.length() > 0 && queue.charAt(0) == ':') queue.deleteCharAt(0);
        }
      }

      // 🏁 Koniec
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
