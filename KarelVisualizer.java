import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;

public class KarelVisualizer extends JPanel {
    private int x = 0, y = 0;
    private int direction = 0;
    private static final int CELL_SIZE = 50;
    private static final int GRID_SIZE = 10;

    private BufferedImage northImage, southImage, eastImage, westImage;
    private final List<int[]> movementHistory;
    private int stepIndex = 0; // ✅ Start at the first position

    public KarelVisualizer(List<int[]> movementHistory) {
        this.movementHistory = movementHistory;
        setPreferredSize(new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE));
        loadImages();
    }

    // Load images
    private void loadImages() {
        try {
            northImage = ImageIO.read(new File("photos/north.png"));
            southImage = ImageIO.read(new File("photos/south.png"));
            eastImage = ImageIO.read(new File("photos/east.png"));
            westImage = ImageIO.read(new File("photos/west.png"));
        } catch (Exception e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    }

    // Move to the next step
    public void moveForward() {
        if (stepIndex < movementHistory.size() - 1) {
            stepIndex++;
            updateRobotPosition();
        }
    }

    // ✅ Move backward, ensuring it can return to the starting position
    public void moveBackward() {
        if (stepIndex > 0) {  // ✅ Allow going all the way back to the starting position
            stepIndex--;
            updateRobotPosition();
        }
    }

    // ✅ Updates the robot position based on history
    private void updateRobotPosition() {
        int[] state = movementHistory.get(stepIndex);
        x = state[0];
        y = state[1];
        direction = state[2];
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set background to black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw white grid
        g.setColor(Color.WHITE);
        for (int i = 0; i <= GRID_SIZE; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, GRID_SIZE * CELL_SIZE);
            g.drawLine(0, i * CELL_SIZE, GRID_SIZE * CELL_SIZE, i * CELL_SIZE);
        }

        // Choose correct robot image
        BufferedImage robotImage = switch (direction) {
            case 0 -> northImage;
            case 1 -> eastImage;
            case 2 -> southImage;
            case 3 -> westImage;
            default -> northImage;
        };

        // Draw robot image at (x, y)
        if (robotImage != null) {
            g.drawImage(robotImage, x * CELL_SIZE + 5, (GRID_SIZE - 1 - y) * CELL_SIZE + 5, CELL_SIZE - 10, CELL_SIZE - 10, this);
        }
    }

    // ✅ Create GUI with Arrow Buttons
    public static void createAndShowGUI(KarelVisualizer visualizer) {
        JFrame frame = new JFrame("Karel Robot Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Add grid visualization
        frame.add(visualizer, BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        JButton backwardButton = new JButton("⬅️"); // Left Arrow
        JButton forwardButton = new JButton("➡️");  // Right Arrow

        // Button actions
        forwardButton.addActionListener(e -> visualizer.moveForward());
        backwardButton.addActionListener(e -> visualizer.moveBackward());

        buttonPanel.add(backwardButton);
        buttonPanel.add(forwardButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
