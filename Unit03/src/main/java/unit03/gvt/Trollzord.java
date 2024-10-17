package unit03.gvt;

public class Trollzord extends Troll {

    public static final String TROOLZORD_NAME = "Trollzord";
    public static final int MAX_HP = 64;
    public static final double REGEN_AMOUNT = 0.05;

    public Trollzord() {
        super(Trollzord.TROOLZORD_NAME, Trollzord.MAX_HP, Trollzord.REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Flame War", hits, DamageType.Magical);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.gDamageType();
        if(type == DamageType.Holy) {
            adjustment = 1.25;
        }
        for (int hit: attack.getHits()) {
            super.currentHP -= (hit * adjustment);
        }
        super.currentHP = super.currentHP > 0 ? super.currentHP : 0;
    }

    public static void main(String[] args) {
        Troll trollzord1 = new Trollzord();
        Troll trollzord2 = new Trollzord();
        System.out.println(trollzord1);
        System.out.println(trollzord2);
        Attack t1a = trollzord1.attack();
        trollzord2.takeDamage(t1a);
        System.out.println(trollzord2);
        trollzord2.regenerate();
        System.out.println(trollzord2);

    }
    
}
