package unit10.concurrency;

import java.util.ArrayList;
import java.util.List;

// Class to demonstrate adding elements to a list concurrently
public class ListAdder implements Runnable {
    private List<Integer> holder; // List to hold integers
    private int number; // Number of elements to add to the list

    // Constructor to initialize the list holder and the number of elements to add
    public ListAdder(List<Integer> holder, int number) {
        this.holder = holder;
        this.number = number;
    }

    // Run method to add elements to the list
    @Override
    public void run() {
        // Loop to add the specified number of elements to the list
        for (int i = 0; i < this.number; i++) {
            this.holder.add(i); // Add the element to the list
        }
    }

    // Main method
    public static void main(String[] args) throws InterruptedException {
        List<Integer> holder = new ArrayList<>(); // Create a new list to hold integers
        Thread[] threads = new Thread[100]; // Array to hold thread objects

        // Create and start 100 threads to add elements to the list concurrently
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(new ListAdder(holder, 50)); // Create a new ListAdder instance for each thread
            threads[i].start(); // Start the thread
        }

        // Wait for all threads to finish
        for (int i = 0; i < 100; i++) {
            threads[i].join(); // Join each thread
        }

        System.out.println("Holder size = " + holder.size()); // Print the size of the list
    }
}
