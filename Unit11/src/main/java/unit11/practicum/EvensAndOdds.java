// Dessa Shapiro
package unit11.practicum;

// Class EvensAndOdds prints even and odd numbers using Runnable interface
public class EvensAndOdds implements Runnable {
    
    // Method to print even numbers
    public void runTwo() {
        int i = 2;
        while (i < 100) {
            System.out.println(i);
            i++;
        }
    }

    @Override
    // Method to print odd numbers
    public void run() {
        int i = 1;
        while (i < 100) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        // Thread for printing even numbers
        Thread even = new Thread(() -> {
            for (int i = 2; i <= 100; i += 2) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread for printing odd numbers
        Thread odd = new Thread(() -> {
            for (int i = 1; i <= 99; i += 2) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        odd.start();
        even.start();
    }
}
