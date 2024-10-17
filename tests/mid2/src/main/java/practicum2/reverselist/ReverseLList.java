package practicum2.reverselist;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * The ReverseLList class below extends LinkedList
 * You must create a "ReverseLL_Iterator.java" which implments iterator
 * and returns the elements in reverse order.
 * 
 * Note: This behavior will be identical to using the JFC LinkedList "descendingIterator"
 * method, which you MAY NOT USE!
 * 
 * DO NOT MODIFY THIS FILE
 *  
 */
public class ReverseLList<E> extends LinkedList<E> {
    @Override
    public Iterator<E> iterator() {
        return new ReverseLL_Iterator<E>(this.toArray());
    }
}
