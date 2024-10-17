package unit11.activities;

import java.util.*;

// Class HelloThread creates multiple threads to print "Hello World!"
public class HelloThread implements Runnable {

    // run(): Method defining the behavior of the thread
    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    // main(): Entry point of the program
    public static void main(String[] args) {
        // List to hold the threads
        List<Thread> threads = new ArrayList<>(5);

        // Create and start 5 threads
        for (int i = 0; i < 5; i++) {
            HelloThread hello = new HelloThread();
            Thread thread = new Thread(hello);
            thread.start();
            threads.add(thread);
        }

        // Wait for each thread to finish execution
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print "Goodbye!" after all threads have finished execution
        System.out.println("Goodbye!");
    }
}
