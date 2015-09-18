package main;

import ant.Ant;
import grid.Grid;

/**
 * Main class for Langton's Ant
 *
 * @author bonz0
 */
public class Main {
    public static void main(String[] args) {
        final int gridSize = 80;
        final int numberOfIterations = 3000;
        int userIterations = 0;
        if (args.length == 1) {
            userIterations = Integer.parseInt(args[0]);
        }
        int iterations = (userIterations > 0) ? userIterations : numberOfIterations;
        Grid grid = new Grid(gridSize, gridSize);
        Grid.Point startingPoint = grid.getStartingPoint();
        Ant ant = new Ant(startingPoint);
        try {
            System.out.println("Starting point: " + startingPoint.toString());
            Thread.sleep(1000);
            System.out.println("Number of iterations: " + iterations);
            Thread.sleep(1000);
            System.out.print("Starting simulation.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
        } catch (Exception e) {
            
        }
        for (int i = 0; i < iterations; i++) {
            ant.move(grid, (i % 10 == 0));
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                System.err.println("Thread interrupted");
            }
        }
    }
}
