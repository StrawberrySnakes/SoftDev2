package unit02.swb;

import java.util.Arrays;

public class SWBG {

    // Constant
    public static final String BLASTER = "Blaster";
    public static final String CRUISER = "Cruiser";


    public static final boolean WORKING = true;


    public static void main(String[] args) {
        Weapon w1 = new Weapon(BLASTER, DamageType.ION, 5, WORKING);
        Weapon w3 = new Weapon(BLASTER, DamageType.ION, 5, WORKING);

        System.out.println(w1);
        System.out.println(w1.getName());
        System.out.println(w1.getDamageType());
        System.out.println(w1.getDamageType().getColor());

        // System.out.println(w1.damageAmount);
        // System.out.println(w1.working);

        


        Weapon w2 = new Weapon("Blaster2.0", DamageType.NORMAL, 10, WORKING);
        System.out.println(w2);
        System.out.println(w2.getName());
        System.out.println(w2.getDamageType());
        // System.out.println(w1.damageAmount);
        // System.out.println(w1.working);

        // Shallow
        System.out.println(w1 == w2);
        System.out.println(w1 == w3);
        System.out.println(w2 == w3);

        // Deep
        System.out.println(w1.equals(w2));
        System.out.println(w2.equals(w3));
        System.out.println(w1.equals(w3));

        Ship s1 = new Ship("R2Flyer", 1000, 500);
        System.out.println(s1);
        System.out.println(s1.getName());
        // System.out.println(s1.hullRating);
        // System.out.println(s1.hullRating);

        Ship s2 = new Ship("Hunk", 500, 1000);
            // s2.setName("TonyShip");
            System.out.println(s2);
            System.out.println(s2.getName());
            // System.out.println(s2.hullRating);
            // System.out.println(s2.hullRating);

        
            System.out.println(s1 == s2);
            System.out.println(s1.equals(s2));

            
            System.out.println(DamageType.NORMAL.toString());
            System.out.println(DamageType.HEAVY.toString());
            System.out.println(DamageType.ION.toString());
            System.out.println(DamageType.valueOf("NORMAL"));
            System.out.println(DamageType.valueOf("HEAVY"));
            System.out.println(DamageType.valueOf("ION"));
            DamageType[] damageTypeValues = DamageType.values();
            System.out.println(Arrays.toString(damageTypeValues));


    }
    
}
