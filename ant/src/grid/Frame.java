package grid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by farhangz on 9/17/15.
 */
public class Frame extends JComponent {
    
    final static int RECTANGLE_SIZE = 5;
    final static int OFFSET = 100;
    
    private final int numRows;
    private final int numColumns;
    
    public Frame(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
    }
    
    @Override
    public void paint(Graphics g) {
        initializeGrid(g);
    }
    
    private void initializeGrid(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        final int endRows = OFFSET + numRows * RECTANGLE_SIZE;
        final int endColumns = OFFSET + numColumns * RECTANGLE_SIZE;
        System.out.println("endRows: " + endRows + ", endColumns: " + endColumns);
        for (int i = OFFSET; i < endRows; i += RECTANGLE_SIZE) {
            for (int j = OFFSET; j < endColumns; j += RECTANGLE_SIZE) {
                g2.drawRect(i, j, RECTANGLE_SIZE, RECTANGLE_SIZE);
            }
        }
        g2.finalize();
    }
    
    public void color(Graphics g, int row, int column, Color color) {
        Graphics2D g2 = (Graphics2D) g;
        Shape rect = getRectangle(row, column);
        g2.setColor(color);
        g2.fill(rect);
        g2.finalize();
    }
    
    private static Rectangle getRectangle(int row, int column) {
        int x = row * RECTANGLE_SIZE + OFFSET;
        int y = column * RECTANGLE_SIZE + OFFSET + 30;
        return new Rectangle(x + 2, y - 1, RECTANGLE_SIZE - 1, RECTANGLE_SIZE - 1);
    }
}
