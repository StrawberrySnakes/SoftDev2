package finalexam.deli;

public class Customer implements Runnable {

    private final char initial;
    private final TicketDispenser dispenser;

    public Customer(char initial, TicketDispenser dispenser) {
        this.initial = initial;
        this.dispenser = dispenser;
    }

    @Override
    public void run() {
        int ticketNumber = dispenser.getTicket();
        System.out.println("Customer " + initial + " gets ticket " + ticketNumber);

        int decisionTime = (int) (Math.random() * 400) + 100;
        try {
            Thread.sleep(decisionTime);
        } catch (InterruptedException e) {
            System.out.println("Customer " + initial + " interrupted while deciding");
        }

        while (dispenser.nowServing() != ticketNumber) {
            System.out.println("Customer " + initial + " is waiting with Now Serving number " + dispenser.nowServing());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Customer " + initial + " interrupted while waiting");
            }
        }

        System.out.println("Customer " + initial + " with ticket " + ticketNumber + " now being served");
        dispenser.served();
    }
}
