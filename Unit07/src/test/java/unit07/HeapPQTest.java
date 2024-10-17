package unit07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit07.practicum.HeapPQ;

public class HeapPQTest {

    @Test
    public void testHeapPQ() {
        HeapPQ heap = new HeapPQ();
        heap.enqueue(1);
        heap.enqueue(7);
        heap.enqueue(2);
        heap.enqueue(4);

        int expected1 = 1;
        int actual1 = heap.dequeue();

        int expected2 = 2;
        int actual2 = heap.dequeue();

        int expected3 = 4;
        int actual3 = heap.dequeue();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
    
}
