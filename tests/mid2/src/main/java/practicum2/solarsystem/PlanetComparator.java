package practicum2.solarsystem;

import java.util.Comparator;

/**
 * Implement the class below so planets are ordered by their orbit distance
 */

public class PlanetComparator implements Comparator<Planet>{

    @Override
    public int compare(Planet o1, Planet o2) {
        int c = (int)o1.getOrbitKM();

        int d = (int)o1.getOrbitKM();
        return c-d;
        
        
    }
    
}
