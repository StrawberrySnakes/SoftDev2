// Dessa Shapiro
package unit06;

/**
 * creates a Generic Pokedex 
 */
public class Pokedex<E extends Comparable<E>> extends NodeBST<E> {
    private BinarySearchTree<E> bst;

    public Pokedex() {
        this.bst = new NodeBST<E>();
    }

    /**
     * 
     * @param value
     */
    public void addPokemon(E value) {
        bst.insert(value);
    }

    /**
     * 
     * @param value
     * @return
     */
    public boolean containsPokemon(E value) {
        return this.bst.search(value);
    }

    @Override
    public String toString() {
        return this.bst.toString();
    }

    // Main method 
    public static void main(String[] args) {
        // testing when integer
        Pokedex<Integer> pokedex = new Pokedex<>();
        pokedex.addPokemon(4);
        pokedex.addPokemon(129);
        pokedex.addPokemon(36);
        pokedex.addPokemon(132);
        pokedex.addPokemon(1);
        pokedex.addPokemon(50);
        System.out.println(pokedex.containsPokemon(4));
        System.out.println(pokedex.containsPokemon(5));
        System.out.println(pokedex);

        // testing when string
        Pokedex<String> pokedex2 = new Pokedex<>();
        pokedex2.addPokemon("a");
        pokedex2.addPokemon("c");
        pokedex2.addPokemon("d");
        pokedex2.addPokemon("f");
        System.out.println(pokedex2.containsPokemon("d"));
        System.out.println(pokedex2.containsPokemon("c"));
        System.out.println(pokedex2);


    }
}
