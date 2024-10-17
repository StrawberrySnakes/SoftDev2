package unit03.gvt;

public class Fighter extends Goat {
    public static final int MAX_HP = 150;

    public Fighter(String name) {
        super(name, Fighter.MAX_HP);
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.Physical);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.gDamageType();
        if(type == DamageType.Magical) {
            adjustment = 1.25;
        } else if (type == DamageType.Physical) {
            adjustment = 0.75;
        } 
        for (int hit: attack.getHits()) {
            this.currentHP -= (hit * adjustment);
        }
        this.currentHP = this.currentHP > 0 ? this.currentHP : 0;
    }

    // public static void main(String[] args) {
    //     Fighter f1 = new Fighter("Fighter1");
    //     Fighter f2 = new Fighter("Fighter2");
    //     System.out.println(f1);
    //     System.out.println(f2);
    //     Attack m1a = f1.attack();
    //     f2.takeDamage(m1a);

    // }
} 

// private final String name;
    // private final int maxHP;
    // private int currentHP;

    // public Fighter(String name) {
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
    //     return "Fighter: " + this.name + " Current HP: " + this.currentHP + "/" + this.maxHP;
    // }


