package unit11.chevre;

/** 
 * A class that will ultimately represent a party Goat out for a night of
 * dancing at the world famous Club Chèvre.
 */
public class Goat implements Runnable {
    private static final int MIN_STAMINA = 5;
    private static final int MAX_STAMINA = 10;
    private final ClubChevre club;
    private final String name; 
    private final int stamina;

    public Goat(ClubChevre club) {
        this.club = club;
        this.name = Utils.makeGoatName();
        this.stamina = Utils.getRandomNumber(MIN_STAMINA, MAX_STAMINA);
    }

    public String getName() {
        return this.name;
    }

    

    @Override
    public void run() {
        synchronized(club) {
            System.out.println(this.name + " get into line behind " + (club.numberOfGoatsInLine()) + " other goats");
            club.getInLine(this);
            this.club.notify();
        }
        synchronized(this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(this.name + " enters club");
        for(int i = 0; i < this.stamina; i ++) {
            System.out.println(this.name + " is dancing!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(this.name + " is tired and heads home.");
        synchronized(club) {
        this.club.stopDancing(this);
        this.club.notify();
        }
    }

    public static void main(String[] args) {
        ClubChevre club = new ClubChevre();
        Goat goat = new Goat(club);
        Thread thread = new Thread(goat);
        thread.start();
    }
}
