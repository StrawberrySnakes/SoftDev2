// Dessa Shapiro
package unit06.Sushi;

import java.util.Stack;

public class Order {
    private double totalCost;
    private Stack<Sushi> bag;
    
    /**
     * 
     * @param totalCoast
     * @param bag
     */
    public Order() {
        this.totalCost = 0;
        this.bag = new Stack<>();
    }
    /**
     * 
     * @param sushi
     */
    public void addItem(Sushi sushi) {
        this.totalCost += sushi.getCost();
        this.bag.push(sushi);
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Stack<Sushi> getBag() {
        return bag;
    }
}
