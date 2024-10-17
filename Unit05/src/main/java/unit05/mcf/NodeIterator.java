package unit05.mcf;

import java.util.Iterator;

public class NodeIterator<E> implements Iterator<E> {
    private Node<E> current;

    public NodeIterator(Node<E> front) {
        this.current = front;
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    @Override
    public E next() {
        E element = this.current.getValue();
        this.current = this.current.getNext();
        return element;
        
    }

    
    
}
