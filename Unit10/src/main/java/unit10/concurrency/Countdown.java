// Author: Dessa Shapiro
package unit10.concurrency;

// Class implementing the Runnable interface for countdown functionality
public class Countdown implements Runnable {

    // Overridden run method to execute the countdown logic
    @Override
    public void run() {
        int i = -10; // Starting countdown value
        String header = "T"; // Initial header for countdown
        try {
            while (i < 10) { // Loop until countdown reaches 10
                if (i == 0) { // Check if countdown reaches liftoff
                    System.out.println("Liftoff!"); // Print liftoff message
                    header = ""; // Remove header for subsequent counts
                } else {
                    System.out.println(header + i); // Print current countdown value with header
                }
                Thread.sleep(500); // Pause thread for 500 milliseconds
                i++; // Increment countdown value
            }

        } catch (InterruptedException e) {
            // Handle interruption exception (no action needed in this case)
        }

    }

    // Main method to start the countdown thread
    public static void main(String[] args) {
        new Thread(new Countdown()).start(); // Start a new thread for countdown
    }

}
