// Dessa Shapiro
package unit04.practicum;

import java.util.Random;

public class Lonk implements Fighter {
    private static final String NAME = "Lonk";
    private int hp;
    Random RAN = new Random();

    public int getHp() {return this.hp;}

    public Lonk() {
        this.hp = 150;
    }

    @Override
    public int dealDamage() {
        System.out.println(NAME+" attacks with sword with 45 damage");

        return 45;
    }

    @Override
    public void takeDamage(int damage) {
        int ran = RAN.nextInt(2);
        if (ran == 0) {
            System.out.println(NAME+" takes "+damage/2+" damage.");
            this.hp -= Math.round(damage/2);
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
