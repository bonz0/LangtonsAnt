package grid;

import javax.swing.*;
import java.awt.*;

/**
 * The canvas of the Grid
 *
 * @author bonz0
 */
public class Canvas {
    
    private final JFrame window;
    private final Frame canvas;

    public Canvas(int numRows, int numColumns) {
        this.canvas = new Frame(numRows, numColumns);
        this.window = new JFrame();
        this.window.setBackground(Color.WHITE);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setBounds(100, 100, 1000, 1000);
        this.window.getContentPane().add(canvas);
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
    }
    
    public void color(int row, int column, Color color) {
        canvas.color(this.window.getGraphics(), row, column, color);
    }
}
