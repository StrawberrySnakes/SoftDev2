package unit13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sleeper implements Runnable{
    private int seconds;

    public Sleeper(int secs) {
        this.seconds = secs;
    }

    @Override
    public void run() {
        System.out.println("Sleeping for: "+this.seconds);
        try {
            Thread.sleep(this.seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("I'm awake " + this.seconds);
    }

    public static void main(String[] args) throws InterruptedException {
        Random RNG = new Random(1);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i< 5; i++) {
            int time = RNG.nextInt(6) +1;
            Sleeper sleeper = new Sleeper(time);
            Thread thread = new Thread(sleeper);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Main Done!");
        }
        
}
    

