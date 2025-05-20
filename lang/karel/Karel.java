
package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
public final class Karel
{

    public static class World {
      public static Set<List<Integer>> beeperMap = new HashSet<>();
      public static List<int[]> movement = new ArrayList<>();
      public static List<boolean[][]> beeperGrid = new ArrayList<>();
      public static List<Integer> beeperInventory = new ArrayList<>();
      public static Set<List<Integer>> walls = new HashSet<>();
      public static int gridWidth = 10;
      public static int gridHeight = 10;
    }

    public static void captureStep(int x, int y, int dir, int beeperCount) {
      World.movement.add(new int[]{x, y, dir});
      World.beeperInventory.add(beeperCount);
      boolean[][] grid = new boolean[World.gridWidth][World.gridHeight];
      for (List<Integer> pos : World.beeperMap) {
        int bx = pos.get(0), by = pos.get(1);
        if (bx >= 0 && bx < World.gridWidth && by >= 0 && by < World.gridHeight)
          grid[bx][by] = true;
      }

      World.beeperGrid.add(grid);
    }

    public static boolean canMove(int x, int y, int dir) {
      int nx = x, ny = y;
      if (dir == 0) ny += 1;
      else if (dir == 90) nx += 1;
      else if (dir == 180) ny -= 1;
      else if (dir == 270) nx -= 1;

      if (nx < 0 || nx >= World.gridWidth || ny < 0 || ny >= World.gridHeight) {
        return false;
      }

      if (World.walls.contains(Arrays.asList(x, y, nx, ny))) return false;

      return true;
    }

  
}
