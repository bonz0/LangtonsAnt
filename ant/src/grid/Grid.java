package grid;

import java.awt.*;

/**
 * The grid on which the ant moves
 *
 * @author bonz0
 */
public class Grid {
    
    private final boolean grid[][];
    private final int numRows;
    private final int numColumns;
    private final Canvas canvas;
    
    public Grid(int rows, int columns) {
        this.grid = new boolean[rows][columns];
        this.numRows = rows;
        this.numColumns = columns;
        this.canvas = new Canvas(rows, columns);
    }
    
    public Point getStartingPoint() {
        return new Point((numRows / 2) - 25, (numColumns / 2) + 25);
    }
    
    public void toggle(Point previousPoint) {
        boolean isWhite = isWhite(previousPoint);
        if (isWhite) {
            color(previousPoint, Color.BLACK);
        } else {
            color(previousPoint, Color.WHITE);
        }
        grid[previousPoint.row][previousPoint.column] = isWhite;
    }

    /**
     * Returns:
     * - true, if the point provided to it is not out of bounds of the grid.
     * - false, if the point provided to it is out of bounds of the grid.
     */
    public boolean isValid(Point p) {
        return (p.row >= 0 && p.row < numRows && p.column >= 0 && p.column < numColumns);
    }

    /**
     * Returns true if the point passed to it is white, else returns false
     */
    public boolean isWhite(Point point) {
        if (!isValid(point)) {
            System.out.println("ERROR: Ant tried to go out of bounds of the grid!");
            System.exit(1);
        }
        return !grid[point.row][point.column];
    }

    /**
     * Colors the input point on the grid with the input color
     */
    public void color(Point point, Color color) {
        canvas.color(point.row, point.column, color);
    }

    /**
     * Helper method to print the grid to STDOUT
     */
    public void printGrid() {
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                System.out.print((cell) ? "X" : "o");
            }
            System.out.println();
        }
    }
    
    /**
     * Defines a location on the grid
     *
     * @author bonz0
     */
    public static class Point {
        public int row;
        public int column;
        
        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
        
        public Point(Point p) {
            this.row = p.row;
            this.column = p.column;
        }
        
        @Override
        public String toString() {
            return "(" + row + ", " + column + ")";
        }
    }
}
