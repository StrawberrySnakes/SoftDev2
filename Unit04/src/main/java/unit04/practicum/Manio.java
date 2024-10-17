// Dessa Shapiro
package unit04.practicum;

import java.util.Random;

public class Manio implements Fighter {
    public static final String NAME = "Manio";
    private int hp;
    Random RAN = new Random();


    public int getHp() {return this.hp;}
    public Manio() {
        this.hp = 100;
    }

    @Override
    public int dealDamage() {
        int ran = RAN.nextInt(26);
        System.out.println(NAME+" attacks with a jump attack with "+(25+ran)+" damage.");
        return 25 + ran;
    }

    @Override
    public void takeDamage(int damage) {
        int ran = RAN.nextInt(4);
        if (ran != 0) {
            System.out.println(NAME+" takes "+damage+" damage.");
            this.hp -= damage;
        } else {
            System.out.println(NAME+" dodges and takes 0 damage.");
        }
    }
    @Override
    public boolean isAlive() {
        return this.hp > 0;
    
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getHealth() {
        return this.hp;
    }
    
}
