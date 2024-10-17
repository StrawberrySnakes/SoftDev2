package unit13;

import java.util.ArrayList;
import java.util.*;

public class Incrementor {
    private int count;

    public int getCount() {return count;}

    public void increment() { count ++;}

    public static void main(String[] args) throws InterruptedException {
        int numToInc = 100000;
        Incrementor counter = new Incrementor();

        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i<10; i++) {
            Thread thread = new Thread(() -> {
                for(int n = 0; n<numToInc; n++) {
                    synchronized(counter) {
                        counter.increment();
                    }
                }
            });
            thread.start();
            threads.add(thread);

        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter.getCount());
 
    }
}
