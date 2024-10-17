package unit11.chevre;

public class Main {
    public static void main(String[] args) {
        ClubChevre club = new ClubChevre();

        for(int i = 0; i < 100; i++){
            Goat goat = new Goat(club);
            Thread thread = new Thread(goat);
            thread.start();
        }

        TrollBouncer bouncer = new TrollBouncer(club);
        Thread trollTread = new Thread(bouncer);
        trollTread.start();;
    }
}
