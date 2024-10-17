package practicum2.solarsystem;

/**
 * Implement the class below according to the associated UML diagram
 * The base class should order planets by their diamater
 */

public class Planet implements Comparable<Planet>{
    private String name;
    private long diamaterKM;
    private long orbitKM;

    public Planet(String name, long diamaterKM, long orbitKM){
        this.name = name;
        this.diamaterKM = diamaterKM;
        this.orbitKM = orbitKM;

    }

    public long getDiamaterKM() {
        return this.diamaterKM;
    }

    public long getOrbitKM() {
        return this.orbitKM;
    }

    @Override
    public int compareTo(Planet o) {
        int a = (int)this.diamaterKM;
        int b = (int)o.diamaterKM;
        return a-b;
    }

}
