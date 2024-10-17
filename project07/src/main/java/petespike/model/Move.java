// Justin Doxsee
// Dessa Shapiro
package petespike.model;

public class Move {
    private Position position;
    private Direction direction;

    /**
     * 
     * @param position
     * @param direction
     */
    public Move(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {return this.position;}
    public Direction getDirection() {return this.direction;}

    @Override
    public String toString() {
        return this.position.getRow() + " " + this.position.getCol() + " " + this.direction;
    }

}
