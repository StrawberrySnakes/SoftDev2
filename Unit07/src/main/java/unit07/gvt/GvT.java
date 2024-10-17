// Dessa Shapiro
package unit07.gvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GvT {
    private Cell[][] cells;
    private Set<Cell> trollCells;
    private AdjacencyGraph<Cell> graph;

    /**
     * 
     * @param filename
     */
    public GvT(String filename) {
        try (FileReader fr = new FileReader(filename);
             BufferedReader reader = new BufferedReader(fr)) {
            int rows = Integer.parseInt(reader.readLine());
            int cols = Integer.parseInt(reader.readLine());
            this.cells = new Cell[rows][cols];
            this.trollCells = new HashSet<>();

            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int col = 0; col < cols; col++) {
                    char ch = tokens[col].charAt(0);
                    if (ch == 'T') {
                        cells[row][col] = new Cell(row, col, true);
                        trollCells.add(cells[row][col]);
                    } else {
                        cells[row][col] = new Cell(row, col, false);
                    }
                    // Add cell to the graph
                    graph.add(cells[row][col]);
                    // Connect to the left cell if not at the left edge
                    if (col > 0) {
                        graph.connectUndirected(cells[row][col - 1], cells[row][col]);
                    }
                    // Connect to the cell above if not at the top row
                    if (row > 0) {
                        graph.connectUndirected(cells[row - 1][col], cells[row][col]);
                    }
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return
     */
    public List<Cell> dfPathMage() {
        int rows = cells.length;
        int cols = cells[0].length;
        AdjacencyGraph<Cell> graph = new AdjacencyGraph<>();

        // Fill graph with vertices = cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                graph.add(cells[i][j]);
            }
        }

        // Connect adjacent cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell currentCell = cells[i][j];
                if (!currentCell.isTroll()) {
                    if (i > 0) { // Connect to the cell above
                        graph.connectUndirected(currentCell, cells[i - 1][j]);
                    }
                    if (i < rows - 1) { // Connect to the cell below
                        graph.connectUndirected(currentCell, cells[i + 1][j]);
                    }
                    if (j > 0) { // Connect to the cell on the left
                        graph.connectUndirected(currentCell, cells[i][j - 1]);
                    }
                    if (j < cols - 1) { // Connect to the cell on the right
                        graph.connectUndirected(currentCell, cells[i][j + 1]);
                    }
                }
            }
        }

        // Find path
        List<Cell> path = graph.dfPath(cells[0][0], cells[rows - 1][cols - 1]);
        return path;
    }

    public List<Cell> dfPathFighter() {
        int rows = cells.length;
        int cols = cells[0].length;
        AdjacencyGraph<Cell> graph = new AdjacencyGraph<>();

        // Populate with vertices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                graph.add(cells[i][j]);
            }
        }

        // Connect adjacent cells, avoiding trolls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell currentCell = cells[i][j];
                if (!currentCell.isTroll()) {
                    if (i > 0 && !cells[i - 1][j].isTroll()) { // Connect above if empty
                        graph.connectUndirected(currentCell, cells[i - 1][j]);
                    }
                    if (i < rows - 1 && !cells[i + 1][j].isTroll()) { // Connect below if empty
                        graph.connectUndirected(currentCell, cells[i + 1][j]);
                    }
                    if (j > 0 && !cells[i][j - 1].isTroll()) { // Connect left if empty
                        graph.connectUndirected(currentCell, cells[i][j - 1]);
                    }
                    if (j < cols - 1 && !cells[i][j + 1].isTroll()) { // Connect right if empty
                        graph.connectUndirected(currentCell, cells[i][j + 1]);
                    }
                }
            }
        }

        List<Cell> path = graph.dfPath(cells[0][0], cells[rows - 1][cols - 1]);
        return path;
    }

    public static void main(String[] args) {
        GvT gvT = new GvT("data/dfs/graph1_fighter.txt");
        List<Cell> path = gvT.dfPathMage();
        if (path != null) {
            System.out.println("Path found:");
            for (Cell cell : path) {
                System.out.println(cell);
            }
        } else {
            System.out.println("No path found.");
        }
    }
}