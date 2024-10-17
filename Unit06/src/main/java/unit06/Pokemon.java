package unit06;

import java.util.Collections;
import java.util.LinkedList;

public class Pokemon implements Comparable<Pokemon> {
    
    private final String name;
    private final int number;

    public Pokemon(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return this.number + " " + this.name;
    }


    @Override
    public int compareTo(Pokemon o) {
        return this.number - o.number;
    }


    public static void main(String[] args) {
        LinkedList<Pokemon> pokeList = new LinkedList<>();
        pokeList.add(new Pokemon("A", 3));
        pokeList.add(new Pokemon("C", 2));
        pokeList.add(new Pokemon("B", 1));

        System.out.println(pokeList);
        Collections.sort(pokeList);
        System.out.println(pokeList);
    }
    
}
