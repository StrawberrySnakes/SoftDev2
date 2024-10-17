// Dessa Shapiro
package unit06.practicum;
import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>{
    private Object[] elements;
    private int size;
    public final static int DEFULT_SIZE = 10;

    public ArrayStack() {
        this.elements = new Object[ArrayStack.DEFULT_SIZE];
        this.size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
    
        String result = "[";
        for (int i = 0; i < size - 1; i++) {
            result += elements[i] + ", ";
        }
        result += elements[size - 1] + "]";
        return result;
    }
 
    @Override
    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E top() {
        return (E) elements[0];
    }

    @Override    
    public void push(E value) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    
        for (int i = size - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }
    
        elements[0] = value;
        size++;
    }
        // for (int i = 0; i<this.size; i++){
        //     if(elements[i] != null) {
        //         continue;
        //     }
        //     elements[i] = value;
        //     break;
        // }
    
    @SuppressWarnings("unchecked")
    @Override
    public E pop() {
        Object topEl = this.elements[0];

        for (int i = 0; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    
        this.elements[this.size - 1] = null;
    
        this.size--;
        return (E)topEl;
    }

    // it doesnt say wiitch order the iterator has to go, and he said he'll go over it in class
    // I know I could switch the order of everything but I don't think I'm supposed to...
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements, this.size);
    }

    public static void main(String[] args) {
        ArrayStack<Integer> as= new ArrayStack<>();
        System.out.println(as);
        for(int i = 0; i < 15; i++){
            as.push(i);
            System.out.println(as);
        }

        for (Integer ele : as) {
            System.out.println(ele);
        }

        System.out.println(as.top());
        System.out.println(as.pop());
        System.out.println(as);
        System.out.println(as.pop());
        System.out.println(as);
        
    
}
}
