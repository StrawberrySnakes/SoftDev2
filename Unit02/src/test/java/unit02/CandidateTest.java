package unit02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit02.Election.Affiliation;
import unit02.Election.Candidate;
import unit02.Election.Positions;

public class CandidateTest {
    @Test
    public void testConstructor() {
        // Setup
        Candidate candidate = new Candidate("Bob Marley", Affiliation.REPUBLICAN, Positions.MAYOR);
        String expected = "Bob Marley";
        Affiliation expected2 = Affiliation.REPUBLICAN;
        Positions expected3 = Positions.MAYOR;

        // invoke
        String actual = candidate.getName();
        Affiliation actual2 = candidate.getAffiliation();
        Positions actual3 = candidate.getPositions();

        // analyze
        assertEquals(actual, expected);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
    }

    @Test
    public void testConstructorDefult() {
        // Setup
        Candidate candidate = new Candidate();
        String expected = "NoName";
        Affiliation expected2 = Affiliation.INDEPENDENT;
        Positions expected3 = Positions.ASSEMBLY_MEMBER;

        // invoke
        String actual = candidate.getName();
        Affiliation actual2 = candidate.getAffiliation();
        Positions actual3 = candidate.getPositions();

        // analyze
        assertEquals(actual, expected);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
    }



    @Test
    public void testToString() {
        // setup
        Candidate candidate = new Candidate("Harry Styles", Affiliation.DEMOCRAT, Positions.SHERIFF);
        String expected = "Candidate: {Name: Harry Styles, Affiliation: DEMOCRAT, Position: SHERIFF}";

        // invoke
        String actual = candidate.toString();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        // setup
        Candidate candidate1 = new Candidate("Mr Cheese", Affiliation.LIBERTARIAN, Positions.JUDGE);
        Candidate candidate2 = new Candidate("Mr Cheese", Affiliation.REPUBLICAN, Positions.JUDGE);
        Candidate candidate3 = new Candidate("King Bob", Affiliation.LIBERTARIAN, Positions.JUDGE);
        Candidate candidate4 = new Candidate("Mr Cheese", Affiliation.LIBERTARIAN, Positions.MAYOR);
        
        // analyze
        assertTrue(candidate1.equals(candidate2));
        assertFalse(candidate1.equals(candidate3));
        assertFalse(candidate1.equals(candidate4));
    }
    
}
