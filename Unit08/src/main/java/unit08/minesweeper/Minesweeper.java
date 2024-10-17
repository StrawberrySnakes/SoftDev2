// Dessa Shapiro
package unit08.minesweeper;

import unit08.backtracker.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Minesweeper implements Configuration<Minesweeper> {
    private char[][] board;
    private boolean[][] uncovered;
    private boolean[][] flagged;
    private int rows;
    private int cols;
    private int startRow;
    private int startCol;
    private int moveCount; 


    // Constructor 
    /**
     * 
     * @param filename
     * @param startRow
     * @param startCol
     * @throws IOException
     */
    public Minesweeper(String filename, int startRow, int startCol) throws IOException {
        this.startRow = startRow;
        this.startCol = startCol;
        this.moveCount = 1;

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] dimensions = reader.readLine().split(" ");
        this.rows = Integer.parseInt(dimensions[0]);
        this.cols = Integer.parseInt(dimensions[1]);

        this.board = new char[rows][cols];
        this.uncovered = new boolean[rows][cols];
        this.flagged = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = reader.readLine();
            for (int j = 0; j < cols; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        reader.close();
    }

    // Copy constructor
    /**
     * 
     * @param other
     */
    public Minesweeper(Minesweeper other) {
        this.rows = other.rows;
        this.cols = other.cols;
        this.startRow = other.startRow;
        this.startCol = other.startCol;
        this.moveCount = other.moveCount;

        this.board = new char[rows][cols];
        this.uncovered = new boolean[rows][cols];
        this.flagged = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(other.board[i], 0, this.board[i], 0, cols);
            System.arraycopy(other.uncovered[i], 0, this.uncovered[i], 0, cols);
            System.arraycopy(other.flagged[i], 0, this.flagged[i], 0, cols);
        }
    }

    @Override
    public Collection<Minesweeper> getSuccessors() {
        Collection<Minesweeper> successors = new ArrayList<>();
        // Generate successors by uncovering or flagging a tile
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = startRow + i;
                int newCol = startCol + j;
                if (isValidPosition(newRow, newCol)) {
                    Minesweeper successor = new Minesweeper(this);
                    if (!successor.uncovered[newRow][newCol] && !successor.flagged[newRow][newCol]) {
                        successor.uncovered[newRow][newCol] = true;
                        successor.moveCount++;
                    }
                    successors.add(successor);
                }
            }
        }
        return successors;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    

    @Override
    public boolean isValid() {
        return true; 
    }

    @Override
    public boolean isGoal() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uncovered[i][j]) {
                    builder.append(board[i][j]);
                } else if (flagged[i][j]) {
                    builder.append("F");
                } else {
                    builder.append("-");
                }
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    
}


