// Dessa Shapiro
package unit03.products;

public class Product {
    private static int counter = 1000000;

    private final int productCode;
    private final String name;
    protected final double msrp;

    /**
     * 
     * @param name
     * @param msrp
     */
    public Product(String name, double msrp) {
        this.productCode = Product.counter++;
        this.name = name;
        this.msrp = msrp;
    }

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getMsrp() {
        return msrp;
    }

    // @Override
    // public String toString() {
    //     return "Product{" +
    //             "productCode=" + productCode +
    //             ", name='" + name + '\'' +
    //             ", msrp=" + msrp +
    //             '}';
    // }
}
