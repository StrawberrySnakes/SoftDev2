package unit03.gvt;

import java.util.Arrays;

public class Attack {
    private final String name;
    private final int[] hits;
    private final DamageType type;

    public Attack(String name, int[] hits, DamageType type) {
        this.name = name;
        this.hits = hits;
        this.type = type;
    }

    public DamageType gDamageType() {return this.type;} 
    public String getName() {return this.name;}
    public int[] getHits() { return this.hits;}


    @Override
    public String toString() {
        return this.name + " hit for " + Arrays.toString(this.hits) + type + "damage";
    }
}
