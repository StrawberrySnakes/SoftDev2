package unit11.activities;

// Class Waiter represents threads waiting for a notification
public class Waiter implements Runnable {
    private final Object lock;
    private final int id;

    // Constructor
    public Waiter(Object lock, int id) {
        this.lock = lock;
        this.id = id;
    }

    // run(): Method defining the behavior of the thread
    @Override
    public void run() {
        System.out.println("Waiter Starting" + this.id);
        synchronized (this.lock) {
            try {
                this.lock.wait(); // Wait for notification
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Waiter Finished" + this.id);
    }

    // main(): Entry point of the program
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        // Create and start multiple threads
        for (int i = 0; i < 10; i++) {
            Waiter waiter = new Waiter(lock, i);
            Thread thread = new Thread(waiter);
            thread.start();
        }
        // Pause for a short period of time to let threads start waiting
        Thread.sleep(1000);
        // Notify all waiting threads
        synchronized (lock) {
            lock.notifyAll();
        }
        System.out.println("Main Finished");
    }
}
