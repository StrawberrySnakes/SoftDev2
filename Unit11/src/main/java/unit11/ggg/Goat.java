// Dessa Shapiro
package unit11.ggg;

public class Goat extends Thread {
    private Color color; // Color
    private Trough trough; // Trough from which the goat eats turnips
    private int turnipsEaten; // Number of turnips eaten by the goat

    // Constructor
    /**
     * 
     * @param color
     * @param trough
     */
    public Goat(Color color, Trough trough) {
        this.color = color;
        this.trough = trough;
        this.turnipsEaten = 0;
    }

    // Run method to continuously eat turnips from the trough
    @Override
    public void run() {
        while (!trough.atLimit() || !trough.isEmpty()) {
            synchronized (trough) {
                while (trough.isEmpty() && !trough.atLimit()) {
                    try {
                        trough.wait(); // Wait for turnips to be dropped into the trough
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (trough.eat()) {
                    turnipsEaten++;
                    System.out.println(this.color + " goat ate a turnip. Total turnips eaten: " + this.turnipsEaten);
                }
            }
        }
    }

    // Accessors
    public Color getColor() {
        return color;
    }
    public int getTurnipsEaten() {
        return turnipsEaten;
    }

    public Trough getTrough() {
        return this.trough;
    }

    @Override
    public String toString() {
        return "The " + this.color + " goat.";
    }
}


