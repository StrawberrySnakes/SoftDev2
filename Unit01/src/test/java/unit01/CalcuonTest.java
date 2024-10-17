package unit01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalcuonTest {
    @Test
    public void testAdd() {
        // setup
        float x = 3f;
        float y = 4f;
        float expected = 7.0f;

        // invoke
        float actual = Calcuon.add(x, y);

        // analyze
        assertEquals(expected, actual);

    }

    @Test
    public void testSubtract() {
        // setup
        float x = 5f;
        float y = 2f;
        float expected = 3.0f;

        // involk
        float actual = Calcuon.subtract(x, y);

        // analyze
        assertEquals(expected, actual);

    }

    
}
