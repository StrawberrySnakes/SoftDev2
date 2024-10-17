// Dessa Shapiro
package unit07.practicum;

import java.util.LinkedList;

public class ListPQ implements Queue<Integer>{
    private int size;
    private LinkedList<Integer> list;

    public ListPQ() {
        this.size = 0;
        this.list = new LinkedList<>();
    }

    @Override
    public void enqueue(Integer value) {
            if (list.isEmpty() || value < list.getFirst()) {
                list.addFirst(value);
            } else {
                int index = 0;
                while (index < list.size() && value >= list.get(index)) {
                    index++;
                }
                list.add(index, value);
            }
        }
    
    @Override
    public Integer dequeue() {
        return list.removeFirst();
    }

    @Override
    public int size() {
        return this.size;
    }

    
}

