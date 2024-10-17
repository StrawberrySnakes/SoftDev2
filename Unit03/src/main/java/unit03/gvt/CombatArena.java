// an iterface is a class which only contains abstract methods
package unit03.gvt;

public class CombatArena {
    public static void battle(Combatant combatant1, Combatant combatant2) {
        System.out.println(combatant1.getName() + "battlesFM "+combatant2.getName());
        int round = 1;
        while(combatant1.isAlive() && combatant2.isAlive()) {
            System.out.println("Round: " + round);

            Attack attack1 = combatant1.attack();
            System.out.println(combatant1.getName()+ " attacks with "+attack1);
            combatant2.regenerate();
            combatant2.takeDamage(attack1);


            Attack attack2 = combatant2.attack();
            System.out.println(combatant2.getName()+ " attacks with "+attack2);
            combatant1.regenerate();
            combatant1.takeDamage(attack2);
            

            System.out.println("End of round: " + round);
            round ++;
        }

        if(combatant1.isAlive()) {
            System.out.println(combatant1.getName() + " wins!");
        } else if (combatant2.isAlive()) {
            System.out.println(combatant2.getName() + " wins!");
        } else {
            System.out.println("Both goats are dead...tie");
        }
    }

    public static void main(String[] args) {
        // Goat mage = new Mage("Magy Wadge");
        Goat fighter = new Fighter("Dirk!");
        // Goat fighter2 = new Fighter("Chuck Norris!");
        // Goat goat = new Goat("I'm a goat", 100); can no longer create a goat without a type specification since it is abstract
        // Goat wimpy = new Wimpy("Wimpy Goat.");
        Troll trollzord = new Trollzord();
        battle(fighter, trollzord);

        // battle(fighter, mage);
        // battle(fighter, fighter2);

    }
}



    // public static void battle(Fighter combatant1, Fighter combatant2) {
    //     System.out.println(combatant1.getName() + "battlesFF "+combatant2.getName());
    //     int round = 1;
    //     while(combatant1.isConscious() && combatant2.isConscious()) {
    //         System.out.println("Round: " + round);
    //         Attack attack1 = combatant1.attack();
    //         System.out.println(combatant1.getName()+ " attacks with "+attack1);
    //         combatant2.takeDamage(attack1);

    //         Attack attack2 = combatant2.attack();
    //         System.out.println(combatant2.getName()+ " attacks with "+attack2);
    //         combatant1.takeDamage(attack2);

    //         System.out.println("End of round: " + round);
    //         round ++; 

    //     }
    // }