package unit06.practicum;

public interface Stack<E> extends Iterable<E>{
    int size();
    E top();
    void push(E value);
    E pop();

} 