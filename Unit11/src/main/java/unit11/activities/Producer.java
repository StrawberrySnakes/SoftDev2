package unit11.activities;

import java.util.*;

// Class Producer generates messages and adds them to a shared queue
public class Producer implements Runnable {
    private static final Random RNG = new Random();
    private final int id;
    private final LinkedList<String> queue;

    // Constructor
    public Producer(int id, LinkedList<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    // run(): Method defining the behavior of the thread
    @Override
    public void run() {
        int msgNum = 1;
        while (msgNum < 10) {
            try {
                // Simulate message generation time
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Generate a random number of messages to produce
            int numOfMsg = RNG.nextInt(4) + 1;
            synchronized (queue) {
                for (int n = 0; n < numOfMsg; n++) {
                    String msg = "Producer " + this.id + " Msg # " + msgNum;
                    // Add message to the queue
                    queue.add(msg);
                    msgNum++;
                }
                // Notify consumers that new messages are available
                queue.notify();
            }
        }
    }

    // main(): Entry point of the program
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        // Create consumer threads
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer(i, queue);
            Thread thread = new Thread(consumer);
            thread.start();
        }
        // Create producer threads
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer(i, queue);
            Thread thread = new Thread(producer);
            thread.start();
        }
    }
}
