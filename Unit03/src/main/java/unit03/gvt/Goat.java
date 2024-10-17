package unit03.gvt;

public abstract class Goat extends Combatant{
    // protected static final int MAX_HP = 120;
    // protected final String name;
    // protected final int maxHP;
    // protected int currentHP;

    public Goat(String name, int maxHP) {
        super(name, maxHP, CombatantType.GOAT);
    }

    @Override
    public void regenerate() {}
 
    // public String getName() {return this.name;}
    // public boolean isConscious() {return this.currentHP > 0;}

    // Dont need a overide since this is a concrete method that is only used in the goat class
    public void heal(int amount) {
        this.currentHP += amount;
        // inline compact if statement, if boolean expression is true you get whats before the colin and if false whatever is after         
        this.currentHP = this.currentHP < this.maxHP ? this.currentHP : maxHP;
    }

    // @Override
    // public String toString() {
    //     return "Goat: " + this.name + " Current HP: " + this.currentHP + "/" + this.maxHP;
    // }

    // public abstract Attack attack();


    // public abstract void takeDamage(Attack attack);

}



