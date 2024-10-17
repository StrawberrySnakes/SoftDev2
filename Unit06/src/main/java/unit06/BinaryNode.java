// Dessa Shapiro
package unit06;

// Binary Node class creates a binary node...
public class BinaryNode<E> {
    private E value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(E value) {
        this(value, null, null);
    }

    // getters and setters
    public E getValue() {
        return this.value;
    }

    public BinaryNode<E> getLeft() {
        return this.left;
    }

    public BinaryNode<E> getRight() {
        return this.right;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }
    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }

    /**
     * 
     * @return result
     */
    public String inFixTraversal(){
        String result = "";
        if (this.left != null) {
            result += this.left.inFixTraversal();
        }
        result += this.value+" ";
        if (this.right != null) {
            result += this.right.inFixTraversal();
        }
        return result;
    }
    /**
     * 
     * @return result
     */
    public String preFixTraversal(){
        String result = "";
        result += this.value+" ";
        if (this.left != null) {
            result += this.left.preFixTraversal();
        }
        if (this.right != null) {
            result += this.right.preFixTraversal();
        }
        return result;
    }

    /**
     * 
     * @return result
     */
    public String postFixTraversal(){
        String result = "";
        if (this.left != null) {
            result += this.left.postFixTraversal();
        }
        if (this.right != null) {
            result += this.right.postFixTraversal();
        }
        result += this.value+" ";
        return result;
    }

    /**
     * 
     * @param target
     * @return
     */
    public boolean search(E target) {
        boolean found = false;
        if(target == this.value) {
            found = true;
        }
        if(!found && this.left != null) {
            found = this.left.search(target);
        } 
        if(!found && this.right != null) {
            found = this.right.search(target);
        } 
        return found;
    }

    @Override
    public String toString() {
        return "BinaryNode{value=" + this.value + ", left=" +this.left +", right="+this.right+"}";
    }

    public static void main(String[] args) {
        BinaryNode<Integer> bn1 = new BinaryNode<>(1);
        BinaryNode<Integer> bn2 = new BinaryNode<>(2);
        BinaryNode<Integer> bn3 = new BinaryNode<>(3);
        BinaryNode<Integer> bn4 = new BinaryNode<>(4);
        BinaryNode<Integer> bn6 = new BinaryNode<>(6);
        BinaryNode<Integer> bn7 = new BinaryNode<>(7);
        BinaryNode<Integer> bn9 = new BinaryNode<>(9);

        bn2.setLeft(bn3);
        bn2.setRight(bn7);
        bn3.setLeft(bn9);
        bn3.setRight(bn4);
        bn7.setLeft(bn1);
        bn7.setRight(bn6);

        System.out.println(bn2);
        System.out.println(bn2.inFixTraversal());

        for(int i = 1; i < 10; i++) {
            System.out.println(Integer.toString(i)+ bn2.search(i));
        }

        BinaryNode<String> sbn1 = new BinaryNode<>("a");
        BinaryNode<String> sbn2 = new BinaryNode<>("b");
        BinaryNode<String> sbn3 = new BinaryNode<>("c");
        BinaryNode<String> sbn4 = new BinaryNode<>("d");
        BinaryNode<String> sbn6 = new BinaryNode<>("f");
        BinaryNode<String> sbn7 = new BinaryNode<>("g");
        BinaryNode<String> sbn9 = new BinaryNode<>("i");

        sbn2.setLeft(sbn3);
        sbn2.setRight(sbn7);
        sbn3.setLeft(sbn9);
        sbn3.setRight(sbn4);
        sbn7.setLeft(sbn1);
        sbn7.setRight(sbn6);

        System.out.println(bn2);
        System.out.println(bn2.inFixTraversal());

        String[] sarray = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        for(int i = 0; i < 7; i++) {
            System.out.println(sarray[i]+ sbn2.search(sarray[i]));
        }



    }




    
}
