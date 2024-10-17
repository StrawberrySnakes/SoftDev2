package unit03.gvt;

public class Wimpy extends Goat {
    public static final int MAX_HP = 50;

    public Wimpy(String name) {
        super(name, Wimpy.MAX_HP);
    }

    @Override
    public Attack attack() {
        int[] hits = {5};
        return new Attack("Poke in the eye", hits, DamageType.Physical);
    }

    @Override
    public void takeDamage(Attack attack) {

        for (@SuppressWarnings("unused") int hit: attack.getHits()) {
            super.currentHP -= 1;
        }
        super.currentHP = super.currentHP > 0 ? super.currentHP : 0;
    }
    
}
