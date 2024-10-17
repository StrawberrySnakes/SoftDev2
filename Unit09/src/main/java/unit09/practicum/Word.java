// Dessa Shapiro
package unit09.practicum;

import unit09.graphs.WAdjacencyGraph;
import unit09.graphs.WGraph;
import unit09.graphs.WPath;

public class Word {
    public static void main(String[] args) {
        WGraph<String> graph = createWordGraph("PRACTICUM");
        WPath<String> path = graph.dijkstrasPath("P", "M");
        System.out.println(path);
    }

    private static WGraph<String> createWordGraph(String word) {
        WGraph<String> graph = new WAdjacencyGraph<>();
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            graph.add(String.valueOf(letters[i]));
        }

        for (int i = 0; i < letters.length - 1; i++) {
            graph.connect(String.valueOf(letters[i]), String.valueOf(letters[i + 1]), 1.0);
        }

        // Connect the last letter to the first one to form a loop
        graph.connect(String.valueOf(letters[letters.length - 1]), String.valueOf(letters[0]), 1.0);

        return graph;
    }
}
