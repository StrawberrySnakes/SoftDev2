package unit05.mcf;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFULT_SIZE = 10;
    
    private Object[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue() { 
        // this.elements = new E[ArrayQueue.DEFULT_SIZE];
        this.elements = new Object[ArrayQueue.DEFULT_SIZE];
        this.front = 0;
        this.back = 0;
        this.size = 0;

    }

    @Override
    public void enqueue(E value) {
        // Resize if necessary 
        if(this.size == this.elements.length) {
            Object[] bigger = new Object[this.elements.length * 2];
            for (int dest = 0; dest < this.size; dest++) {
                int source = (this.front + dest) % this.size;
                bigger[dest] = this.elements[source];
            }
            this.elements = bigger;
            this.front = 0;
            this.back = this.size;
        }

        this.elements[this.back] = value;
        this.back = (this.back + 1)% this.elements.length;
        this.size++;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() {
        if (this.size == 0) { return null;}
        else {E value = (E)this.elements[this.front];
            this.elements[this.front] = null;
            this.front = (this.front +1) % this.elements.length;
        this.size--;
        return value;
    }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        return "Queue "+this.size +" "+ Arrays.toString(elements);
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(this.elements, this.front, this.back);
    }

    public static void main(String[] args) {
        ArrayQueue<String> q = new ArrayQueue<>();
        System.out.println(q.isEmpty());
        q.enqueue("One");
        q.enqueue("Two");
        q.enqueue("Three");
        q.enqueue("Four");
        System.out.println(q);
        System.out.println(q.isEmpty());
        for (int i = 1; i < 20; i++) {
            q.enqueue(Integer.toString(i));
            System.out.println(q);
        }
        while(!q.isEmpty()) {
            System.out.println(q.dequeue());
            System.out.println(q);
        }
        


    }
}
