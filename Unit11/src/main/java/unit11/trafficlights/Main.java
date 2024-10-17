package unit11.trafficlights;

import java.util.Random;

public class Main {
        public static void main(String[] args) {
            Intersection intersection = new Intersection();
            Random random = new Random();
            for (int i = 1; i <= 100; i++) {
                Direction direction = Direction.values()[random.nextInt(Direction.values().length)]; // Random direction
                Vehicle vehicle = new Vehicle(i, direction, intersection);
                new Thread(vehicle).start();
                try {
                    Thread.sleep(random.nextInt(2000)); // Random wait time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    

