// Dessa Shapiro
package unit08.PacMania;

import java.util.*;

public class Cell {
    private CellType type;
    private int row;
    private int col;

    /**
     * 
     * @param type
     * @param row
     * @param col
     */
    public Cell(CellType type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }

    public CellType getType() {
        return this.type;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    /**
     * @param obj
     */
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Cell)) return false;
        Cell cell = (Cell) obj;
        return this.row == cell.row && this.col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
