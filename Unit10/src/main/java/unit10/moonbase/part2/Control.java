// Dessa Shapiro

package unit10.moonbase.part2;

import java.util.*;

// Class Control is meant to track the locations of rovers and ensure single occupancy in a tunnel
public class Control {
    private List<Rover> queue = new ArrayList<>(); // List to hold rovers waiting to access the tunnel
    private Rover currentRover = null; // Reference to the current rover in the tunnel

    /**
     * Grants access to a rover to enter the tunnel
     * 
     * @param rover The rover to grant access
     */
    public void accessTunnel(Rover rover) {
        queue.add(rover); // Add the rover to the queue
        // Busy wait until the rover becomes the current rover and is at the front of the queue
        while (currentRover != rover || !queue.get(0).equals(rover)) {
            try {
                Thread.sleep(100); // Polling interval
            } catch (InterruptedException e) {
                e.printStackTrace(); // Exception handling
            }
        }
        currentRover = rover; // Set the current rover to the accessed rover
    }

    /**
     * Removes a rover from the tunnel
     */
    public void leaveTunnel() {
        queue.remove(currentRover); // Remove the current rover from the queue
        if (!queue.isEmpty()) {
            currentRover = queue.get(0); // If queue is not empty, set the next rover in the queue as current
        } else {
            currentRover = null; // If queue is empty, set current rover to null
        }
    }
}
