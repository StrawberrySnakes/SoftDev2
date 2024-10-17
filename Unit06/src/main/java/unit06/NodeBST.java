// Dessa Shapiro
package unit06;

/**
 * the node bst is used to insert and search for values
 */
public class NodeBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    public BinaryNode<E> root;
    private int size;

    public NodeBST(){
        this.root = null;
        this.size = 0;
    }

    /**
     * 
     * @param node
     * @param value
     */
    private void binaryInsert(BinaryNode<E> node, E value) {
        int comparison = value.compareTo(node.getValue());
        if(comparison < 0) {
            BinaryNode<E> left = node.getLeft();
            if (left != null) {
                binaryInsert(left, value);
            } else {
                left = new BinaryNode<E>(value);
                node.setLeft(left);
            }
        } else {
            BinaryNode<E> right = node.getLeft();

            if (right != null) {
                binaryInsert(right, value);
            } else {
                right = new BinaryNode<E>(value);
                node.setLeft(right);
            }
        }
    }


    @Override
    /**
     * @param value
     */
    public void insert(E value) {
        if(this.root == null) {
            this.root = new BinaryNode<E>(value);
        } else {
            binaryInsert((BinaryNode<E>) this.root, value);
        }
        this.size += 1;
    }
    @Override
    /**
     * @param value
     */
    public boolean search(E value) {
        return this.root != null && binarySearch(this.root, value);
    }

    private boolean binarySearch(BinaryNode<E> node, E target) {
        int comparison = target.compareTo(node.getValue());
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            BinaryNode<E> left = node.getLeft();
            return left != null && binarySearch(left, target);
        }
        else {
            BinaryNode<E> right = node.getRight();
            return right != null && binarySearch(right, target);
        }
    }
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString(){
        return this.root != null ? this.root.inFixTraversal() : "empty";
    }

    // Main function
    public static void main(String[] args) {
        int[] vals = {8, 6, 1, 4, 9,10, 3, 2};
        NodeBST<Integer> n = new NodeBST<>();
        for (int val : vals) {
            n.insert(val);
        }
        System.out.println(n);
        for (int i = 0; i <= 10; i++) {
            System.out.println();
        }
    }
    
}
