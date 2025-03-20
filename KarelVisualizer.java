import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;

public class KarelVisualizer extends JPanel {
    private int x = 0, y = 0;
    private int direction = 0;
    private int beeperCount = 0;
    private static final int CELL_SIZE = 50;
    private static final int GRID_SIZE = 10;
    private static final int BEEPER_SIZE = 30;
    private static final int LEFT_PADDING = 60;
    private static final int TOP_PADDING = 60;
    private static final int RIGHT_PADDING = 0;  // ➕ ADD
    private static final int BOTTOM_PADDING = 10; // ➕ ADD

    private BufferedImage northImage, southImage, eastImage, westImage, beeperImage;
    private final List<int[]> movementHistory;
    private final List<boolean[][]> beeperHistory;
    private final List<Integer> beeperInventoryHistory;
    private int stepIndex = 0;


    public KarelVisualizer(List<int[]> movementHistory, List<boolean[][]> beeperHistory, List<Integer> beeperInventoryHistory) {
        this.movementHistory = movementHistory;
        this.beeperHistory = beeperHistory;
        this.beeperInventoryHistory = beeperInventoryHistory;
        setPreferredSize(new Dimension(
                GRID_SIZE * CELL_SIZE + LEFT_PADDING + RIGHT_PADDING,
                GRID_SIZE * CELL_SIZE + TOP_PADDING + BOTTOM_PADDING
        ));
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

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);

        for (int i = 0; i < GRID_SIZE; i++) {
            int xPos = LEFT_PADDING + i * CELL_SIZE;
            int yPos = TOP_PADDING + i * CELL_SIZE;

            // Vertical lines (extend top to bottom with padding)
            g.drawLine(
                    xPos,
                    TOP_PADDING - CELL_SIZE / 2,
                    xPos,
                    TOP_PADDING + (GRID_SIZE - 1) * CELL_SIZE + CELL_SIZE / 2
            );

            // Horizontal lines (extend left to right with padding)
            g.drawLine(
                    LEFT_PADDING - CELL_SIZE / 2,
                    yPos,
                    LEFT_PADDING + (GRID_SIZE - 1) * CELL_SIZE + CELL_SIZE / 2,
                    yPos
            );

            // Row labels (left, vertically aligned with grid lines)
            int gridY = GRID_SIZE - 1 - i;
            int labelY = TOP_PADDING + i * CELL_SIZE + 5;  // Slight adjustment to align
            g.drawString(String.valueOf(gridY), LEFT_PADDING - CELL_SIZE / 2 - 12, labelY);
        }

        // Bottom column labels (closer to axis line)
        for (int i = 0; i < GRID_SIZE; i++) {
            int xPos = LEFT_PADDING + i * CELL_SIZE;
            int labelY = TOP_PADDING + GRID_SIZE * CELL_SIZE - 3;  // 🔻 moved up to nearly touch the line
            g.drawString(String.valueOf(i), xPos - 4, labelY);
        }

        // Draw beepers
        boolean[][] currentBeepers = beeperHistory.get(stepIndex);
        if (beeperImage != null) {
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (currentBeepers[i][j]) {
                        int bx = LEFT_PADDING + i * CELL_SIZE - BEEPER_SIZE / 2;
                        int by = TOP_PADDING + (GRID_SIZE - 1 - j) * CELL_SIZE - BEEPER_SIZE / 2;
                        g.drawImage(beeperImage, bx, by, BEEPER_SIZE, BEEPER_SIZE, this);
                    }
                }
            }
        }

        // Beeper inventory label
        g.setColor(Color.YELLOW);
        g.drawString("Beeper Inventory: " + beeperInventoryHistory.get(stepIndex), 10, 20);

        // Draw robot
        BufferedImage robotImage = switch (direction) {
            case 0 -> northImage;
            case 1 -> eastImage;
            case 2 -> southImage;
            case 3 -> westImage;
            default -> northImage;
        };

        if (robotImage != null) {
            int drawX = LEFT_PADDING + x * CELL_SIZE - CELL_SIZE / 2;
            int drawY = TOP_PADDING + (GRID_SIZE - 1 - y) * CELL_SIZE - CELL_SIZE / 2;
            g.drawImage(robotImage, drawX, drawY, CELL_SIZE, CELL_SIZE, this);
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
