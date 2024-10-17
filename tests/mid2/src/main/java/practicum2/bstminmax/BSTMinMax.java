// Dessa Shapiro
package practicum2.bstminmax;

/**
 * Implement the class below which extends BinarySearchTree
 * Add the ability to access the minimum and maximum values in the tree in O(C) time
 * Keeping track of the minimum and maximum should be no worse than O(log N) time
 * In others words an implementation which searches the entire tree every time is not acceptable.
 * See the associated UML diagram for reference
 */ 

public class BSTMinMax<T extends Comparable<T>> extends BinarySearchTree<T> {
    
    public BSTMinMax(T initialValue) {
        super(initialValue);
    }

    public T getMin() {
        BinaryNode<T> smallestNode = super.root.getLeft();
        while(smallestNode.getLeft() != null) {
            smallestNode = smallestNode.getLeft();
        }
        return smallestNode.getValue();

    }
    
    public T getMax() {
        BinaryNode<T> largest = super.root.getRight();
        while(largest.getRight() != null) {
            largest = largest.getRight();
        }
        return largest.getValue();
    }
}
