// Dessa Shapiro
package unit11.ggg;

import java.util.Random;

public class TurnipDropper extends Thread{
    private Trough trough;
    private Random random;

    public TurnipDropper(Trough trough) {
        this.trough = trough;
        this.random = new Random();
    
    }

    public Trough getTrough() {
        return this.trough;
    }

    @Override
    public void run() {
        while (!trough.atLimit()) {
            try {
                Thread.sleep(random.nextInt(251)); // Sleep for up to 250 milliseconds
                synchronized (trough) {
                    if (!trough.atLimit()) {
                        trough.drop(); // Drop a turnip into the trough
                        trough.notifyAll(); // Notify waiting goats
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


 

