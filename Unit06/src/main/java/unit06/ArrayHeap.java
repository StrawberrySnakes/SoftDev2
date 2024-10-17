package unit06;

import java.util.Arrays;

public class ArrayHeap implements Heap {
    private int[] array;
    private int size;
    private static final int MIN_HEAP_SIZE = 3;

    public ArrayHeap() {
        this.array = new int[MIN_HEAP_SIZE];
        this.size = 0;
    }
    @Override
    public void add(int value) {
        if (this.size == this.array.length) {
            this.array = Arrays.copyOf(this.array, this.size * 2);
        }
        this.array[this.size] = value;

        // sifting up
        int child = size;
        int parent = (child -1) / 2;
        while(this.array[parent] > this.array[child]) {
            swap(parent, child);
            child = parent;
            parent = (child -1) / 2;
        }

        this.size++;
    }


    private void swap(int a, int b) {
        if (a!=b) {
            int temp = this.array[a];
            this.array[a] = this.array[b];
            this.array[b] = temp;
        }
    }
    @Override
    public int remove() {
        int temp = this.array[0];
        this.size--;
        swap(0, size);
        this.array[size] = 0;

        // siffting down
        int parent = 0;
        while(parent < this.size) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            int dest = parent;
            if(left < this.size) {
                dest = left;
            }
            if (right < this.size && this.array[right]<this.array[left]) {
                dest = right;
            }
            if (this.array[dest] < this.array[parent]) {
                swap(dest, parent);
                parent = dest;
            } else {
                break;
            }
        }
        return temp;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override 
    public String toString() {
        return Arrays.toString(this.array) + ", " + this.size;
    }

    public static void main(String[] args) {
        ArrayHeap heap = new ArrayHeap();
        System.out.println(heap);
        for (int i = 10; i >= 1; i--) {
            heap.add(i);
            System.out.println(heap);
        }
        while (heap.size()> 0) {
            System.out.println(heap.remove());
            System.out.println(heap);
        }

    }
    
}
