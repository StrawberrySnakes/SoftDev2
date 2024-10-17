// Dessa Shapiro
package unit11.ggg;

import java.util.*;

public class GreedyGreedyGoats {
    public static void main(String[] args) {
        Trough trough = new Trough(10); // Set max limit
        TurnipDropper turnipDropper = new TurnipDropper(trough);
        Goat[] goats = {
            new Goat(Color.RED, trough),
            new Goat(Color.BLUE, trough),
            new Goat(Color.GREEN, trough),
            new Goat(Color.YELLOW, trough)
        };

        try{
            turnipDropper.start(); // Start the turnip dropper thread

            // Start each goat in its own thread
            for (Goat goat : goats) {
                goat.start();
            }

            turnipDropper.join(); // Wait for turnip dropper thread to finish

            // Wait for each goat thread to finish
            for (Goat goat : goats) {
                goat.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (System.out) {
            System.out.println("Number of turnips dropped: " + trough.getTurnipsSoFar());
            System.out.println("Goats in descending order of turnips eaten:");
            Arrays.sort(goats, Comparator.comparingInt(Goat::getTurnipsEaten).reversed());
            for (Goat goat : goats) {
                System.out.println(goat);
            }
            System.out.println("Total number of turnips eaten: " + Arrays.stream(goats).mapToInt(Goat::getTurnipsEaten).sum());
        }
    }
}
