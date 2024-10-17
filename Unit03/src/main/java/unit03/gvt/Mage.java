package unit03.gvt;

public class Mage extends Goat{
    public static final int MAX_HP = 120;

    public Mage(String name) {
        super(name, Mage.MAX_HP);
    }

    @Override
    public Attack attack() {
        int[] hits = {9,9,9,9};
        return new Attack("Magic Missles", hits, DamageType.Magical);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.gDamageType();
        if(type == DamageType.Magical) {
            adjustment = 0.75;
        } else if (type == DamageType.Physical) {
            adjustment = 1.25;
        } 
        for (int hit: attack.getHits()) {
            super.currentHP -= (hit * adjustment);
        }
        super.currentHP = super.currentHP > 0 ? super.currentHP : 0;
    }

    // public static void main(String[] args) {
    //     Mage m1 = new Mage("Mage1");
    //     Mage m2 = new Mage("Mage2");
    //     System.out.println(m1);
    //     System.out.println(m2);
    //     Attack m1a = m1.attack();
    //     m2.takeDamage(m1a);

    // }
} 

// private final String name;
    // private final int maxHP;
    // private int currentHP;

    // public Mage(String name) {
    //     this.name = name;
    //     this.maxHP = Mage.MAX_HP;
    //     this.currentHP = maxHP;
    // }

    // public String getName() {return this.name;}

    // public boolean isConscious() {return this.currentHP > 0;}

    // public void heal(int amount) {
    //     this.currentHP += amount;
    //     // inline compact if statement, if boolean expression is true you get whats before the colin and if false whatever is after         
    //     this.currentHP = this.currentHP < this.maxHP ? this.currentHP : maxHP;
    // }

    // @Override
    // public String toString() {
    //     return "Mage: " + this.name + " Current HP: " + this.currentHP + "/" + this.maxHP;
    // }