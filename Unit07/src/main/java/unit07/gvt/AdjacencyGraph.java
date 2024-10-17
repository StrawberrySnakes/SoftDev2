// Dessa Shapiro
package unit07.gvt;

import java.util.*;

import unit07.Graphs.Graph;
import unit07.Graphs.Vertex;

public class AdjacencyGraph<E> implements Graph<E>{
    private Map<E, Vertex<E>> vertices;

    public AdjacencyGraph() {
        this.vertices = new HashMap<>();
    }

    @Override
    /**
     * @param value
     */
    public void add(E value) {
        Vertex<E> vertex = new Vertex<>(value);
        this.vertices.put(value, vertex);
    }

    @Override
    /**
     * @param value
     */
    public boolean contains(E value) {
        return this.vertices.containsKey(value);
    }

    @Override
    public int size() {
        return this.vertices.size();
    }

    @Override
    /**
     * @param a
     * @param b
     */
    public void connectDirected(E a, E b) {
        Vertex<E> vertA = this.vertices.get(a);
        Vertex<E> vertB = this.vertices.get(b);
        vertA.connect(vertB);
    }
    

    @Override
    /**
     * @param a
     * @param b
     */
    public void connectUndirected(E a, E b) {
        Vertex<E> vertA = this.vertices.get(a);
        Vertex<E> vertB = this.vertices.get(b);
        vertB.connect(vertA);
        vertA.connect(vertB);
        // or
        // connectDirected(b, a);
    }

    @Override
    /**
     * @param a
     * @param b
     */
    public boolean connected(E a, E b) {
        Vertex<E> vertA = this.vertices.get(a);
        Vertex<E> vertB = this.vertices.get(b);
        return vertA.connected(vertB);
    }

    @Override
    /**
     * @param start
     * @param end
     */
    public boolean bfSearch(E start, E end) {
        Vertex<E> s = this.vertices.get(start);
        Vertex<E> e = this.vertices.get(end);
        Queue<Vertex<E>> queue= new LinkedList<>();
        Set<Vertex<E>> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        while(!queue.isEmpty()) {
            Vertex<E> v = queue.poll();
            if (v == e) {
                return true;
            } else {
                for (Vertex<E> n : v.getNeighbors()) {
                    if(!visited.contains(n)) {
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
        }
        return false;
    } 


    @Override
    /**
     * @param start
     * @param end
     * @return
     */
    public List<E> bfPath(E start, E end) {
        Vertex<E> s = this.vertices.get(start);
        Vertex<E> e = this.vertices.get(end);
        Queue<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>, Vertex<E>> pred = new HashMap<>();
        queue.add(s);
        pred.put(s, null);
    
        while (!queue.isEmpty()) {
            Vertex<E> v = queue.poll();
            if (v.equals(e)) {
                break;
            } else {
                for (Vertex<E> n : v.getNeighbors()) {
                    if (!pred.containsKey(n)) {
                        pred.put(n, v);
                        queue.add(n);
                    }
                }
            }
        }
    
        return makePath(pred, e);
    }

    /**
     * 
     * @param pred
     * @param e
     * @return
     */
    private List<E> makePath(Map<Vertex<E>, Vertex<E>> pred, Vertex<E> e) {
        if (pred.containsKey(e)) {
            List<E> path = new LinkedList<>();
            Vertex<E> current = e;
            while(current != null ) {
                path.add(0, current.getValue());
                current = pred.get(current);
            }
            return path;
        } else {
            return null;
        }  
    }

    @Override
    /**
     * @param start
     * @param end
     */
    public boolean dfSearch(E start, E end) {
        Vertex<E> s = this.vertices.get(start);
        Vertex<E> e = this.vertices.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(s);
        visitDFS(s, visited);
        return visited.contains(e);
    }

    /**
     * 
     * @param vertex
     * @param visited
     */
    protected void visitDFS(Vertex<E> vertex, Set<Vertex<E>> visited) {
        for(Vertex<E> neighbor : vertex.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                visitDFS(neighbor, visited);
            }
        }
    }

    @Override
    /**
     * @param start
     * @param end
     */
    public List<E> dfPath(E start, E end) {
        Vertex<E> s = this.vertices.get(start);
        Vertex<E> e = this.vertices.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(s);
        return visitDFPath(s,e, visited);
    }

    /**
     * 
     * @param v
     * @param e
     * @param visited
     * @return
     */
    protected List<E> visitDFPath(Vertex<E> v, Vertex<E> e, Set<Vertex<E>> visited) {
        if (v == e) {
            List<E> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        } else {
            for (Vertex<E> neighbor : v.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<E> path = visitDFPath(neighbor, e, visited);
                    if (path != null) {
                        path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }
 

    // method to get vertex containing specified value
    /**
     * 
     * @param value
     * @return
     */
    public Vertex<E> getVertex(E value) {
        return this.vertices.get(value);
    }
}
