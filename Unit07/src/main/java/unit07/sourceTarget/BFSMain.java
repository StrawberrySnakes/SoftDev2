// Dessa Shapiro
package unit07.sourceTarget;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import unit07.Graphs.AdjacencyGraph;

public class BFSMain {

    /**
     * 
     * @param filename
     * @return
     */
    public static AdjacencyGraphST<String> makeAdjacencyGraphST(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] sourceVertices = br.readLine().split(" ");
            String[] targetVertices = br.readLine().split(" ");

            AdjacencyGraph<String> graph = new AdjacencyGraph<>();
            for (String vertex : sourceVertices) {
                graph.add(vertex);
            }
            for (String vertex : targetVertices) {
                graph.add(vertex);
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                String vertex = tokens[0];
                for (int i = 1; i < tokens.length; i++) {
                    graph.connectDirected(vertex, tokens[i]);
                }
            }
            return new AdjacencyGraphST<>(graph, sourceVertices, targetVertices);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AdjacencyGraphSTv2<String> makeAdjacencyGraphSTv2(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] sourceVertices = br.readLine().split(" ");
            String[] targetVertices = br.readLine().split(" ");

            AdjacencyGraph<String> graph = new AdjacencyGraph<>();
            for (String vertex : sourceVertices) {
                graph.add(vertex);
            }
            for (String vertex : targetVertices) {
                graph.add(vertex);
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                String vertex = tokens[0];
                for (int i = 1; i < tokens.length; i++) {
                    graph.connectDirected(vertex, tokens[i]);
                }
            }
            return new AdjacencyGraphSTv2<>(graph, sourceVertices, targetVertices);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 1; i<=10; i++) {
            AdjacencyGraphST<String> graphST = makeAdjacencyGraphST("data/bfs/graph"+i+".txt");
            System.out.println(graphST.bfSearch());
            System.out.println(graphST.bfPath());
        }


        for(int i = 1; i<=10; i++) {
            AdjacencyGraphSTv2<String> graphST = makeAdjacencyGraphSTv2("data/bfs/graph"+i+".txt");
            System.out.println(graphST.bfSearch());
            System.out.println(graphST.bfPath());
        }
        
        

    }
}


    

