// Dessa Shapiro

package unit10.moonbase.part1;

// Class Rover creates a rover 
public class Rover implements Runnable {
    public static final int SECOND = 1000; // Constant representing one second in milliseconds
    private String name; // Name of the rover
    private int traversalTime; // Total time taken for traversal
    private String startingHub; // Starting hub of the rover
    private String destinationHub; // Destination hub of the rover

    // Constructor to initialize the Rover object
    public Rover(String name, int traversalTime, String startingHub, String destinationHub) {
        this.name = name; // Assign the name
        this.traversalTime = traversalTime; // Assign the traversal time
        this.startingHub = startingHub; // Assign the starting hub
        this.destinationHub = destinationHub; // Assign the destination hub
    }

    // run method implementation
    @Override
    public void run() {
        int i = 0; // Initialize the counter for seconds
        System.out.println(this.name + " is ready to start traversal at the " + this.startingHub + " end of the tunnel.");
        while (i < this.traversalTime) {
            if (i == 0) {
                System.out.println(this.name + " is starting traversal");
            } else {
                System.out.println(this.name + " " + i + " seconds.");
            }
            try {
                Thread.sleep(SECOND); // Pause the thread for one second
                i++; // Increment the second counter
            } catch (InterruptedException e) {
                // Exception handling for interrupted sleep
            }
        }
        System.out.println(this.name + " has completed traversal and has reached the " + destinationHub + " end of the tunnel");
    }

    // Main method to create and start rover threads
    public static void main(String[] args) {
        // Create four rover instances with different traversal parameters
        Rover rover1 = new Rover("Rover1", 5, "Hyperion", "Odyssey");
        Rover rover2 = new Rover("Rover2", 7, "Odyssey", "Hyperion");
        Rover rover3 = new Rover("Rover3", 4, "Hyperion", "Odyssey");
        Rover rover4 = new Rover("Rover4", 6, "Odyssey", "Hyperion");

        // Create four threads for each rover instance
        Thread thread1 = new Thread(rover1);
        Thread thread2 = new Thread(rover2);
        Thread thread3 = new Thread(rover3);
        Thread thread4 = new Thread(rover4);

        // Start all rover threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
