package unit02.chickens;
// Dessa Shapiro

// initallizes egg 
public class Egg {
    private Color color;
    private Size size;
    private boolean cracked;

    public Egg(Color color, Size size, boolean cracked) {
        this.color = color;
        this.size = size;
        this.cracked = cracked;
    }

    public Egg() {
        this(Color.WHITE, Size.MEDIUM, false);
    }

    // createing setters and getters 
    public Color getColor() { return this.color;}
    public Size getSize() { return this.size;} 
    public Double getWeight() { return this.size.getOunces();}
    public boolean getCracked() { return this.cracked;}
    public boolean setCracked(boolean cracked) {return this.cracked = cracked;}

    // just makes it easier for the string rep
    public String getCrackedName(){ 
            if(this.cracked == true) 
                {return "cracked";}
            else {
                return "uncracked";
            }
        }

    // String representation 
    @Override 
    public String toString() {
        return "a " + getCrackedName() + " " + getSize() + "(" + getWeight()+ "oz) " + getColor() + " egg.";
    }

    // equal if has the same size, color and cracked status
    @Override 
    public boolean equals(Object obj) {
        if(obj instanceof Egg) {
            Egg other = (Egg)obj;
            return this.size == other.size && this.color.equals(other.color) && this.cracked == other.cracked;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Egg(Color.BROWN, Size.JUMBO, false));
    }
}
