package unit10.concurrency;

// Class to demonstrate a counter using the Runnable interface
public class RunnableCounter implements Runnable {
    private String name; // Name of the counter

    // Constructor to initialize the name of the counter
    public RunnableCounter(String name) {
        this.name = name; // Assign the name
    }

    // Run method to execute the counter logic
    @Override
    public void run() {
        // Loop to count from 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(this.name + ": " + i); // Print the counter value with its name
        }
    }

    // Main method
    public static void main(String[] args) {
        RunnableCounter counter = new RunnableCounter("Counter 1"); // Create a new counter instance
        Thread thread = new Thread(counter); // Create a new thread with the counter
        thread.start(); // Start the thread to execute the counter logic

        // The following code is commented out to avoid interference with the counter demonstration
        // It was originally an attempt to interact with the counter while it was running

        // RunnableCounter counter = new RunnableCounter("Counter 1"); // Create a new counter instance
        // thread.start(); // Start the thread to execute the counter logic
        // while (thread.isAlive()) ; // Wait for the thread to finish

        // for (char ch = 'A'; ch <= 'Z'; ch++) { // Loop through characters from A to Z
        //     System.out.print(ch + " "); // Print each character
        // }
        // System.out.println(); // Print a newline
        // thread.start(); // Start the thread again (IllegalThreadStateException occurs because the thread has already been started)
    }
}
