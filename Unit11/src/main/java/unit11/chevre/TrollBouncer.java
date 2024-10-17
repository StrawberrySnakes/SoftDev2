package unit11.chevre;

public class TrollBouncer implements Runnable{
    private final ClubChevre club;

    public TrollBouncer(ClubChevre club) {
        this.club = club;
    }

    @Override
    public void run() {
        synchronized(club) {
            while(this.club.numberOfGoatsInLine() > 0 || this.club.numberOfDancingGoats() > 0) {
                while(!this.club.isAtCapacity() && this.club.numberOfGoatsInLine() > 0) {
                    Goat goat = this.club.getGoatAtPosition(0);
                    this.club.removeGoatFromLine(goat);
                    this.club.startDancing(goat);
                    System.out.println("The troll bouncer lets " + goat.getName() + " into the club. There are now "
                    + this.club.numberOfDancingGoats()+" goats on the dance floor.");
                    synchronized(goat) {
                        goat.notify();
                    }
                }
                try {
                    this.club.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        }
        System.out.println("End of Simulation");
    }
    
}
