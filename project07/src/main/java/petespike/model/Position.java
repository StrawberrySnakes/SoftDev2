// Justin Doxsee
// Dessa Shapiro
package petespike.model;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row;}

    public int getCol() {return this.col;}

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position) {
            Position other = (Position)obj;
            return other.getCol() == this.getCol() && other.getRow() == this.getRow();
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(new Position(1, 1).equals(new Position(1, 1)));
        System.out.println(new Position(10, 1).equals(new Position(1, 1)));
        System.out.println(new Position(1, 1).equals(new Position(54, 1)));
    }
}

