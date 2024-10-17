// Dessa Shapiro
package unit05.mcf;

/**
 * Creates a linked list using nodes
 */
public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // construct given a list
    public LinkedList(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            this.append(list.get(i));
        }
    }
    
    /**
     * @param value
     * adds a new node to the list
     */
    @Override
    public void append(E value) {
        Node<E> newNode = new Node<>(value);
        if(this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            }
        this.size++;
        }

    /**
     * gets a value from the list
     * @return value at index
     */
    @Override
    public E get(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }

    /**
     * @param index
     * @param value
     * sets the value at an index to given value
     */
    @Override
    public void set(int index, E value) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setValue(value);
    }
    

    /**
     * @return the size
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * toString method
     * @return result
     */
    @Override
    public String toString() {
        String result = "List [";
    Node<E> current = head;
    while (current != null) {
        result += current.getValue();
        if (current.getNext() != null) {
            result += " -> ";
        }
        current = current.getNext();
    }
        result += "]";
        return result;
    }

    /**
     * @param obj
     * @return boolean
     * equals method
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedList){
            @SuppressWarnings("unchecked")
            LinkedList<E> other = (LinkedList<E>) obj;
            Node<E> currentThis = this.head;
            Node<E> currentOther = other.head;

            if (this.size != other.size()) {
                return false;
            }

            while (currentThis != null) {
                if (!currentThis.getValue().equals(currentOther.getValue())) {
                   return false;
                }
                currentThis = currentThis.getNext();
                currentOther = currentOther.getNext();
            } 
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        // Append
        ll.append("One");
        ll.append("Two");
        ll.append("Three");
        ll.append("Four");
        System.out.println(ll);

        System.out.println("index 1: " + ll.get(1));
        System.out.println("index 3: " + ll.get(3));
        ll.set(1, "NewTwo");
        ll.set(3, "NewFour");

        System.out.println(ll);

        System.out.println(ll.size());

    }
}


    

