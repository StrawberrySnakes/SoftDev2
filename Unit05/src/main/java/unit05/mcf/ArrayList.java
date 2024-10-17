// Dessa Shapiro
package unit05.mcf;

import java.util.Arrays;
import java.util.Iterator;



public class ArrayList<E> implements List<E> {
    private static final int DEFULT_SIZE = 2;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Object[ArrayList.DEFULT_SIZE];
        this.size = 0;
    }

    
    public ArrayList(List<E> list) {
        this.elements = new ArrayList[list.size()];
        this.size = list.size();
    }



    @Override
    public void append(E value) {
        if(this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
        }
        this.elements[this.size] = value;
        this.size ++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return (E)this.elements[index];

    }

    @Override
    public void set(int index, E value) {
        if (index < this.size) {
            this.elements[index] = value;
        }
        else { throw new IndexOutOfBoundsException();}
    }

    @Override
    public int size() {
        return this.size;
    }


        return result;
    }

    @Override
    public String toString() {
        return "List "+this.size +" "+ Arrays.toString(elements);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(this.elements, this.size);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayList) {
            ArrayList<E> other = (ArrayList<E>) obj;
            return this.size == other.size() && this.elements.equals(other.elements);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println(al);
        for (int i = 10; i<20; i++) {
            al.append(i);
            System.out.println(al);
        }
        al.set(1, 1);
        System.out.println(al);
        System.out.println(al.get(1));
        // }
        // al.set(0, 1);
        // System.out.println(al);
        // System.out.println(al.get(1));

    }
    
}
