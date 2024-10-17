package unit11.activities;

import java.util.*;

// Class Consumer implements a consumer that consumes messages from a queue
public class Consumer implements Runnable {
    private final LinkedList<String> queue; // Queue to consume messages from
    private final int id; // Consumer ID

    // Constructor
    public Consumer(int id, LinkedList<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    // run(): Method to consume messages from the queue
    @Override
    public void run() {
        while (true) {
            String msg = null;
            synchronized (queue) {
                // Wait until there are messages in the queue
                while (queue.isEmpty()) {
                    try {
                        queue.wait(); // Wait for notification when queue is not empty
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Consume the message from the queue
                msg = queue.remove(0);
                System.out.println("Consumer" + this.id + ": " + msg);
            }
            System.out.println(this.id + " Waiting for work");
        }
    }

    // main(): Entry point of the program
    public static void main(String[] args) {
        // Create a queue and add some messages
        LinkedList<String> queue = new LinkedList<>();
        queue.add("First Message");
        queue.add("Second Message");

        // Create a consumer and start its thread
        Consumer consumer = new Consumer(0, queue);
        Thread thread = new Thread(consumer);
        thread.start();
    }
}
