package unit03.toys;
// Dessa Shapiro

import unit03.products.Complex;
import unit03.products.DollFactory;
import unit03.products.RobotFactory;
import unit03.products.Truck;
import unit03.products.Factory;


public class Main {
    /**
     * Main method to demonstrate the simulation with polymorphism.
     * @param args
     */
    public static void main(String[] args) {
        DollFactory dollFactory = new DollFactory();
        RobotFactory robotFactory = new RobotFactory();

        // Create an array of Factory and add the instances
        Factory[] factories = new Factory[]{dollFactory, robotFactory};

        // Create a complex with the array of factories
        Complex toyComplex = new Complex(factories);

        // Create an empty truck
        Truck toyTruck = new Truck(10);

        // Load the truck at the complex
        toyComplex.loadTruck(toyTruck);

        // Unload the truck and print each product
        while (!toyTruck.isEmpty()) {
            System.out.println("Truck unloads: "+toyTruck.unload());
        }
    }
}

