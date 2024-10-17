package unit03.products;

import java.util.Random;
// Dessa Shapiro
public class Complex {
    private Factory[] factories;

    /**
     * 
     * @param factories
     */
    public Complex(Factory[] factories) {
        this.factories = factories;
    }

    // Method to load a truck with products from the factories
    /**
     * 
     * @param truck
     */
    public void loadTruck(Truck truck) {
        Random random = new Random();

        // Load products into the truck until reaches capacity
        while (!truck.isFull()) {
            Factory randomFactory = factories[random.nextInt(factories.length)];
            Product product = randomFactory.manufactureProduct();
            System.out.println("Truck loaded: {"+product+"}");
            truck.load(product);
        }
    }
    
}
