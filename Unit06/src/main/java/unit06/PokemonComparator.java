package unit06;

import java.util.Comparator;

public class PokemonComparator implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon a, Pokemon b) {
        String aName = a.getName().toLowerCase();
        String bName = b.getName().toLowerCase();
        return aName.compareTo(bName);

    }
    
    
}
