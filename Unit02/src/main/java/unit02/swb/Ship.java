package unit02.swb;

public class Ship {
    public String name;
    public int hullRating;
    public int shieldAmount;

    public Ship(String name, int hullRating, int shieldAmount) {
        this.name = name;
        this.hullRating = hullRating;
        this.shieldAmount = shieldAmount;}

    public Ship() {
        this("NoName", 0, 0);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Ship: {Name: "+ this.name + ", Hull Rating: " + this.hullRating + ", Sheild Amount: "  + this.shieldAmount +"}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ship){
            Ship other = (Ship)obj;
            return this.name.equals(other.name) && this.hullRating == (other.hullRating) && this.shieldAmount == other.shieldAmount;
        } else {
            return false;
        }
    }
}


