import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class KarelVisualizer extends JPanel {
    private int x = 0, y = 0;  // ✅ Start at (0,0) (bottom-left)
    private int direction = 0; // 0 = North, 1 = East, 2 = South, 3 = West
    private static final int CELL_SIZE = 50;
    private static final int GRID_SIZE = 10; // Grid is 10x10

    private BufferedImage northImage, southImage, eastImage, westImage;

    public KarelVisualizer() {
        setPreferredSize(new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE));
        loadImages();
    }

    // Load robot images from the "photos" folder
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

    // Update robot position and direction
    public void updatePosition(int newX, int newY, int newDirection) {
        this.x = newX;
        this.y = newY;
        this.direction = newDirection;
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

        // Choose the correct robot image based on direction
        BufferedImage robotImage = switch (direction) {
            case 0 -> northImage;
            case 1 -> eastImage;
            case 2 -> southImage;
            case 3 -> westImage;
            default -> northImage;
        };

        // Draw robot image at (x, y), flipping the Y-axis to match bottom-left start
        if (robotImage != null) {
            g.drawImage(robotImage, x * CELL_SIZE + 5, (GRID_SIZE - 1 - y) * CELL_SIZE + 5, CELL_SIZE - 10, CELL_SIZE - 10, this);
        } else {
            // If the image fails to load, draw a fallback red circle
            g.setColor(Color.RED);
            g.fillOval(x * CELL_SIZE + 10, (GRID_SIZE - 1 - y) * CELL_SIZE + 10, CELL_SIZE - 20, CELL_SIZE - 20);
        }
    }

    public static void createAndShowGUI(KarelVisualizer visualizer) {
        JFrame frame = new JFrame("Karel Robot Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(visualizer);
        frame.pack();
        frame.setVisible(true);
    }
}
