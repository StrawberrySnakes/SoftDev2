// Dessa Shapiro


package unit05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit05.mcf.LinkedList;

/**
 * tests linkedlist
 */

public class LinkedListTest {
    @Test
    void testAppendAndGet() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.append("One");
        ll.append("Two");
        ll.append("Three");

        assertEquals("One", ll.get(0));
        assertEquals("Two", ll.get(1));
        assertEquals("Three", ll.get(2));
    }

    @Test
    void testSet() {
        LinkedList<String> ll = new LinkedList<>();
        ll.append("One");
        ll.append("Two");
        ll.append("Three");

        ll.set(1, "NewTwo");
        assertEquals("NewTwo", ll.get(1));

        ll.set(2, "NewThree");
        assertEquals("NewThree", ll.get(2));
    }

    @Test
    void testSize() {
        LinkedList<String> ll = new LinkedList<>();
        assertEquals(0, ll.size());

        ll.append("One");
        ll.append("Two");
        assertEquals(2, ll.size());

        ll.append("Three");
        assertEquals(3, ll.size());
    }

    @Test
    void testEquals() {
        LinkedList<String> ll = new LinkedList<>();
        LinkedList<String> ll2 = new LinkedList<>();
        LinkedList<String> ll3 = new LinkedList<>();
        LinkedList<String> ll4 = new LinkedList<>();


        ll.append("one");
        ll2.append("one");
        ll3.append("two");
        ll4.append("one");
        ll4.append("two");

        assertTrue(ll.equals(ll2));
        assertFalse(ll.equals(ll3));
        assertFalse(ll2.equals(ll4));

    }

    
}
