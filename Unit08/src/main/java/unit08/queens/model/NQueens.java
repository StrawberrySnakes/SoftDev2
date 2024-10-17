package unit08.queens.model;

import unit08.backtracker.*;

import java.util.*;
/**
 * NQueens
 */
public class NQueens implements Configuration<NQueens> {

    private final Queen[] queens;
    private final int n;

    public NQueens(int n) {
        this(n, new Queen[0]);
    }

    public NQueens(int n, Queen[] queens) {
        this.n= n;
        this.queens = queens != null ? queens : new Queen[0];
    }

    public Queen[] getQueens() {
        return this.queens;
    }

    @Override
    public Collection<NQueens> getSuccessors() {
        List<NQueens> successors = new ArrayList<>();
        int length = this.queens.length;
        int row = length > 0 ? queens[length-1].getRow() + 1 : 0;
        if (row>1) {
            for(int col = 0; col < n; col++) {
                Queen[] copy = Arrays.copyOf(queens, length+1);
                copy[length] = new Queen(row, col);
                successors.add(new NQueens(n, copy));

            }
        }
 
        return successors;
    }

    @Override
    public boolean isValid() {
        int length= this.queens.length;
        if (length < 2) {
            return true;
        } else {
            Queen last = this.queens[length-1];
            for (int i = 0; i < length -1; i++) {
                if(last.canAttack(this.queens[1])) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public boolean isGoal() {
        return this.isValid() && this.queens.length == this.n;
    }

    @Override
    public String toString() {
        String[][] board = new String[n][n];
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                board[row][col] = "[ ]";
            }
        }

        for(Queen q : queens) {
            board[q.getRow()][q.getCol()] = "[Q]";
        }

        StringBuilder builder = new StringBuilder();
        for(String[] row : board) {
            for(String col : row) {
                builder.append(col);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens(8);
        // System.out.println(nQueens);
        // Collection<NQueens> successors = nQueens.getSuccessors();
        // for (NQueens successor : successors) {
        //     System.out.println(successor);

        // }
        Backtracker<NQueens> backtracker= new Backtracker<>(false);
        NQueens solution = backtracker.solve(nQueens);
        if(solution == null) {
            System.out.println("Nope");
        } else {
            System.out.println(solution);
        }
    }

    
}