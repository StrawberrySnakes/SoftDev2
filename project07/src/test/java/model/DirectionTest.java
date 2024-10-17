package model;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import petespike.model.Direction;

public class DirectionTest {
    @Test
    public void testEnumValues() {
        Direction[] directions = Direction.values();
        assertEquals(4, directions.length);
        assertArrayEquals(new Direction[]{Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT}, directions);
    }

    @Test
    public void testDirectionConstants() {
        assertEquals(Direction.UP, Direction.valueOf("UP"));
        assertEquals(Direction.DOWN, Direction.valueOf("DOWN"));
        assertEquals(Direction.LEFT, Direction.valueOf("LEFT"));
        assertEquals(Direction.RIGHT, Direction.valueOf("RIGHT"));
    }
}
    
