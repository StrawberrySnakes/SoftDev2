package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import petespike.model.*;

public class MoveTest {

    @Test
    public void testMoveConstructor() {
        Position position = new Position(3, 4);
        Direction direction = Direction.RIGHT;
        Move move = new Move(position, direction);

        assertEquals(position, move.getPosition());
        assertEquals(direction, move.getDirection());
    }

    @Test
    public void testMoveToString() {
        Position position = new Position(3, 4);
        Direction direction = Direction.RIGHT;
        Move move = new Move(position, direction);

        assertEquals("3 4 RIGHT", move.toString());
    }
}
    

