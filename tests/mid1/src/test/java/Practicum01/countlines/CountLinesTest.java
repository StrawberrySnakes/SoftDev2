package Practicum01.countlines;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CountLinesTest {
    @Test
    public void testStringContainsWord() {
        assertFalse(CountLines.stringContainsWord("I have a green bird.", "dog"));
        assertTrue(CountLines.stringContainsWord("I have a dog", "dog"));
        assertFalse(CountLines.stringContainsWord("I have a dog.", "dog"));
        assertTrue(CountLines.stringContainsWord("My dog is brown.", "dog"));
        assertTrue(CountLines.stringContainsWord("My dog is dog.", "dog"));
        assertTrue(CountLines.stringContainsWord("My DoG has a DOG friend.", "dog"));
    } 

    @Test
    public void testCountLines() {
        assertEquals(2, CountLines.countLines("data/alice.txt", "english"));
        assertEquals(-1, CountLines.countLines("data/nosuchfile.txt", "word"));
        assertEquals(0, CountLines.countLines("data/alice.txt", "nosuchword"));
        assertEquals(26, CountLines.countLines("data/alice.txt", "ELECTRONIC"),26);
        assertEquals(22, CountLines.countLines("data/alice.txt", "nothing"));
        assertEquals(727,CountLines.countLines("data/alice.txt", "and"));
    } 
    
}
