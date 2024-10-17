// Dessa Shapiro
package unit01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SieveValidatorTest {
    @Test
    public void testRepairSieveOne() {
        // setup
        int[] sieve = {0, 1, 0, 0};
        int expected = 1;

        // invoke
        int actual = SieveValidator.repairSieve(sieve);

        // analyze
        assertEquals(expected, actual);
        
    }

    @Test
    public void testRepairSieveZero() {
        // setup
        int[] sieve = {1, 1, 0, 0, 1};
        int expected = 0;

        // invoke
        int actual = SieveValidator.repairSieve(sieve);

        // analyze
        assertEquals(expected, actual);
        
    }

    @Test
    public void testRepairSieveAll() {
        // setup
        int[] sieve = {0, 0, 1, 1, 0};
        int expected = 5;

        // invoke
        int actual = SieveValidator.repairSieve(sieve);

        // analyze
        assertEquals(expected, actual);
        
    }

    
}
