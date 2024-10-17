package unit02.swb;

public class Weapon {
    public String name;
    public DamageType damageType;
    public int damageAmount;
    public Boolean working;

    public Weapon(String name, DamageType damageType, int damageAmount, Boolean working) {
        this.name = name;
        this.damageType = damageType;
        this.damageAmount = damageAmount;
        this.working = working;
        
    }

    public Weapon() {
        this("NoName",DamageType.HEAVY,1,true);
    }

    public String getName() {return this.name; }

    public DamageType getDamageType() {return this.damageType;}


    @Override
    public String toString() {
        return "Weapon: {Name: "+ this.name + ", Damage Type: " + this.damageType + ", Damage Amount: "  + this.damageAmount + ", Is Working: " + this.working +"}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Weapon){
            Weapon other = (Weapon)obj;
            return this.name.equals(other.name) && this.damageType.equals(other.damageType) && this.damageAmount == other.damageAmount;
        } else {
            return false;
        }

    }


        
}


    

