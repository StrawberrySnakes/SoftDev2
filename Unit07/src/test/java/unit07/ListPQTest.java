package unit07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit07.practicum.ListPQ;

public class ListPQTest {

    @Test
    public void testHeapPQ() {
        ListPQ list = new ListPQ();
        list.enqueue(1);
        list.enqueue(7);
        list.enqueue(2);
        list.enqueue(4);

        int expected1 = 1;
        int actual1 = list.dequeue();

        int expected2 = 2;
        int actual2 = list.dequeue();

        int expected3 = 4;
        int actual3 = list.dequeue();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
    
}
