// Dessa Shapiro
package unit06.Sushi;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Shop {

    /**
     * 
     * @return
     */
    private static Set<Integer> createDisplay() {
        Set<Integer> displayItems = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            displayItems.add(i);
        }
        return displayItems;
    }

    /**
     * 
     * @param displayItems
     * @return
     */
    private static Set<Integer> takeOrder(Set<Integer> displayItems) {
        Random random = new Random();
    
        // Simulate customer picking between 3 and 8 items
        Set<Integer> customerOrder = new HashSet<>();
        int numItems = random.nextInt(6) + 3;
    
        System.out.print("The cashier takes your order:");
    
        for (int i = 0; i < numItems; i++) {
            int randomItem = random.nextInt(25);
            if (displayItems.contains(randomItem)) {
                customerOrder.add(randomItem);
                System.out.print(" " + randomItem);
            }
        }
        System.out.println(" ");
        return customerOrder;
    }

    /**
     * 
     * @param displayItems
     * @param customerOrder
     * @return
     */
    private static Order makeOrder(Set<Integer> displayItems, Set<Integer> customerOrder) {
        Order order = new Order();
        for (int item : customerOrder) {
            displayItems.remove(item);
            Sushi sushi = new Sushi(item);
            order.addItem(sushi);
        }
        System.out.println("The cashier prepares your order.");
        System.out.println("That will be $" + order.getTotalCost() + ".");
        System.out.println("Here is your order, please come again.");
        return order;
    }

    /**
     * 
     * @param order
     */
    private static void displayOrder(Order order) {
        // Display the order details
        Stack<Sushi> items = order.getBag();
        while (!items.isEmpty()) {
            Sushi sushi = items.pop();
            System.out.println("Eating " + sushi + " ... yum!");
        }
    }

    /**
     * 
     * @param order
     */
    private static void eat(Order order) {
        System.out.println("Back at your apartment, you take out your sushi and eat it ...");
        displayOrder(order);
    }
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Shinjis Sushi Shop!");

        // Create the display
        Set<Integer> displayItems = createDisplay();

        //customer orders
        Set<Integer> customerOrder = takeOrder(displayItems);

        // make and display the order
        Order order = makeOrder(displayItems, customerOrder);
        // displayOrder(order);

        //eating the sushi
        eat(order);
    }
}
