package unit11.activities;

// Class NameThread creates threads to print characters from a given name in order
public class NameThread implements Runnable {
    private final String name;
    private final int index;
    private final Thread previous;

    // Constructor
    public NameThread(Thread previous, String name, int index) {
        this.previous = previous;
        this.name = name;
        this.index = index;
    }

    // run(): Method defining the behavior of the thread
    @Override
    public void run() {
        // If previous thread exists, wait for it to finish
        if (previous != null) {
            try {
                this.previous.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Print the character at the current index of the name
        System.out.println(name.charAt(this.index));
    }

    // main(): Entry point of the program
    public static void main(String[] args) throws InterruptedException {
        String name = "abcdef";
        Thread previous = null;
        // Create and start threads for each character in the name
        for (int i = 0; i < name.length(); i++) {
            NameThread nt = new NameThread(previous, name, i);
            Thread thread = new Thread(nt);
            thread.start();
            previous = thread;
        }
        // Wait for the last thread to finish
        previous.join();
        // Print an exclamation mark after all threads finish execution
        System.out.println("!");
    }
}
