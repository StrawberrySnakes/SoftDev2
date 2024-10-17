// Dessa Shapiro
package unit06;

// makes it generic and comparable
public interface BinarySearchTree <E extends Comparable<E>> {
    void insert(E Value);
    boolean search(E value);
    int size();
    
}
