package unit03.products;

import java.util.Random;

import unit03.toys.Doll;

public class DollFactory implements Factory {
    @Override
    public Product manufactureProduct() {
        Random RAN = new Random();
        double price = 5.99 + RAN.nextInt(31);
        return new Doll("Doll", price);
        
    }
    
}
