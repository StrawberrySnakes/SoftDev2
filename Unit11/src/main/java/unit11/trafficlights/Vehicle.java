// Dessa Shapiro

package unit11.trafficlights;

// Vehicle class
class Vehicle extends Thread {
    private int id;
    private Direction direction;
    private Intersection intersection;

    /**
     * Constructor
     * @param id
     * @param direction
     * @param intersection
     */
    public Vehicle(int id, Direction direction, Intersection intersection) {
        this.id = id;
        this.direction = direction;
        this.intersection = intersection;
    }

    // getter
    public Direction getDirection() {
        return this.direction;
    }

    // Run method has a vehicle arrive at an intersection
    @Override
    public void run() {
        try {
            intersection.arriveAtIntersection(this);
            System.out.println("Vehicle (" + id + ") headed " + direction + " drives through the intersection.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
