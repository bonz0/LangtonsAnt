package grid;

import ant.Ant;

import javax.swing.*;

/**
 * The grid on which the ant moves
 *
 * @author bonz0
 */
public class Grid {
    
    private final boolean grid[][];
    private final int numRows;
    private final int numColumns;
    
    public Grid(int rows, int columns) {
        this.grid = new boolean[rows][columns];
        this.numRows = rows;
        this.numColumns = columns;
    }
    
    public Point getStartingPoint() {
        return new Point((numRows / 2) - 10, (numColumns / 2) + 10);
    }
    
    public void toggle(Point point) {
        if (!isValid(point)) {
            System.out.println("ERROR");
            System.exit(1);
        }
        this.grid[point.row][point.column] = !this.grid[point.row][point.column];
    }
    
    private boolean isValid(Point p) {
        return (p.row >= 0 && p.row < this.numRows &&
                p.column >= 0 && p.column < this.numColumns);
    }
    
    public boolean isWhite(Point point) {
        if (!isValid(point)) {
            System.out.println("ERROR");
            System.exit(1);
        }
        return !grid[point.row][point.column];
    }
    
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
