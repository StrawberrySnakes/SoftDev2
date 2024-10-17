package Practicum01.polygon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PolygonTest {

    @Test
    public void testConstuctorHentegon() {
        // setup
        Polygon hex = new Hexagon("hex1", 4);
        String expected1 = "hex1";
        int expected2 = 6;
        int expected3 = 4;

        String actual1 = hex.getName();
        int actual2 =  hex.getNumSides();
        int actual3 = hex.getSideLength();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    public void testConstuctorPentagon() {
        // setup
        Polygon pen = new Pentagon("Pen1", 2);
        String expected1 = "Pen1";
        int expected2 = 5;
        int expected3 = 2;

        String actual1 = pen.getName();
        int actual2 =  pen.getNumSides();
        int actual3 = pen.getSideLength();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    public void testPentegonArea() {
        Polygon pen = new Pentagon("Pen1", 2);
        double expected = 20/2.906;

        double actual = pen.area();

        assertEquals(expected, actual, 0.5);

    }

    @Test
    public void testHexagonArea() {
        Polygon hex = new Hexagon("Hex1", 2);
        double expected = 4*2.598;

        double actual = hex.area();

        assertEquals(expected, actual, 0.5);

    }

}
