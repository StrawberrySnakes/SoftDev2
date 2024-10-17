package unit06;

import java.util.Comparator;

public class AlphabeticComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        return a.compareToIgnoreCase(b);
    }

    
    
}
