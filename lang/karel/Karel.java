
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
  
}
