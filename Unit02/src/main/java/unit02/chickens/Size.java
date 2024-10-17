package unit02.chickens;
// Dessa Shapiro

// Creating enum for egg sizes
public enum Size {
    PEEWEE(1.25),
    SMALL(1.5),
    MEDIUM(1.75),
    LARGE(2.0),
    EXTRA_LARGE(2.25),
    JUMBO(2.5);

    // making the ounces acessable 
    private final double ounces;
    private Size(double ounces){
        this.ounces = ounces;
    }

    public double getOunces(){
        return ounces;
    }
    
}
