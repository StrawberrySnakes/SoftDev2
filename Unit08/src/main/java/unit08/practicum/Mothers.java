// Dessa Shapiro
package unit08.practicum;

import java.util.*;

import unit08.graphs.AdjacencyGraph;

public class Mothers {
    // so a search bfs or dfs
    // ...modify bfs to return list of visited 
    // need a start and end
    // 0) create result list 
    // 1) make an array/list of all the vertices 
    // 2) iterate through list using each as start
    // 3) dfs or bfs to each as end
    // if reach all, add start to result list
    // return result list

    public static List<String> findMothers(AdjacencyGraph<String> graph, List<String> vertices) {
        List<String> mothers = new ArrayList<>();

        for (String vertex : vertices) {
            if (isMother(graph, vertices, vertex)) {
                mothers.add(vertex);
            }
        }

        return mothers;
    }

    private static boolean isMother(AdjacencyGraph<String> graph, List<String> vertices, String vertex) {
        for (String v : vertices) {
            if (!vertex.equals(v) && !graph.dfSearch(vertex, v)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AdjacencyGraph<String> graph1 = createGraph1();
        AdjacencyGraph<String> graph2 = createGraph2();

        // Test the algorithm with the provided graphs
        List<String> vertices1 = List.of("A", "B", "C", "D", "E");
        List<String> mothers1 = findMothers(graph1, vertices1);
        System.out.println("Mother vertices in graph 1: " + mothers1);

        List<String> vertices2 = List.of("T", "U", "V", "W", "X", "Y", "Z");
        List<String> mothers2 = findMothers(graph2, vertices2);
        System.out.println("Mother vertices in graph 2: " + mothers2);

    }

    private static AdjacencyGraph<String> createGraph1() {
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();
        graph.connectDirected("A", "B");
        graph.connectDirected("B", "E");
        graph.connectDirected("B", "C");
        graph.connectDirected("C", "D");
        graph.connectDirected("E", "A");
        return graph;
    }

    private static AdjacencyGraph<String> createGraph2() {
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();
        graph.connectDirected("T", "V");
        graph.connectDirected("X", "T");
        graph.connectDirected("X", "U");
        graph.connectDirected("Z", "U");
        graph.connectDirected("Z", "Y");
        graph.connectDirected("Y", "X");
        graph.connectDirected("Y", "W");
        graph.connectDirected("W", "T");
        return graph;
    }
}

