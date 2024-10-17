package unit03.products;
// Dessa Shapiro

import java.util.Random;

import unit03.toys.Robot;

public class RobotFactory implements Factory {

    @Override
    /**
     * @return Robot
     */
    public Product manufactureProduct() {
        Random RAN = new Random();
        double price = 30.99 + RAN.nextInt(71);
        return new Robot("Robot", price);
    }
    
}
