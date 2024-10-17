package unit05.mcf;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {

    private Object[] elements; 
    private int current;
    private int size;

    public ArrayIterator(Object[] elements, int startIndex, int stopIndex) {
        this.elements = elements;
        this.size = stopIndex;
        this.current = startIndex;
    }

    public ArrayIterator(Object[] elements, int stopIndex) {
        this(elements, 0, stopIndex);
    }

    @Override
    public boolean hasNext() {
        return this.current == this.stop;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E next() {
        E element = (E)this.elements[this.current];
        this.current = (this.current + 1) % this.elements.length;
        return element;
    }
    
}
