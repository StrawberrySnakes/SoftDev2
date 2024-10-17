package unit07.practicum;

import java.util.Comparator;

public class HeapPQ implements Queue<Integer>, Comparator<Integer> {
    private int size;
    private ArrayHeap heap;


    public HeapPQ() {
        this.size = 0;
        this.heap = new ArrayHeap();
    }

    @Override
    public Integer dequeue() {
        return this.heap.remove();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void enqueue(Integer value) {
        this.heap.add(value);
        this.size ++;
    }

    @Override
    public int compare(Integer a, Integer b) {
        return 0;
        
    }
    


}