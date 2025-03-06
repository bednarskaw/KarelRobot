import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;

public class KarelVisualizer extends JPanel {
    private int x = 0, y = 0;
    private int direction = 0;
    private int beeperCount = 0;  // ✅ Track the number of beepers in inventory
    private static final int CELL_SIZE = 50;
    private static final int GRID_SIZE = 10;

    private BufferedImage northImage, southImage, eastImage, westImage, beeperImage;
    private final List<int[]> movementHistory;
    private final List<boolean[][]> beeperHistory;
    private final List<Integer> beeperInventoryHistory;
    private int stepIndex = 0;


    public KarelVisualizer(List<int[]> movementHistory, List<boolean[][]> beeperHistory, List<Integer> beeperInventoryHistory) {
        this.movementHistory = movementHistory;
        this.beeperHistory = beeperHistory;
        this.beeperInventoryHistory = beeperInventoryHistory;
        setPreferredSize(new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE));
        loadImages();
    }

    // ✅ Load robot and beeper images
    private void loadImages() {
        try {
            northImage = ImageIO.read(new File("photos/north.png"));
            southImage = ImageIO.read(new File("photos/south.png"));
            eastImage = ImageIO.read(new File("photos/east.png"));
            westImage = ImageIO.read(new File("photos/west.png"));
            beeperImage = ImageIO.read(new File("photos/beeper.png"));
        } catch (Exception e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    }

    // ✅ Move to the next step
    public void moveForward() {
        if (stepIndex < movementHistory.size() - 1) {
            stepIndex++;
            updateRobotPosition();
        }
    }

    // ✅ Move backward
    public void moveBackward() {
        if (stepIndex > 0) {
            stepIndex--;
            updateRobotPosition();
        }
    }

    // ✅ Move to the first recorded position (Start)
    public void moveToStart() {
        stepIndex = 0;
        updateRobotPosition();
    }

    // ✅ Move to the last recorded position (Final)
    public void moveToFinal() {
        stepIndex = movementHistory.size() - 1;
        updateRobotPosition();
    }

    // ✅ Updates the robot position based on history
    private void updateRobotPosition() {
        int[] state = movementHistory.get(stepIndex);
        x = state[0];
        y = state[1];
        direction = state[2];
        repaint();
    }

    // ✅ Updates the visualization when `putbeeper` or `pickbeeper` is executed
//    public void updateBeepers(boolean[][] newBeepers, int newBeeperCount) {
//        for (int i = 0; i < GRID_SIZE; i++) {
//            for (int j = 0; j < GRID_SIZE; j++) {
//                beepers[i][j] = newBeepers[i][j];
//            }
//        }
//        beeperCount = newBeeperCount; // ✅ Update the beeper inventory count
//        repaint();
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // ✅ Set background to black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // ✅ Draw white grid lines
        g.setColor(Color.WHITE);
        for (int i = 0; i <= GRID_SIZE; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, GRID_SIZE * CELL_SIZE); // Vertical lines
            g.drawLine(0, i * CELL_SIZE, GRID_SIZE * CELL_SIZE, i * CELL_SIZE); // Horizontal lines
        }

        // ✅ Draw beepers at their positions
        boolean[][] currentBeepers = beeperHistory.get(stepIndex);
        if (beeperImage != null) {
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (currentBeepers[i][j]) {
                        g.drawImage(beeperImage, i * CELL_SIZE + 15, (GRID_SIZE - 1 - j) * CELL_SIZE + 15, CELL_SIZE - 30, CELL_SIZE - 30, this);
                    }
                }
            }
        }

        // ✅ Draw beeper inventory count
        g.setColor(Color.YELLOW);
        g.drawString("Beeper Inventory: " + beeperInventoryHistory.get(stepIndex), 10, 20);

        // ✅ Choose correct robot image based on direction
        BufferedImage robotImage = switch (direction) {
            case 0 -> northImage;
            case 1 -> eastImage;
            case 2 -> southImage;
            case 3 -> westImage;
            default -> northImage;
        };

        // ✅ Draw robot at (x, y)
        if (robotImage != null) {
            g.drawImage(robotImage, x * CELL_SIZE + 5, (GRID_SIZE - 1 - y) * CELL_SIZE + 5, CELL_SIZE - 10, CELL_SIZE - 10, this);
        }
    }


    // ✅ Create GUI with Arrow Buttons and Double Arrows
    public static void createAndShowGUI(KarelVisualizer visualizer) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Karel Robot Visualization");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // ✅ Add grid visualization
            frame.add(visualizer, BorderLayout.CENTER);

            // ✅ Create button panel
            JPanel buttonPanel = new JPanel();
            JButton toStartButton = new JButton("⏮️"); // Go to Start
            JButton backwardButton = new JButton("⬅️"); // Left Arrow
            JButton forwardButton = new JButton("➡️");  // Right Arrow
            JButton toFinalButton = new JButton("⏭️"); // Go to Final

            // ✅ Button actions
            toStartButton.addActionListener(e -> visualizer.moveToStart());
            backwardButton.addActionListener(e -> visualizer.moveBackward());
            forwardButton.addActionListener(e -> visualizer.moveForward());
            toFinalButton.addActionListener(e -> visualizer.moveToFinal());

            // ✅ Add buttons to panel
            buttonPanel.add(toStartButton);
            buttonPanel.add(backwardButton);
            buttonPanel.add(forwardButton);
            buttonPanel.add(toFinalButton);

            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
