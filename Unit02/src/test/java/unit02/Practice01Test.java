// Dessa Shapiro
package unit02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Practice01Test {
    @Test
    public void TestArrayToString() {
        // setup
        int[] anArray = {1, 0, 1};
        String expected = "[1, 0, 1]";

        // invoke
        String actual = Practice01.arrayToString(anArray);

        // analyze
        assertEquals(expected, actual);

    }

    @Test
    public void TestArrayToStringEmpty() {
        // setup
        int[] anArray = {};
        String expected = "[]";

        // invoke
        String actual = Practice01.arrayToString(anArray);

        // analyze
        assertEquals(expected, actual);

    }
    
}
