// Dessa Shapiro
package unit11.practicum;

import java.util.Scanner;

// Class SequentialCount prints numbers sequentially using threads
public class SequentialCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = scanner.nextInt();

        Thread[] threads = new Thread[n];
        // Create threads to print numbers sequentially
        for (int i = 0; i < n; i++) {
            final int num = i + 1;
            threads[i] = new Thread(() -> System.out.println(num));
        }

        // Start and join threads to ensure sequential printing
        for (Thread thread : threads) {
            try {
                thread.start(); // Start thread
                thread.join(); // Wait for thread to finish before starting the next one
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanner.close(); // Close scanner
    }
}
