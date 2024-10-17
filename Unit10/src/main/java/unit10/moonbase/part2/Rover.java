// Dessa Shapiro

package unit10.moonbase.part2;

// Class Rover represents a rover and its traversal through a tunnel
public class Rover implements Runnable {
    public static final int SECOND = 1000;
    private String name;
    private int traversalTime;
    private String startingHub;
    private String destinationHub;
    private Control control;

    /**
     * Constructs a Rover object with specified parameters
     * 
     * @param name            The name of the rover
     * @param traversalTime   The time taken for traversal
     * @param startingHub     The starting hub of the traversal
     * @param destinationHub  The destination hub of the traversal
     * @param control         The control instance to manage tunnel access
     */
    public Rover(String name, int traversalTime, String startingHub, String destinationHub, Control control) {
        this.name = name;
        this.traversalTime = traversalTime;
        this.startingHub = startingHub;
        this.destinationHub = destinationHub;
        this.control = control;
    }

    @Override
    /**
     * run implementation
     */
    public void run() {
        control.accessTunnel(this); // Access the tunnel via control instance

        // Print messages indicating traversal initiation
        System.out.println(name + " is ready to start traversal at the " + startingHub + " end of the tunnel.");
        System.out.println(name + " is starting traversal.");

        // Simulate traversal time and print progress
        for (int i = 1; i <= traversalTime; i++) {
            try {
                Thread.sleep(SECOND); // Simulate traversal time
                System.out.println("\t" + name + ": " + i + " seconds.");
            } catch (InterruptedException e) {
                e.printStackTrace(); // Exception handling
            }
        }

        // Print completion message and leave tunnel via control instance
        System.out.println(name + " has completed traversal and has reached the " + destinationHub + " end of the tunnel.");
        control.leaveTunnel();
    }

    /**
     * Main method to create rovers and start threads for traversal
     * 
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        Control control = new Control(); // Instantiate control instance

        // Create rover instances with specified parameters
        Rover rover1 = new Rover("Rover1", 5, "Hyperion", "Odyssey", control);
        Rover rover2 = new Rover("Rover2", 7, "Odyssey", "Hyperion", control);
        Rover rover3 = new Rover("Rover3", 4, "Hyperion", "Odyssey", control);
        Rover rover4 = new Rover("Rover4", 6, "Odyssey", "Hyperion", control);

        // Create threads for each rover and start traversal
        Thread thread1 = new Thread(rover1);
        Thread thread2 = new Thread(rover2);
        Thread thread3 = new Thread(rover3);
        Thread thread4 = new Thread(rover4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
