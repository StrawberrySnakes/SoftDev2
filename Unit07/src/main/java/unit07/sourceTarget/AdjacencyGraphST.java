// Dessa Shapiro
package unit07.sourceTarget;

import java.util.List;

import unit07.Graphs.AdjacencyGraph;

public class AdjacencyGraphST<E>  {

    private AdjacencyGraph<E> graph;
    private E[] source;
    private E[] target;

    /**
     * 
     * @param graph
     * @param source
     * @param target
     */
    public AdjacencyGraphST(AdjacencyGraph<E> graph, E[] source, E[] target) {
        this.graph = graph;
        this.source = source;
        this.target = target;
    }
    /**
     * 
     * @return
     */
    public boolean bfSearch() {
        for (int i = 0; i < this.source.length; i++) {
            for (int j = 0; j < this.target.length; j++) {
                if (this.graph.contains(this.source[i]) && this.graph.contains(this.target[j])) {
                    if (this.graph.connected(this.source[i], this.target[j])) {
                        return true;
                    }
                } else {
                    System.out.println("Error: Vertex not found in the graph");
                }
            }
        }
        return false;
    }

    /**
     * 
     * @return
     */
    public List<E> bfPath() {
        List<E> shortestPath = null;
        for (int i = 0; i < this.source.length; i++) {
            for (int j = 0; j < this.target.length; j++) {
                List<E> path = graph.bfPath(this.source[i], this.target[j]);
                if (path != null && (shortestPath == null || path.size() < shortestPath.size())) {
                    shortestPath = path;
                }
            }
        }
        return shortestPath;
    }

    
}
