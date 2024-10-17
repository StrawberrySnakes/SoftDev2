package finalexam.searchthread;

import java.util.concurrent.atomic.AtomicInteger;

public class SearchThread implements Runnable {

    private static AtomicInteger targetIndex = new AtomicInteger(-1);
    private int start;
    private int stop;
    private long[] longArray;
    private int targetValue;

    public SearchThread(long[] longArray, int start, int stop, int targetValue) {
        this.longArray = longArray;
        this.start = start;
        this.stop = stop;
        this.targetValue = targetValue;
    }

    @Override
    public void run() {
        for(int i = this.start; i < this.stop; i++) {
            if(this.longArray[i] == this.targetValue) {
                targetIndex.compareAndSet(-1, i);
                System.out.println("Target value " + this.targetValue + " found at " + targetIndex.get());
                break;
            }
        }
    }

    public static void main(String[] args) {
        long[] list = SearchUtils.randomArray(1000000);
        int numThreads = 4;
        Thread[] threads = new Thread[numThreads];

        int segmentSize = list.length / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * segmentSize;
            int stop = (i == numThreads - 1) ? list.length : start + segmentSize;
            threads[i] = new Thread(new SearchThread(list, start, stop, 200));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (targetIndex.get() == -1) {
            System.out.println("Target value not found");
        }
    }
}
