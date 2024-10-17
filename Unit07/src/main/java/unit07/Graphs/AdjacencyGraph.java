// Dessa Shapiro
package unit07.Graphs;

import java.util.*;

public class AdjacencyGraph<E> implements Graph<E>{
    private Map<E, Vertex<E>> verticies;

    public AdjacencyGraph() {
        this.verticies = new HashMap<>();
    }

    @Override
    public void add(E value) {
        Vertex<E> vertex = new Vertex<>(value);
        this.verticies.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return this.verticies.containsKey(value);
    }

    @Override
    public int size() {
        return this.verticies.size();
    }

    @Override
    public void connectDirected(E a, E b) {
        Vertex<E> vertA = this.verticies.get(a);
        Vertex<E> vertB = this.verticies.get(b);
        vertA.connect(vertB);
    }
    

    @Override
    public void connectUndirected(E a, E b) {
        Vertex<E> vertA = this.verticies.get(a);
        Vertex<E> vertB = this.verticies.get(b);
        vertB.connect(vertA);
        vertA.connect(vertB);
        // or
        // connectDirected(b, a);
    }

    @Override
    public boolean connected(E a, E b) {
        Vertex<E> vertA = this.verticies.get(a);
        Vertex<E> vertB = this.verticies.get(b);
        return vertA.connected(vertB);
    }

    @Override
    public boolean bfSearch(E start, E end) {
        Vertex<E> s = this.verticies.get(start);
        Vertex<E> e = this.verticies.get(end);
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
    public List<E> bfPath(E start, E end) {
        Vertex<E> s = this.verticies.get(start);
        Vertex<E> e = this.verticies.get(end);
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
    public boolean dfSearch(E start, E end) {
        Vertex<E> s = this.verticies.get(start);
        Vertex<E> e = this.verticies.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(s);
        visitDFS(s, visited);
        return visited.contains(e);
    }

    private void visitDFS(Vertex<E> vertex, Set<Vertex<E>> visited) {
        for(Vertex<E> neighbor : vertex.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                visitDFS(neighbor, visited);
            }
        }
    }

    @Override
    public List<E> dfPath(E start, E end) {
        Vertex<E> s = this.verticies.get(start);
        Vertex<E> e = this.verticies.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(s);
        return visitDFPath(s,e, visited);
    }

    private List<E> visitDFPath(Vertex<E> v, Vertex<E> e, Set<Vertex<E>> visited) {
        if(v == e) {
            List<E> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        } else {
            for(Vertex<E> neighbor : v.getNeighbors()) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<E> path = visitDFPath(neighbor, e, visited);
                    if(path != null){
                        path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
        
    }
}
    

