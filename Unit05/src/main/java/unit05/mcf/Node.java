// Dessa Shapiro
package unit05.mcf;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next; 

    }

    public Node(E value) {
        this(value, null);
    }

    public E getValue() {return this.value;}

    public void setValue(E newValue) {this.value = newValue;}

    public Node<E> getNext() {return this.next;}

    public void setNext(Node<E> newNext) {this.next = newNext;}

    @Override
    public String toString() {
        // String rest = this.next == null ? "null" : this.next.toString();
        return this.value + " -> "+this.next;
        // if (this.next != null) {
        // return this.value + "->"+ this.next.toString();
        // } else {
        //     return 
        // }
    } 

    public static void main(String[] args) {
        Node<String> n1 = new Node<>("1");
        Node<String> n2 = new Node<>("2", n1);
        Node<String> n3 = new Node<>("3", n2);
        System.out.println(n3);

        
    }
    
}
