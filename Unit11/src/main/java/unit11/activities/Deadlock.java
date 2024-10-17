package unit11.activities;

// Class Deadlock simulates a deadlock scenario between two threads
public class Deadlock implements Runnable {
    private final String name; // Name of the thread
    private final Object lockOne; // First lock object
    private final Object lockTwo; // Second lock object

    // Constructor
    public Deadlock(String name, Object l1, Object l2) {
        this.name = name;
        this.lockOne = l1;
        this.lockTwo = l2;
    }

    // run(): Method defining the behavior of the thread
    @Override
    public void run() {
        while (true) {
            System.out.println(name + " getting lock on " + lockOne);
            synchronized (lockOne) {
                System.out.println(name + " got lock, now getting lock " + lockTwo);
                synchronized (lockTwo) {
                    System.out.println(name + " got both locks! Releasing " + lockTwo);
                }
                System.out.println(name + " releasing " + lockOne);
            }
        }
    }

    // main(): Entry point of the program
    public static void main(String[] args) {
        // Define two lock objects
        String lockA = "A";
        String lockB = "B";

        // Create two threads with opposite lock acquisition order
        new Thread(new Deadlock("DL1", lockA, lockB)).start();
        new Thread(new Deadlock("DL2", lockB, lockA)).start();
    }
}
