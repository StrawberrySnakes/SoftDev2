package unit06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fruit implements Comparable<Fruit> {
    private final String name;
    private final double price;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
    


    @Override
    public String toString() {
        return this.name + " $ "+ this.price;
    }


    @Override
    public int compareTo(Fruit o) {
        return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {
        List<Fruit> fruit = new ArrayList<>();
        fruit.add(new Fruit("Peach", 2.25));
        fruit.add(new Fruit("Apple", 2.0));
        fruit.add(new Fruit("Mango", 3.75));
        fruit.add(new Fruit("Plum", 1.5));
        fruit.add(new Fruit("Banana", 1.0));
        fruit.add(new Fruit("Oranges", 2.75));
        System.out.println(fruit);
        Collections.sort(fruit, new FruitCompartor());
        System.out.println(fruit);


        
    }
}


