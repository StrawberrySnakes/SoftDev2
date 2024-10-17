package unit03;
// Dessa Shapiro

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit03.practicum.Pokemon;
import unit03.practicum.Types;

public class PokemonTest {
    @Test
    public void testConstructor() {
        // setup
        Pokemon pokemon = new Pokemon("Todd", Types.GRASS);
        String expected = "Todd";
        Types expected2 = Types.GRASS;
        int expected3 = 1;

        String actual = pokemon.getName();
        Types actual2 = pokemon.getType();
        int actual3 = pokemon.getLevel();

        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

    }

    @Test
    public void testToString() {
        // setup
        Pokemon pokemon = new Pokemon("Todd", Types.GRASS);
        String expected = "{name = Todd, type = GRASS, level = 1";

        String actual = pokemon.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testLevelUp() {
        // setup
        Pokemon pokemon = new Pokemon("Todd", Types.GRASS, 100);
        pokemon.levelUp();
        int expected = 100;

        int actual = pokemon.getLevel();

        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        // setup
        Pokemon pokemon1 = new Pokemon("Todd", Types.GRASS);
        Pokemon pokemon2 = new Pokemon("Bob", Types.GRASS);
        Pokemon pokemon3 = new Pokemon("Sally", Types.GRASS, 12);
        Pokemon pokemon4 = new Pokemon("Jim", Types.GRASS, 1);
        Pokemon pokemon5 = new Pokemon("Bob", Types.WATER, 1);


        assertTrue(pokemon1.equals(pokemon2));
        assertFalse(pokemon1.equals(pokemon3));
        assertFalse(pokemon2.equals(pokemon3));
        assertTrue(pokemon1.equals(pokemon4));
        assertFalse(pokemon4.equals(pokemon5));



    }


}

