package unit03.toys;
// Dessa Shapiro

import java.util.Random;

public class Doll extends Toy{
    
    private String[] EYECOLOR = {"Blue", "Brown", "Green"};
    private String[] HAIRCOLOR = {"Yellow", "Black", "Brown", "Red"};
    private String[] SAYINGS = {"Hi", "Hello", "Im a creepy doll", "*evilness"};
    private String hairColor;
    private String eyeColor;
    private String saying;
    private int playCount;
    Random RND = new Random();
    

    /**
     * 
     * @param name
     * @param MSPR
     */
    public Doll(String name, double MSPR) {
        super(name, MSPR);
        int ran = RND.nextInt(HAIRCOLOR.length);
        int ran2 = RND.nextInt(EYECOLOR.length);
        int ran3 = RND.nextInt(SAYINGS.length);

        this.hairColor = HAIRCOLOR[ran];
        this.eyeColor = EYECOLOR[ran2];
        this.saying = SAYINGS[ran3];
        this.playCount = 0;
    }

    public String getHairColor() { return this.hairColor;}
    public String getEyeColor() { return this.eyeColor;}
    public String getSaying() { return this.saying;}
    public int getPlayCount() { return this.playCount;}


    
    @Override
    public String toString(){
        return super.name+"{" +
        "productCode=" + super.productCode +
        ", msrp=" + super.msrp +
        ", Hair Color = " + this.hairColor +
        ", Eye Color = " + this.eyeColor +
        ", Saying = " + this.saying +
        '}';
    }

    @Override
    public void play() {
        if (playCount < 10) {
            System.out.println("Doll is saying: " + this.saying);
            playCount++;
        } else {
            System.out.println("Doll cannot play. Max play count reached.");
        }
    }

}
