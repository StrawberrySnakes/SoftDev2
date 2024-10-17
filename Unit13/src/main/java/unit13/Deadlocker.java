package unit13;

public class Deadlocker implements Runnable{
    private final String name;
    private final Object lockOne;
    private final Object lockTwo;

    public Deadlocker(String name, Object lockOne, Object lockTwo) {
        this.name = name;
        this.lockOne = lockOne;
        this.lockTwo = lockTwo;
    }

    @Override
    public void run() {
        int count = 0;
        while(true) {
            System.out.println("Looped " + count++);
            System.out.println(this.name +" getting lock on " +this.lockOne);
            synchronized(lockOne){
                System.out.println(this.name +" got lock, getting " +this.lockTwo);
                synchronized(lockTwo) {
                    System.out.println(this.name +" got both locks releasing " + this.lockTwo);
                }
                System.out.println(this.name + " releasing " + lockOne);
            }
        }
    }

    public static void main(String[] args) {
        String lockA = "A";
        String lockB = "B";
        new Thread(new Deadlocker("DL1", lockA, lockB)).start();
        new Thread(new Deadlocker("DL2", lockB, lockA)).start();



    }

}
