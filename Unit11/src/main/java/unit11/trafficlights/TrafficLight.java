// Dessa Shapiro
package unit11.trafficlights;

// Trafficlight class
public class TrafficLight implements Runnable {
    private Color color;

    // Constructor
    public TrafficLight() {
        this.color = Color.RED;
    }

    // Getter and setter
    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    // Run method
    @Override
    public void run() {
        while (true) {
            synchronized (color) {
                if (getColor() == Color.RED) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.color = Color.GREEN;
                    System.out.println("The light is RED!");
                }
                if (getColor() == Color.GREEN) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("The light is GREEN!");
                    this.color = Color.YELLOW;
                }
                if (getColor() == Color.YELLOW) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.color = Color.RED;
                    System.out.println("The light is YELLOW!");
                }
            }
        }
    }
}
