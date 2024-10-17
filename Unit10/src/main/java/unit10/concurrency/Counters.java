package unit10.concurrency;

// Class to demonstrate concurrent counting using multiple threads
public class Counters {

    // Main method
    public static void main(String[] args) {
        int n = 10; // Number of counters to create

        Thread[] counters = new Thread[n]; // Array to hold thread objects
        // Loop to create and start threads for each counter
        for (int i = 0; i < n; i++) {
            // Create a new RunnableCounter instance with a unique name
            RunnableCounter counter = new RunnableCounter("Counter " + i);
            counters[i] = new Thread(counter); // Create a new thread with the counter
            counters[i].start(); // Start the thread
        }
        // Loop to wait for all threads to finish
        for (int i = 0; i < n; i++) {
            try {
                counters[i].join(); // Wait for the thread to finish execution
            } catch (InterruptedException e) {
                // Handle interruption exception (no action needed in this case)
            }
        }
        // Print message after all threads have finished
        System.out.println("Main Finished");
    }
}
