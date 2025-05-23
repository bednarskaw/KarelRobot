package lang.karel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Set;

public class KarelVisualizer extends JPanel {
    private int x = 0, y = 0;
    private int direction = 0;
    private int beeperCount = 0;

    private static final int CELL_SIZE = 50;
    private static final int BEEPER_SIZE = 30;
    private static final int LEFT_PADDING = 60;
    private static final int TOP_PADDING = 60;
    private static final int RIGHT_PADDING = 0;
    private static final int BOTTOM_PADDING = 10;

    private BufferedImage northImage, southImage, eastImage, westImage, beeperImage;
    private ImageIcon beeperIcon;
    private final List<int[]> movementHistory;
    private final List<boolean[][]> beeperHistory;
    private final List<Integer> beeperInventoryHistory;
    private final Set<List<Integer>> wallSet;
    private int stepIndex = 0;

    private final int gridWidth;
    private final int gridHeight;

    // Constructor with dynamic grid dimensions
    public KarelVisualizer(List<int[]> movementHistory, List<boolean[][]> beeperHistory,
                           List<Integer> beeperInventoryHistory, int gridWidth, int gridHeight, Set<List<Integer>> wallSet) {
        this.movementHistory = movementHistory;
        this.beeperHistory = beeperHistory;
        this.beeperInventoryHistory = beeperInventoryHistory;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.wallSet = wallSet;

        setPreferredSize(new Dimension(
                gridWidth * CELL_SIZE + LEFT_PADDING + RIGHT_PADDING,
                gridHeight * CELL_SIZE + TOP_PADDING + BOTTOM_PADDING
        ));
        loadImages();
        if (!movementHistory.isEmpty()) {
            int[] state = movementHistory.get(0);
            x = state[0];
            y = state[1];
            direction = state[2];
        }
    }

    private void loadImages() {
        try {
            northImage = ImageIO.read(new File("photos/north.png"));
            southImage = ImageIO.read(new File("photos/south.png"));
            eastImage = ImageIO.read(new File("photos/east.png"));
            westImage = ImageIO.read(new File("photos/west.png"));
            //beeperImage = ImageIO.read(new File("photos/beeper.png"));
            beeperIcon = new ImageIcon("photos/beep.gif");
            Image scaled = beeperIcon.getImage().getScaledInstance(BEEPER_SIZE, BEEPER_SIZE, Image.SCALE_DEFAULT);
            beeperIcon = new ImageIcon(scaled);
        } catch (Exception e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    }

    public void moveForward() {
        if (stepIndex < movementHistory.size() - 1) {
            stepIndex++;
            updateRobotPosition();
        }
    }

    public void moveBackward() {
        if (stepIndex > 0) {
            stepIndex--;
            updateRobotPosition();
        }
    }

    public void moveToStart() {
        stepIndex = 0;
        updateRobotPosition();
    }

    public void moveToFinal() {
        stepIndex = movementHistory.size() - 1;
        updateRobotPosition();
    }

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

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);

        // Draw vertical lines
        for (int i = 0; i < gridWidth; i++) {
            int xPos = LEFT_PADDING + i * CELL_SIZE;
            int yStart = TOP_PADDING - CELL_SIZE / 2;
            int yEnd = TOP_PADDING + (gridHeight - 1) * CELL_SIZE + CELL_SIZE / 2;

            g.drawLine(xPos, yStart, xPos, yEnd);
        }

        // Draw horizontal lines
        for (int i = 0; i < gridHeight; i++) {
            int yPos = TOP_PADDING + i * CELL_SIZE;
            int xStart = LEFT_PADDING - CELL_SIZE / 2;
            int xEnd = LEFT_PADDING + (gridWidth - 1) * CELL_SIZE + CELL_SIZE / 2;

            g.drawLine(xStart, yPos, xEnd, yPos);
        }

        // Row labels (left side)
        for (int i = 0; i < gridHeight; i++) {
            int gridY = gridHeight - 1 - i;
            int labelY = TOP_PADDING + i * CELL_SIZE + 5;
            g.drawString(String.valueOf(gridY), LEFT_PADDING - CELL_SIZE / 2 - 12, labelY);
        }

        // Column labels (bottom)
        for (int i = 0; i < gridWidth; i++) {
            int xPos = LEFT_PADDING + i * CELL_SIZE;
            int labelY = TOP_PADDING + gridHeight * CELL_SIZE - 3;
            g.drawString(String.valueOf(i), xPos - 4, labelY);
        }

        // Draw beepers
        boolean[][] currentBeepers = beeperHistory.get(stepIndex);
        if (beeperIcon != null) {
            for (int i = 0; i < gridWidth; i++) {
                for (int j = 0; j < gridHeight; j++) {
                    if (currentBeepers[i][j]) {
                        int bx = LEFT_PADDING + i * CELL_SIZE - BEEPER_SIZE / 2;
                        int by = TOP_PADDING + (gridHeight - 1 - j) * CELL_SIZE - BEEPER_SIZE / 2;
                        beeperIcon.paintIcon(this, g, bx, by);
                    }
                }
            }
        }

        // Beeper inventory label
        g.setColor(Color.YELLOW);
        g.drawString("Beeper Inventory: " + beeperInventoryHistory.get(stepIndex), 10, 20);

        // 🔲 Draw walls
        g.setColor(Color.RED);
        for (List<Integer> wall : wallSet) {
            int x1 = wall.get(0);
            int y1 = wall.get(1);
            int x2 = wall.get(2);
            int y2 = wall.get(3);

            // Oblicz współrzędne pikselowe środka komórek
            int cx1 = LEFT_PADDING + x1 * CELL_SIZE;
            int cy1 = TOP_PADDING + (gridHeight - 1 - y1) * CELL_SIZE;
            int cx2 = LEFT_PADDING + x2 * CELL_SIZE;
            int cy2 = TOP_PADDING + (gridHeight - 1 - y2) * CELL_SIZE;

            // Ściana pionowa (np. między (0,0) a (1,0))
            if (x1 != x2) {
                int x = (cx1 + cx2) / 2;
                g.drawLine(x, cy1 - CELL_SIZE / 2, x, cy1 + CELL_SIZE / 2);
            }
            // Ściana pozioma (np. między (0,0) a (0,1))
            else if (y1 != y2) {
                int y = (cy1 + cy2) / 2;
                g.drawLine(cx1 - CELL_SIZE / 2, y, cx1 + CELL_SIZE / 2, y);
            }
        }




        // Draw robot
        BufferedImage robotImage = switch (direction) {
            case 0 -> northImage;
            case 90 -> eastImage;
            case 180 -> southImage;
            case 270 -> westImage;
            default -> northImage;
        };

        if (robotImage != null) {
            int drawX = LEFT_PADDING + x * CELL_SIZE - CELL_SIZE / 2;
            int drawY = TOP_PADDING + (gridHeight - 1 - y) * CELL_SIZE - CELL_SIZE / 2;
            g.drawImage(robotImage, drawX, drawY, CELL_SIZE, CELL_SIZE, this);
        }
    }


    public static void createAndShowGUI(KarelVisualizer visualizer) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Karel Robot Visualization");
            final Point[] mouseDownCompCoords = { null };
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setUndecorated(true);
            JPanel titleBar = new JPanel(new BorderLayout());
            titleBar.setBackground(Color.BLACK);
            titleBar.setPreferredSize(new Dimension(600, 30)); // wysokość paska tytułu
            titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent e) {
                    mouseDownCompCoords[0] = e.getPoint();
                }

                public void mouseReleased(java.awt.event.MouseEvent e) {
                    mouseDownCompCoords[0] = null;
                }
            });

            titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseDragged(java.awt.event.MouseEvent e) {
                    Point currCoords = e.getLocationOnScreen();
                    frame.setLocation(currCoords.x - mouseDownCompCoords[0].x, currCoords.y - mouseDownCompCoords[0].y);
                }
            });
            JLabel titleLabel = new JLabel("  Karel Robot Visualization");
            titleLabel.setForeground(Color.WHITE);

            // 🔹 Przycisk zamykania
            JButton closeButton = new JButton("❌");
            closeButton.setFocusPainted(false);
            closeButton.setBorderPainted(false);
            closeButton.setBackground(Color.BLACK);
            closeButton.setForeground(Color.WHITE);
            closeButton.addActionListener(e -> System.exit(0));

            titleBar.add(titleLabel, BorderLayout.WEST);
            titleBar.add(closeButton, BorderLayout.EAST);

            frame.add(titleBar, BorderLayout.NORTH);
            frame.add(visualizer, BorderLayout.CENTER);

            frame.add(visualizer, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.BLACK);
            JButton toStartButton = createNavButton("⏮");
            JButton backwardButton = createNavButton("⬅");
            JButton forwardButton = createNavButton("➡");
            JButton toFinalButton = createNavButton("⏭");


            toStartButton.addActionListener(e -> visualizer.moveToStart());
            backwardButton.addActionListener(e -> visualizer.moveBackward());
            forwardButton.addActionListener(e -> visualizer.moveForward());
            toFinalButton.addActionListener(e -> visualizer.moveToFinal());

            buttonPanel.add(toStartButton);
            buttonPanel.add(backwardButton);
            buttonPanel.add(forwardButton);
            buttonPanel.add(toFinalButton);

            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.pack();
            frame.setVisible(true);
        });
    }
    private static JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);
        button.setBackground(new Color(60, 60, 60));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(60, 40));
        return button;
    }

}
