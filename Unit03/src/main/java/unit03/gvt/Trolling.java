package unit03.gvt;

public class Trolling extends Troll {

    public static final String TROOLZORD_NAME = "Trolling";
    public static final int MAX_HP = 38;
    public static final double REGEN_AMOUNT = 0.03;
 
    public Trolling() {
        super(Trolling.TROOLZORD_NAME, Trolling.MAX_HP, Trolling.REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("U Mad", hits, DamageType.Physical);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.gDamageType();
        if(type == DamageType.Magical) {
            adjustment = 1.25;
        }
        for (int hit: attack.getHits()) {
            super.currentHP -= (hit * adjustment);
        }
        super.currentHP = super.currentHP > 0 ? super.currentHP : 0;
    }

    public static void main(String[] args) {
        Troll trolling1 = new Trolling();
        Troll trolling2 = new Trolling();
        System.out.println(trolling1);
        System.out.println(trolling2);
        Attack t1a = trolling1.attack();
        trolling2.takeDamage(t1a);
        System.out.println(trolling2);
        trolling2.regenerate();
        System.out.println(trolling2);

    }
    
}

