// Dessa Shapiro
// I'm Sorry I can't do the screenshot but my tests won't load at all 

package unit01;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class CollatzTest {
    @Test
    public void TestSequence0() {
        // setup
        int n = 0;
        String expected = "";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze
        assertEquals(expected, actual);

        
    }

    @Test
    public void TestSequence1() {
        // setup
        int n = 1;
        String expected = "1";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze
        assertEquals(expected, actual);

        
    }

    @Test
    public void TestSequence2() {
        // setup
        int n = 2;
        String expected = "2 1";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze
        assertEquals(expected, actual);

        
    }

    @Test
    public void TestSequence3() {
        // setup
        int n = 3;
        String expected = "3 10 5 16 8 4 2 1";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze
        assertEquals(expected, actual);

        
    }
    
}
