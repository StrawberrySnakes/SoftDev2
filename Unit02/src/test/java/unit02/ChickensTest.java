package unit02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit02.chickens.Chicken;
import unit02.chickens.Color;
import unit02.chickens.Egg;
import unit02.chickens.Size;


public class ChickensTest {
    @Test
    public void testEggConstructor() {
        // Setup
        Egg egg = new Egg(Color.BROWN, Size.LARGE, false);
        Color expected = Color.BROWN;
        Size expected2 = Size.LARGE;
        boolean expected3 = false;

        // invoke
        Color actual = egg.getColor();
        Size actual2 = egg.getSize();
        boolean actual3 = egg.getCracked();

        // analyze
        assertEquals(actual, expected);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);

    }

    @Test
    public void testEggConstructorDefult() {
        // Setup
        Egg egg = new Egg();
        Color expected = Color.WHITE;
        Size expected2 = Size.LARGE;
        boolean expected3 = false;

        // invoke
        Color actual = egg.getColor();
        Size actual2 = egg.getSize();
        boolean actual3 = egg.getCracked();

        // analyze
        assertEquals(actual, expected);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
    }



    @Test
    public void testEggToString() {
        // setup
        Egg egg = new Egg(Color.BROWN, Size.PEEWEE, false);
        String expected = "a uncracked PEEWEE(1.25oz) BROWN egg";

        // invoke
        String actual = egg.toString();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testEggEquals() {
        // setup
        Egg egg = new Egg(Color.BROWN, Size.MEDIUM, false);
        Egg egg1 = new Egg(Color.BROWN, Size.MEDIUM, true);
        Egg egg2 = new Egg(Color.BROWN, Size.PEEWEE, false);
        Egg egg3 = new Egg(Color.WHITE, Size.PEEWEE, false);
        
        // analyze
        assertFalse(egg.equals(egg1));
        assertTrue(egg1.equals(egg2));
        assertFalse(egg.equals(egg3));
    }

    @Test
    public void testChickenConstructor() {
        // Setup
        Chicken chicken = new Chicken("Todd", Color.BROWN, Size.JUMBO);
        String expected = "Todd";
        Color expected2 = Color.BROWN;
        Size expected3 = Size.JUMBO;
        

        // invoke
        String actual = chicken.getName();
        Color actual2 = chicken.getColor();
        Size actual3 = chicken.getSize();
        

        // analyze
        assertEquals(actual, expected);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);

    }

    @Test
    public void testChickenConstructorDefult() {
        // Setup
        Chicken chicken = new Chicken();
        String expected = "NoName";
        Color expected2 = Color.BROWN;
        Size expected3 = Size.LARGE;
        

        // invoke
        String actual = chicken.getName();
        Color actual2 = chicken.getColor();
        Size actual3 = chicken.getSize();
        

        // analyze
        assertEquals(actual, expected);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
    }



    @Test
    public void testChickenToString() {
        // setup
        Chicken chicken = new Chicken("Marry", Color.WHITE, Size.SMALL);
        String expected = "Marry, a chicken that lays SMALL WHITE eggs";

        // invoke
        String actual = chicken.toString();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testChickenEquals() {
        // setup
        Chicken chicken1 = new Chicken("Todd", Color.WHITE, Size.SMALL);
        Chicken chicken2 = new Chicken("Marry", Color.WHITE, Size.MEDIUM);
        Chicken chicken3 = new Chicken("Jerry", Color.WHITE, Size.SMALL);
        Chicken chicken4 = new Chicken("Marry", Color.WHITE, Size.PEEWEE);
        
        // analyze
        assertFalse(chicken1.equals(chicken2));
        assertTrue(chicken1.equals(chicken3));
        assertFalse(chicken2.equals(chicken4));
    }

    
}
