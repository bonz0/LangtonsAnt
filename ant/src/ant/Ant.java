package ant;

import grid.Grid;

import java.awt.*;

/**
 * Langton's Ant that runs on a Grid
 *
 * @author bonz0
 */
public class Ant {
    
    /**
     * Defines the current direction the ant is facing
     */
    private Direction direction;
    
    /**
     * Defines the ant's current location on the grid
     */
    private Grid.Point location;
    
    public Ant(Grid.Point location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }
    
    public Ant(Grid.Point location) {
        this(location, Direction.UP);
    }
    
    /**
     * The ant's movement is a three step process:
     * 1. Turn; based on the color of the cell at the current location
     * 2. Step forward one cell
     * 3. Toggle the color of the previous cell
     */
    public void move(Grid grid) {
        Grid.Point previousLocation = new Grid.Point(location);
        turn(grid);
        stepFoward(grid);
        grid.toggle(previousLocation);
        colorCurrentGridLocation(grid);
    }

    /**
     * Colors the current location of the ant RED
     */
    private void colorCurrentGridLocation(Grid grid) {
        grid.color(location, Color.RED);
    }
    
    /**
     * Changes the location of the ant based on
     * the direction it is currently facing
     */
    private void stepFoward(Grid grid) {
        switch (direction) {
            case UP:
                location.row--;
                break;
            case RIGHT:
                location.column++;
                break;
            case DOWN:
                location.row++;
                break;
            case LEFT:
                location.column--;
                break;
        }

        if (!grid.isValid(location)) {
            System.out.println("ERROR: Ant tried to go out of bounds of the grid!");
            System.exit(1);
        }
    } 
    
    /**
     * Rules of turning:
     * - If the cell at the current location is white, turn right
     * - If the cell at the current location is black, turn left
     */
    private void turn(Grid grid) {
        boolean isWhite = grid.isWhite(location);
        this.direction = (isWhite) ? direction.right() : direction.left();
    }
    
    /**
     * Enumeration that defines which direction the Ant is facing
     *
     * @author bonz0
     */
    public enum Direction {
        UP (0),
        RIGHT (1),
        DOWN (2),
        LEFT (3);
        
        private final int value;
        
        Direction(int value) {
            this.value = value;
        }

        public Direction right() {
            int newValue = (value == LEFT.value) ? UP.value : value + 1;
            return fromInteger(newValue);
        }
        
        public Direction left() {
            int newValue = (value == UP.value) ? LEFT.value : value - 1;
            return fromInteger(newValue);
        }
        
        private static Direction fromInteger(int newValue) {
            switch (newValue) {
                case 0:
                    return UP;
                case 1:
                    return RIGHT;
                case 2:
                    return DOWN;
                case 3:
                    return LEFT;
            }
            return null;
        }
    }
}
