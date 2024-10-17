package practicum2.solarsystem;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolarSystemTest {
    @Test
    public void baseClassTests() {
        Planet earth = new Planet("Earth", 12756l, 149600000l);
        assertEquals(12756l, earth.getDiamaterKM());
        assertEquals(149600000l, earth.getOrbitKM());
        assertEquals("Earth Diamater = 12756, Orbit = 149600000", earth.toString());
    }

    @Test
    public void comparableTest() {
        List<Planet> solarSystemByName = new LinkedList<>();
        solarSystemByName.add(new Planet("Earth", 12756l, 149600000l));
        solarSystemByName.add(new Planet("Jupiter", 142984l, 778369000l));
        solarSystemByName.add(new Planet("Mars", 6794l, 227936640l));
        solarSystemByName.add(new Planet("Mercury", 4878l, 57900000l));
        solarSystemByName.add(new Planet("Neptune", 49532l, 4496976000l));
        solarSystemByName.add(new Planet("Saturn", 120536l, 1427034000l));
        solarSystemByName.add(new Planet("Uranus", 51118l, 2870658186l));
        solarSystemByName.add(new Planet("Venus", 12704l, 108160000l));
        Collections.sort(solarSystemByName);
        List<Planet> solarSystemByDiameter = new LinkedList<>();
        solarSystemByDiameter.add(new Planet("Mercury", 4878l, 57900000l));
        solarSystemByDiameter.add(new Planet("Mars", 6794l, 227936640l));
        solarSystemByDiameter.add(new Planet("Venus", 12704l, 108160000l));
        solarSystemByDiameter.add(new Planet("Earth", 12756l, 149600000l));
        solarSystemByDiameter.add(new Planet("Neptune", 49532l, 4496976000l));
        solarSystemByDiameter.add(new Planet("Uranus", 51118l, 2870658186l));
        solarSystemByDiameter.add(new Planet("Saturn", 120536l, 1427034000l));
        solarSystemByDiameter.add(new Planet("Jupiter", 142984l, 778369000l));
        for (int i = 0; i < solarSystemByName.size(); i++) {
            assertEquals(solarSystemByDiameter.get(i).getDiamaterKM(), solarSystemByName.get(i).getDiamaterKM());
        }
    }
    @Test
    public void comparatoTest() {
        List<Planet> solarSystemByName = new LinkedList<>();
        solarSystemByName.add(new Planet("Earth", 12756l, 149600000l));
        solarSystemByName.add(new Planet("Jupiter", 142984l, 778369000l));
        solarSystemByName.add(new Planet("Mars", 6794l, 227936640l));
        solarSystemByName.add(new Planet("Mercury", 4878l, 57900000l));
        solarSystemByName.add(new Planet("Neptune", 49532l, 4496976000l));
        solarSystemByName.add(new Planet("Saturn", 120536l, 1427034000l));
        solarSystemByName.add(new Planet("Uranus", 51118l, 2870658186l));
        solarSystemByName.add(new Planet("Venus", 12704l, 108160000l));
        Collections.sort(solarSystemByName, new PlanetComparator());
        List<Planet> solarSystemByOrbit = new LinkedList<>();
        solarSystemByOrbit.add(new Planet("Mercury", 4878l, 57900000l));
        solarSystemByOrbit.add(new Planet("Venus", 12704l, 108160000l));
        solarSystemByOrbit.add(new Planet("Earth", 12756l, 149600000l));
        solarSystemByOrbit.add(new Planet("Mars", 6794l, 227936640l));
        solarSystemByOrbit.add(new Planet("Jupiter", 142984l, 778369000l));
        solarSystemByOrbit.add(new Planet("Saturn", 120536l, 1427034000l));
        solarSystemByOrbit.add(new Planet("Uranus", 51118l, 2870658186l));
        solarSystemByOrbit.add(new Planet("Neptune", 49532l, 4496976000l));
        for (int i = 0; i < solarSystemByName.size(); i++) {
            assertEquals(solarSystemByOrbit.get(i).getOrbitKM(), solarSystemByName.get(i).getOrbitKM());
        }
    }   
}
