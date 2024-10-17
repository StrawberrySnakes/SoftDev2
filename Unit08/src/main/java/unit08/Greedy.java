package unit08;
import java.util.*;
import unit08.knapsack.*;

public class Greedy {

    public static void packItems(Knapsack knapsack, List<Item> items) {
        // sort items by value (price ratio)
        Collections.sort(items, new PricePerPoundComparator());
        // loop thru items adding them to the knapsack
        // quit when we have examined every item
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item);
        }
    }

    public static void packItemsByValue(Knapsack knapsack, List<Item> items) {
        // sort items by value (price ratio)
        Collections.sort(items, new ValueComparator());
        // loop thru items adding them to the knapsack
        // quit when we have examined every item
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item);
        }
    }


    


    public static List<Currency> makeChange(double price, double payment) {
        List<Currency> change = new ArrayList<>();
        // 1) calc amount of change needed (pay-price)
        double difference = payment - price;
        // 2)calc dollars
        difference = countChange(difference, Currency.DOLLAR, change);
        // 3) calc quarters
        difference = countChange(difference, Currency.QUARTER, change);

        // 4) calc dimes
        difference = countChange(difference, Currency.DIME, change);

        // 5) calc nickles
        difference = countChange(difference, Currency.NICKEL, change);

        // 6) calc pennies
        difference = countChange(difference, Currency.PENNY, change);


        return change;

    }

    private static double countChange(double amount, Currency currency, List<Currency> change) {
        while (amount > currency.getValue()) {
            change.add(currency);
            amount -= currency.getValue();
        }
        return amount;
    }

    public static void main(String[] args) {
        // System.out.println(makeChange(0, 2.26));

        Knapsack knapsack = new Knapsack(10);
        packItems(knapsack, ItemSets.sportsSet());
        System.out.println(knapsack);
        knapsack.empty();
        packItemsByValue(knapsack, ItemSets.sportsSet());
        System.out.println(knapsack);
    }
}
