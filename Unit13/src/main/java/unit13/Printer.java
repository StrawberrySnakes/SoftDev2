package unit13;

public class Printer implements Runnable{
    private final String daString;

    public Printer(String daString) {
        this.daString = daString;
    }

    @Override
    public void run() {
        for (char c : this.daString.toCharArray()) {
            System.out.println(c);
        }
    }
    
}
