// Dessa Shapiro

package unit11.trafficlights;

// Intersection class
public class Intersection {
    private TrafficLight northSouthLight;
    private TrafficLight eastWestLight;
    
    // Constructor
    public Intersection() {
        this.northSouthLight = new TrafficLight();
        this.eastWestLight = new TrafficLight();
        Thread northSouthThread = new Thread(northSouthLight);
        Thread eastWestThread = new Thread(eastWestLight);
        northSouthThread.start();
        eastWestThread.start();
    }
    
    /**
     * 
     * @param vehicle
     * @throws InterruptedException
     */
    public synchronized void arriveAtIntersection(Vehicle vehicle) throws InterruptedException {
        // Simulate random wait time
        Thread.sleep((long) (Math.random() * 2000));
        switch (vehicle.getDirection()) {
            case NORTH:
            case SOUTH:
                if (northSouthLight.getColor() == Color.GREEN) {
                    // Vehicle can pass through
                    System.out.println("Vehicle (" + vehicle.getId() + ") headed " + vehicle.getDirection() + " drives through the intersection.");
                } else {
                    System.out.println("Vehicle (" + vehicle.getId() + ") headed " + vehicle.getDirection() + " stops because the light is RED.");
                    wait();
                }
                break;
            case EAST:
            case WEST:
                if (eastWestLight.getColor() == Color.GREEN) {
                    // Vehicle can pass through
                    System.out.println("Vehicle (" + vehicle.getId() + ") headed " + vehicle.getDirection() + " drives through the intersection.");
                } else {
                    System.out.println("Vehicle (" + vehicle.getId() + ") headed " + vehicle.getDirection() + " stops because the light is RED.");
                    wait();
                }
                break;
        }
    }
}
