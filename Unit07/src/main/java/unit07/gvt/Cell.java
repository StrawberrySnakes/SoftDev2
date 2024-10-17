// Dessa Shapiro
package unit07.gvt;


public class Cell {
	public int x;
	public int y;
    public boolean troll;

    /**
     * 
     * @param x
     * @param y
     * @param troll
     */
	public Cell(int x, int y, boolean troll) {
		this.x = x;
		this.y = y;
		this.troll = false;
    }

    public boolean isTroll() {
	    return this.troll;
    }

    @Override
    public String toString() {
        return this.x + "" + this.y;
    }

    
}
