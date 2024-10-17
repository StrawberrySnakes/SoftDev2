package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import petespike.model.*;

public class PositionTest {
    @Test
    public void testPositionConstructor() {
        int row = 3;
        int col = 4;
        Position position = new Position(row, col);

        assertEquals(row, position.getRow());
        assertEquals(col, position.getCol());
    }

    @Test
    public void testEqualsAndHashCode() {
        Position position1 = new Position(3, 4);
        Position position2 = new Position(3, 4);
        Position position3 = new Position(5, 6);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
        assertNotEquals(position2, position3);

        // Check hash code consistency
        assertEquals(position1.hashCode(), position2.hashCode());
    }
    
}
