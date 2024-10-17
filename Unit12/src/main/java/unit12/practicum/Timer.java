package unit12.practicum;

import java.util.*;

/**
 * The difference in performance is likely due to differences in internal implementations. Vectors are tread safe and ArrayLists are not.
 * So the ArrayList will have better performance since it is not performing additional synchronization.
 */
public class Timer extends Thread {

    // Method to time the population of a list
    public static void timeList(String name, List<Integer> li, int numberOfValues) {
        long startTime = System.nanoTime(); // Record start time
        for (int i = 0; i < numberOfValues; i++) {
            li.add(i); // Populate the list
        }
        long endTime = System.nanoTime(); // Record end time
        long finalTime = endTime - startTime; // Calculate elapsed time
        // Print the result
        System.out.println(String.format("Filled %s with %,d in %d nanoseconds.", name, numberOfValues, finalTime));
    }

    // Entry point of the program
    public static void main(String[] args) {
        final int numberOfValues = 10000000; // Number of values to add to each list

        // Thread to time ArrayList population
        Thread arrayListThread = new Thread(() -> {
            timeList("ArrayList", new ArrayList<>(), numberOfValues);
        });

        // Thread to time Vector population
        Thread vectorThread = new Thread(() -> {
            timeList("Vector", new Vector<>(), numberOfValues);
        });

        // Start the threads
        arrayListThread.start();
        vectorThread.start();
    }
}
