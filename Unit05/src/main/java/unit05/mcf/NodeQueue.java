package unit05.mcf;

import java.util.Iterator;

public class NodeQueue<E> implements Queue<E>{
    private Node<E> front;
    private Node<E> back;
    private int size;

    // dont need generic value on constructor
    public NodeQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    
    @Override
    public void enqueue(E value) {
        Node<E> node = new Node<E>(value);
        if (this.front == null) {
            this.front = node;
            this.back = node;
        } else {
            this.back.setNext(node);
            this.back = node;
        }
        this.size += 1;
    }

    @Override
    public E dequeue() {
        E value = front.getValue();
        this.front = this.front.getNext();
        if (this.front == null) {
            this.back = null;
        }

        this.size-=1;
        return value;
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
        return "Queue{"+this.size +", "+this.front+"}";
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<>(front);
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        NodeQueue<String> q = new NodeQueue<>();
        System.out.println(q.isEmpty());
        q.enqueue("One");
        q.enqueue("Two");
        q.enqueue("Three");
        q.enqueue("Four");
        System.out.println(q);
        System.out.println(q.isEmpty()); 

        System.out.println(q.dequeue());
        System.out.println(q);

        // autoboxing
        NodeQueue<Integer> iq = new NodeQueue<>();
        for(int i = 0; i < 15; i++) {
            iq.enqueue(i);
            System.out.println(iq);
        }

    }

    
}
