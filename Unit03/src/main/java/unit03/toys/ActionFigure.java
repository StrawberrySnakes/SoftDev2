package unit03.toys;
// Dessa Shapiro

import java.util.Random;


public class ActionFigure extends Toy {
    private String[] HAIRCOLOR = {"red", "blue", "yellow"};
    private String[] EYECOLOR = {"black", "brown", "red"};
    private String[] SAYINGS = {"Hi", "Hello", "CHOP", "CHOP2.0"};
    private boolean kungFuGrip;
    private String hairColor;
    private String eyeColor;
    private String saying;
    Random RND = new Random();


    /**
     * 
     * @param name
     * @param msrp
     */
    public ActionFigure(String name, double msrp) {
        super(name, msrp);
        int ran = RND.nextInt(HAIRCOLOR.length);
        int ran2 = RND.nextInt(EYECOLOR.length);
        int ran3 = RND.nextInt(SAYINGS.length);
        int ran4 = RND.nextInt(2);
        this.hairColor = HAIRCOLOR[ran];
        this.eyeColor = EYECOLOR[ran2];
        this.saying = SAYINGS[ran3];
        if (ran4 == 0) {
            this.kungFuGrip = true;
        } else {
         this.kungFuGrip = false; }
    }

    public String getHairColor() { return this.hairColor;}
    public String getEyeColor() { return this.eyeColor;}
    public String getSaying() { return this.saying;}
    public boolean getKungFu() { return this.kungFuGrip;}


    @Override
    public String toString(){
        return super.name +": Hair Color: " +this.hairColor +" Eye Color: " +this.eyeColor + "Has Kung-Fu Grip: "+this.kungFuGrip+ " Says: "+this.saying;
    }

    @Override 
    public void play() {
        // play here
        if (!kungFuGrip) {
            System.out.println("ActionFigure is playing action phrase: "+ this.saying);
        } else {
                System.out.println("ActionFigure is brandishing a sword with Kung-Fu Grip, while saying: "+ this.saying);
        }
    }
    
}
    
