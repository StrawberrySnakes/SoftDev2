package practicum2.reverselist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Implement the class below so that ReverseLinkedList will iterate through
 * the items in the list in reverse order
 * (i.e back to front instead of front to back)
 */ 

public class ReverseLL_Iterator<E> implements Iterator<E> {
    private int index;
    private LinkedList<E> list;

    public ReverseLL_Iterator(Object[] elements){
        this.index = list.size();
    }

    @Override
    public boolean hasNext() {
        return list.get(0) != null;
    }

    @Override
    public E next() {
        int currIndex = this.index;
        this.index --;
        return list.get(currIndex);
    }
}
