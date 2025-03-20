import lang.karel.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KarelMain {
    private static final int GRID_SIZE = 10;
    private static final boolean[][] beepers = new boolean[GRID_SIZE][GRID_SIZE];

    public static void main(String[] args) {
        // ✅ Generate random beeper positions before program input
        placeRandomBeepers(5); // Change the number to generate more or fewer beepers

        // ✅ Display beeper positions in the console
        System.out.println("Beeper positions:");
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (beepers[i][j]) {
                    System.out.println("Beeper at: (" + i + ", " + j + ")");
                }
            }
        }

        String programInput = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder inputBuilder = new StringBuilder();
            System.out.println("\nEnter your program (type 'END' on a new line to finish):");

            String line;
            while ((line = reader.readLine()) != null) {
                if ("END".equals(line.trim())) {
                    break;
                }
                inputBuilder.append(line).append("\n");
            }

            programInput = inputBuilder.toString().replaceAll("\\s+", " ").trim();
            System.out.println("Input passed to parser:");
            System.out.println(programInput);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Parse the program
        Program program = Karel_parser.parseProgram(programInput);
        System.out.println("Parsed program:");
        System.out.println(program);

        // Type-checking
        Program_program.operation(program).apply();

        // Initialize the Machine
        Karel.Machine machine = new Karel.Machine(beepers);

        // Execute the program
        Karel.Machine finalMachine = Program_.operation(program).apply(machine);

        // ✅ Pass beeper positions to KarelVisualizer
        KarelVisualizer visualizer = new KarelVisualizer(
                finalMachine.getHistory(),
                finalMachine.getBeeperHistory(),
                finalMachine.getBeeperInventoryHistory()
        );


        SwingUtilities.invokeLater(() -> KarelVisualizer.createAndShowGUI(visualizer));

        // Display final machine state
        System.out.println("Final Machine State:");
        System.out.println(finalMachine);
    }

    // ✅ Generate random beeper positions
    private static void placeRandomBeepers(int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int bx, by;
            do {
                bx = rand.nextInt(GRID_SIZE);
                by = rand.nextInt(GRID_SIZE);
            } while (beepers[bx][by]); // Avoid placing two beepers in the same spot
            beepers[bx][by] = true;
        }
    }
}
