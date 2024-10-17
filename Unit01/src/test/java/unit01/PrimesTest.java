package unit01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimesTest {
    
    @Test
    public void TestisPrime2() {
        // setup
        int x = 2;
        boolean expected = true;

        // invoke
        boolean actual = Primes.isPrime(x);

        // analyze
        assertEquals(expected, actual);

        
    }

    @Test
    public void TestisPrime10() {
        // setup
        int x = 10;
        boolean expected = false;

        // invoke
        boolean actual = Primes.isPrime(x);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void TestisPrime0() {
        // setup
        int x = 0;
        boolean expected = false;

        // invoke
        boolean actual = Primes.isPrime(x);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void TestisPrimeNegative() {
        // setup
        int x = -10;
        boolean expected = false;

        // invoke
        boolean actual = Primes.isPrime(x);

        // analyze
        assertEquals(expected, actual);
    }
    
}
