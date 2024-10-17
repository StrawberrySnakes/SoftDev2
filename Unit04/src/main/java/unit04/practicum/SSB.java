// Dessa Shapiro
package unit04.practicum;

public class SSB {
    public static void main(String[] args) {
        Fighter fighter1 = new Lonk();
        Fighter fighter2 = new Manio();
        while (fighter1.isAlive() && fighter2.isAlive()) {
            int damage1 = fighter1.dealDamage();
            fighter2.takeDamage(damage1);

            int damage2 = fighter2.dealDamage();
            fighter1.takeDamage(damage2);

        }

        if (!fighter1.isAlive() && !fighter2.isAlive()) {
            System.out.println("It's a draw.");
        } else if (!fighter1.isAlive()) {
            System.out.println(fighter2.getName() + " wins!");
        } else {
            System.out.println(fighter1.getName() + " wins!");
        }
        }
        
    }

