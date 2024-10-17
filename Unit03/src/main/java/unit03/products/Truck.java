package unit03.products;
// Dessa Shapiro

public class Truck {
    private Product[] products;
    private int maxCapacity;
    private int capacity;

    /**
     * 
     * @param maxCapacity
     */
    public Truck(int maxCapacity) {
		this.maxCapacity = maxCapacity;
        this.capacity = 0;
        this.products = new Product[maxCapacity];
    }

    public boolean isFull(){return this.capacity == this.maxCapacity;}
    public boolean isEmpty(){return this.capacity == 0;}
    public int getCapacity() {return this.capacity;}


    /**
     * 
     * @param product
     */
    public void load(Product product) {
        if(!isFull()) {
            products[capacity] = product;
            capacity++;
        } else {
            System.out.println("Truck is full");
        }
    }
    /**
     * 
     * @return 
     */
    public Product unload() {
        if(!isEmpty()) {
            capacity --;
            Product product = products[capacity];
            products[capacity] = null;
            return product;
        } else {
            System.out.println("Truck is empty");
            return null;
        }
    }

}
// public class Truck(){
//     private Product[] products;
// 	// protected final int MAX_CAPACITY;
// 	// private static int currentCapacity;
// 	// private static Product[] products;

// 	public Truck(int capacity) {
// 		this.MAX_CAPACITY = capacity;
// 		this.currentCapacity = 0;
// 		this.products = new Product[capacity];
    
//     }

// 	public void load(Product product){
// 		if (this.currentCapacity >= MAX_CAPACITY){
//             System.out.println("Truck is full, can not load.");
//         } else {
// 	    this.Product[currentCapacity] = product;
//         this.currentCapacity++;
//         }
// }
// 	public Product unload(){
// 		Product product = Product[currentCapacity - 1];
// 		this.Product[this.currentCapacity - 1] = null;
//         this.currentCapacity--;
// 	    return product;
// }
// }

