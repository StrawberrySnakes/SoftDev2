package unit11.activities;

// Class TheCount increments a shared counter by multiple threads
public class TheCount implements Runnable {
    private static int[] COUNT = new int[1]; // Shared counter
    private final int id;

    // Constructor
    public TheCount(int id) {
        this.id = id;
    }

    // run(): Method defining the behavior of the thread
    @Override
    public void run() {
        System.out.println("Counter" + this.id + " is starting...");
        // Increment the counter 10,000 times
        for (int i = 0; i < 10000; i++) {
            synchronized (COUNT) {
                COUNT[0]++; // Increment the counter
            }
        }
        System.out.println("Counter" + this.id + " is done!");
    }

    // main(): Entry point of the program
    public static void main(String[] args) throws InterruptedException {
        // Create and start multiple threads
        for (int i = 0; i < 3; i++) {
            TheCount counter = new TheCount(i);
            Thread thread = new Thread(counter);
            thread.start();
        }
        // Wait for a while to allow threads to finish their work
        Thread.sleep(1000);
        // Print the final value of the shared counter
        System.out.println(COUNT[0]);
    }
}
