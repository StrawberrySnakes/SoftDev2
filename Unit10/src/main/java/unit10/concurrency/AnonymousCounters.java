package unit10.concurrency;

public class AnonymousCounters {

    // Method to count up to 100 and print the count along with the name
    public static void counter(String name) {
        int count = 1;
        while (count <= 100) {
            System.out.println(name + ": " + count);
            count++;
        }
    }

    public static void main(String[] args) {
        int n = 10; // Number of counters
        for (int i = 0; i < n; i++) {
            Thread countThread = null; // Declaring a thread variable
            String name = "Counter" + i; // Creating a name for the counter
            if (i % 2 == 0) { // Check if the counter index is even
                // Creating a thread using an anonymous class
                countThread = new Thread(new Runnable() {
                    // Anonymous class implementing the Runnable interface
                    public void run() {
                        counter(name); // Invoking the counter method with the counter name
                    };
                });
            } else {
                // Creating a thread using lambda expression
                countThread = new Thread(() -> counter(name)); // Lambda expression invoking the counter method with the counter name
            }
            countThread.start(); // Starting the thread
        }
    }
}
