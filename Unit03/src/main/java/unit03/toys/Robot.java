package unit03.toys;
// Dessa Shapiro

import java.util.Random;

public class Robot extends Toy {
    private int charge;
    public static String[] SAYINGS = {"BANG", "SWOOSH", "BAM", "SLASH"};
    private String saying;
    Random RND = new Random();

 
    /**
     * 
     * @param name
     * @param msrp
     */
    public Robot(String name, double msrp) {
        super(name, msrp); 
        int ran = RND.nextInt(SAYINGS.length);
        this.charge = 0;
        this.saying = SAYINGS[ran];
    }

    // getters
    public String getSaying() { return this.saying;}
    public int getCharage() {return this.charge;}

    // Charge robot to 100
    public void chargeRobot() {
        this.charge = 100;
    }

    @Override
    public String toString(){
        return super.name+"{" +
        "productCode ="  + super.productCode +
        ", msrp = " + super.msrp +
        ", Saying = " + this.saying +
        '}';
    }

    // robot play
    @Override
    public void play() {
        if (this.charge > 0) {
            this.charge -= 20;
            if (this.charge < 0) {
                this.charge = 0;
            }
            System.out.println("Robot walks around in circles saying: "+this.saying+". The Robot now has: "+this.charge+"% charge");
        } else {
            System.out.println("The Robot has no charge and cannot play");
        }
    }
    
}
