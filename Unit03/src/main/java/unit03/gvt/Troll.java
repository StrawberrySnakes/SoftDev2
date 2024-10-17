package unit03.gvt;

public abstract class Troll extends Combatant{
    // protected final String name;
    // protected final int maxHP;
    // protected int currentHP;
    protected final double regenAmount;

    public Troll(String name, int maxHP, double regenAmount) {
        super(name, maxHP, CombatantType.TROLL);
        this.regenAmount = regenAmount;
        // this.name = name;
        // this.maxHP = maxHP; 
        // this.currentHP = maxHP;
        // this.regenAmount = regenAmount;
    }

    // public String getName() {return this.name;}

    // public boolean isVanquished() {return this.currentHP<=0;}

    public void regenerate() {
        if(!isAlive()) {
            this.currentHP += (int)(this.maxHP * regenAmount);
            this.currentHP = this.currentHP < this.maxHP ? this.currentHP : maxHP;

        }
    }

    // @Override
    // public String toString() {
    //     return "Troll: " + this.name + " Current HP: " + this.currentHP + "/" + this.maxHP;
    // }

    // public abstract Attack attack();


    // public abstract void takeDamage(Attack attack);

}
