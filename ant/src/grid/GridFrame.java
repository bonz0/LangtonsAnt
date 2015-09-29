package grid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by farhangz on 9/17/15.
 */
public class GridFrame {
    
    private final JFrame window;
    private final GridCanvas canvas;
    
    public GridFrame(int numRows, int numColumns) {
        this.canvas = new GridCanvas(numRows, numColumns);
        this.window = new JFrame();
        this.window.setBackground(Color.WHITE);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setBounds(200, 200, 700, 700);
        this.window.getContentPane().add(canvas);
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
        try { Thread.sleep(1000); } catch (Exception e) {}
        color(0, 0);
        try { Thread.sleep(1000); } catch (Exception e) {}
        color(1, 1);
        try { Thread.sleep(1000); } catch (Exception e) { System.out.println("wt"); }   
        color(2, 2);
        try { Thread.sleep(1000); } catch (Exception e) {}
        color(3, 3);
        
        try { Thread.sleep(1000); } catch (Exception e) {}
        unColor(0, 0);
        try { Thread.sleep(1000); } catch (Exception e) {}
        unColor(1, 1);
        try { Thread.sleep(1000); } catch (Exception e) { System.out.println("wt"); }   
        unColor(2, 2);
        try { Thread.sleep(1000); } catch (Exception e) {}
        unColor(3, 3);
    }
    
    public void color(int row, int column) {
        this.canvas.color(this.window.getGraphics(), row, column, true);
    }
    
    public void unColor(int row, int column) {
        this.canvas.color(this.window.getGraphics(), row, column, false);
    }
}
