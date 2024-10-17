// Dessa Shapiro
package unit08.PacMania;

import java.util.ArrayList;
import java.util.List;

import unit08.weighted.WAdjacencyGraph;

public class PacManMaze extends WAdjacencyGraph<Cell> {
    
    private Cell pacMan;
    private List<Cell> powerPellets;

    public PacManMaze() {
        powerPellets = new ArrayList<>();
    }

    @Override
    /**
     * @param cell
     */
    public void add(Cell cell) {
        super.add(cell);
        if (cell.getType() == CellType.PM) {
            pacMan = cell;
        } else if (cell.getType() == CellType.PP) {
            powerPellets.add(cell);
        }
    }

    public Cell getPacMan() {
        return pacMan;
    }

    public List<Cell> getPowerPellets() {
        return powerPellets;
    }

}
