import lang.karel.*;
import javax.swing.*;
import java.io.*;

public class KarelMain {
    public static void main(String[] args) {
        String programInput = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder inputBuilder = new StringBuilder();
            System.out.println("Enter your program (type 'END' on a new line to finish):");

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
        Karel.Machine machine = new Karel.Machine();

        // Create and display the visualization
        KarelVisualizer visualizer = new KarelVisualizer();
        SwingUtilities.invokeLater(() -> KarelVisualizer.createAndShowGUI(visualizer));

        // Execute the program and update visualization
        Karel.Machine finalMachine = Program_.operation(program).apply(machine);

        // Visualization update loop
        visualizer.updatePosition(machine.getX(), machine.getY(), machine.getDirection()); // ✅ Update with direction
        try {
            Thread.sleep(500); // ✅ Slow down movement for visualization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display final machine state
        System.out.println("Final Machine State:");
        System.out.println(finalMachine);
    }
}
