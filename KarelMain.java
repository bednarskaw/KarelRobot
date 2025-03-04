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

        // Execute the program
        Karel.Machine finalMachine = Program_.operation(program).apply(machine);

        // ✅ Create and display visualization with movement history
        KarelVisualizer visualizer = new KarelVisualizer(finalMachine.getHistory());
        SwingUtilities.invokeLater(() -> KarelVisualizer.createAndShowGUI(visualizer));

        // Display final machine state
        System.out.println("Final Machine State:");
        System.out.println(finalMachine);
    }
}
