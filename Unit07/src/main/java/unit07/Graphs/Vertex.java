// Dessa Shapiro
package unit07.Graphs;

import java.util.*;

public class Vertex<E> {
    private final E value;
    // declared on the left
    private Set<Vertex<E>> neighbors;

    public Vertex(E value) {
        this.value = value;
        // implied on the right
        this.neighbors = new HashSet<>();
    }

    public E getValue() {
        return this.value;
    }

    public void connect(Vertex<E> neighbor) {
        this.neighbors.add(neighbor);
    }

    public boolean connected(Vertex<E> neighbor) {
        return this.neighbors.contains(neighbor);
    }

    public Set<Vertex<E>> getNeighbors() {return this.neighbors;}

}
