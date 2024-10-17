// Dessa Shapiro
package unit11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import unit11.ggg.*;

public class gggTest {
    
    @Test
    public void testColor() {
        assertEquals(Color.RED, Color.valueOf("RED"));
        assertEquals(Color.BLUE, Color.valueOf("BLUE"));
        assertEquals(Color.GREEN, Color.valueOf("GREEN"));
        assertEquals(Color.YELLOW, Color.valueOf("YELLOW"));

        // Additional test for the number of enum values
        assertEquals(4, Color.values().length);
    }

    @Test
    public void turnipDropperConstructor() { 
        Trough trough = new Trough(10);
        TurnipDropper dropper = new TurnipDropper(trough);
        assertEquals(trough, dropper.getTrough());
    }


    @Test 
    public void testGoat() {
        Trough trough = new Trough(10);
        Goat goat = new Goat(Color.RED, trough);

        assertEquals(Color.RED, goat.getColor());
        assertEquals(0, goat.getTurnipsEaten());
        assertEquals(trough, goat.getTrough());
        assertEquals("The RED goat.", goat.toString());
    }
}

