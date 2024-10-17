package unit02.chickens;
// Dessa Shapiro

import java.util.Random;

// initalized chcken
public class Chicken {
    private String name;
    private final Color color;
    private final Size size;
    private static final Random RNG = new Random();
    public boolean cracked;


    public Chicken(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
    // defult chicken
    public Chicken( ) {
        this("NoName", Color.BROWN, Size.LARGE);
    }
    
    // acessors
    public String getName() { return this.name;}
    public Color getColor() { return this.color;}
    public Size getSize() {return this.size;}
    
    // Gives a 50% chance a egg is cracked
    public boolean isCracked() {
        int num = RNG.nextInt(2);
        if(num==0) {
            return true;
        } else {
            return false;
        }
    }

    // Creates a random chicken
    public static Chicken randomChicken() {
        String[] names = {"Marry Beth", "The Chicken King", "Todd", "Guy McChicken", "Pogo Stick", "Duck", "Chillckin", "Princess", "Chicken Little", "Sally"};
        String name;  
        Color color;
        Size size;

        int nameNum = RNG.nextInt(10);
        name = names[nameNum];

        int colorNum = RNG.nextInt(2);
        if (colorNum == 0) {color=Color.BROWN;}
        else {color=Color.WHITE;}

        Size[] sizes = Size.values();
        size =sizes[RNG.nextInt(sizes.length)];

        return new Chicken(name, color, size);

    }

    // creates a string 
    @Override
    public String toString() {
        return getName() + ", a chicken that lays " + getSize() + " " + getColor() + " eggs";
    }

    // chickens are equal when egg size is equal
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Chicken) {
            Chicken other = (Chicken) obj;
            return this.size.equals(other.size);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(randomChicken());
    }

}




