package unit10.concurrency;

// Class to demonstrate counting using a thread
public class CounterThread extends Thread {
    private final String name; // Name of the counter thread

    // Constructor to initialize the counter thread with a name
    public CounterThread(String name) {
        this.name = name;
    }

    // Run method to perform counting
    @Override
    public void run() {
        // Loop to count from 1 to 100
        for (int i = 1; i <= 100; i++) {
            System.out.println(this.name + ": " + i); // Print the count
        }
    }

    // Main method
    public static void main(String[] args) {
        Thread counter = new CounterThread("Counter 1"); // Create a counter thread
        counter.start(); // Start the counter thread

        int count = 0; // Counter for checking if the counter thread is alive
        while (counter.isAlive()) { // Loop until the counter thread finishes
            try {
                Thread.sleep(50); // Sleep for 50 milliseconds
            } catch (InterruptedException e) {
                // Handle interruption exception (no action needed in this case)
            }
            count++; // Increment the counter
        }

        System.out.println(count); // Print the number of iterations while waiting for the thread

        // Loop to print characters from 'A' to 'Z'
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " "); // Print the character
        }
        System.out.println(); // Move to the next line
        counter.start(); // Attempt to start the counter thread again (invalid operation)

    }
}
