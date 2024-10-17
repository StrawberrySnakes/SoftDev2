package unit08.weighted;

import java.util.*;


public class WVertex<E> implements Comparator<WVertex<E>>{
    private E value;
    private final Map<WVertex<E>, Double> neighbors;

    public WVertex(E value) {
        this.value = value;
        this.neighbors = new HashMap<>();
    }

    public E getValue() {
        return value;
    }

    public double weight(WVertex<E> neighbor) {
        return this.neighbors.get(neighbor);
    }

    public void connect(WVertex<E> neighbor, double weight) {
        this.neighbors.put(neighbor, weight);
    }

    public boolean connected(WVertex<E> vertex) {
        return this.neighbors.containsKey(vertex);
    }

    public Map<WVertex<E>, Double> getNeighbors() {
        return this.neighbors;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compare(WVertex<E> a, WVertex<E> b) {
        double weightA = neighbors.get(a);
        double weightB = neighbors.get(b);
        return weightA < weightB ? -1 : 1;
    }

    public List<WVertex<E>> getNearestNeighbors() {
        List<WVertex<E>> nearest = new ArrayList<>(this.neighbors.keySet());
        Collections.sort(nearest, this);
        return nearest;
    }
    
}
