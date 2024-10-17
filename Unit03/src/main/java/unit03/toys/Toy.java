// Dessa Shapiro
package unit03.toys;

import unit03.products.Product;

// Creating abstract class
public abstract class Toy extends Product {
    private static int counter = 1000000;
    protected final int productCode;
    protected final String name;
    protected final double MSRP;

    public Toy(String name, double MSPR) {
        super(name, MSPR);
        this.productCode = Toy.counter++;
        this.name = name;
        this.MSRP = MSPR;
    }
    
    public String getName() {return this.name;}
    public double getMsrp() {return this.MSRP;}

    public abstract void play();

    @Override
    public String toString() {
        return "Toy{" +
                "productCode=" + this.productCode +
                ", name='" + this.name + '\'' +
                ", msrp=" + this.MSRP +
                '}';
    }

}
