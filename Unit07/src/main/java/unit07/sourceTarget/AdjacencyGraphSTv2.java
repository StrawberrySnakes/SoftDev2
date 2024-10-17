// Dessa Shapiro
package unit07.sourceTarget;

import java.util.*;

import unit07.Graphs.AdjacencyGraph;

public class AdjacencyGraphSTv2<E> {
    private final AdjacencyGraph<E> graph;
    private final E[] source;
    private final E[] target;
    private final E dummySource;
    private final E dummyTarget;

    /** 
     * 
     * @param graph
     * @param source
     * @param target
     */
    public AdjacencyGraphSTv2(AdjacencyGraph<E> graph, E[] source, E[] target) {
        this.graph = graph;
        this.source = source;
        this.target = target;
        this.dummySource = makeDummySource();
        this.dummyTarget = makeDummyTarget();
        connectDummyVertices();
    }

    /**
     * 
     * @return
     */
    private E makeDummySource() {
        return (E) "s";
    }

    /**
     * 
     * @return
     */
    private E makeDummyTarget() {
        return (E) "t";
    }

    private void connectDummyVertices() {
        // Connect dummy to every vertex in source 
        for (E sourceVertex : source) {
            graph.connectDirected(dummySource, sourceVertex);
        }
        // Every target
        for (E targetVertex : target) {
            graph.connectDirected(targetVertex, dummyTarget);
        }
    }

    /**
     * 
     * @return
     */
    public boolean bfSearch() {
        return this.graph.bfSearch(this.dummySource, this.dummyTarget);
    }

    /**
     * 
     * @return
     */
    public List<E> bfPath() {
        return this.graph.bfPath(this.dummySource, this.dummyTarget);
    }

}

