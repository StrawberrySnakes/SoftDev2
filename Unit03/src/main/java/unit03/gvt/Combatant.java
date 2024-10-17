package unit03.gvt;

public abstract class Combatant implements Combat{
    public static int ID = 1000;
    protected final String name;
    protected final int maxHP;
    protected int currentHP;
    protected int id;
    protected CombatantType type;

    public Combatant(String name, int maxHP, CombatantType type) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.type = type;
        this.id = Combatant.ID++;
    }

    public String getName() {return this.name;}

    @Override
    public boolean isAlive() {return this.currentHP > 0;}
    
    @Override
    public String toString() {
        return this.type +": " + this.name + "(id:" + this.id + ")"+" Current HP: " + this.currentHP + "/" + this.maxHP;
    }
}
