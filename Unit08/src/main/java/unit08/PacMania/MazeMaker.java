// Dessa Shapiro
package unit08.PacMania;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import unit08.weighted.WPath;

public class MazeMaker {

    /**
     * 
     * @param filename
     * @return
     * @throws IOException
     */
    public static PacManMaze readMaze(String filename) throws IOException {
        PacManMaze maze = new PacManMaze();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("-");
                CellType type = CellType.valueOf(parts[0]);
                int row = Integer.parseInt(parts[1]);
                int col = Integer.parseInt(parts[2]);
                Cell cell = new Cell(type, row, col);
                maze.add(cell);
            }
        }

        return maze;
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("Enter the name of a .maz file: ");
            String filename = consoleScanner.nextLine();
            PacManMaze maze = readMaze(filename);
            System.out.println("Maze loaded successfully!");
            
            Cell pacman = maze.getPacMan();
            for (Cell powerPellet : maze.getPowerPellets()) {
                WPath<Cell> path = maze.dijkstrasPath(pacman, powerPellet);
                if (path != null) {
                    System.out.println(path); // Print the path
                    pacman = powerPellet; // Update Pac-Man's location
                } else {
                    System.out.println("No path found to the power pellet at " + powerPellet);
                }
            }
            
            consoleScanner.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
