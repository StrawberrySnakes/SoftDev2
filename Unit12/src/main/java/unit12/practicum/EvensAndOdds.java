package unit12.practicum;

// Class EvensAndOdds defines two threads printing even and odd numbers alternatively
public class EvensAndOdds extends Thread {
    private static final Object lock = new Object();
    private static int count = 1;
    private static final int MAX_COUNT = 100;

    // main(): Entry point of the program
    public static void main(String[] args) {

        // Thread printing even numbers
        Thread even = new Thread(() -> {
            synchronized (lock) {
                // Continue until the maximum count is reached
                while (count <= MAX_COUNT) {
                    // Check if the current count is even
                    if (count % 2 == 0) {
                        System.out.println(count); // Print even number
                        count++; // Increment count
                        lock.notify(); // Notify odd thread
                    } else {
                        try {
                            lock.wait(); // Wait for odd thread to notify
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        // Thread printing odd numbers
        Thread odd = new Thread(() -> {
            synchronized (lock) {
                // Continue until the maximum count is reached
                while (count <= MAX_COUNT) {
                    // Check if the current count is odd
                    if (count % 2 != 0) {
                        System.out.println(count); // Print odd number
                        count++; // Increment count
                        lock.notify(); // Notify even thread
                    } else {
                        try {
                            lock.wait(); // Wait for even thread to notify
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        // Start the threads
        odd.start();
        even.start();
    }
}
