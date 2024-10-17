package unit05.hilo.model;

import java.util.Random;

public class HiLo {

    public static final int MAX_TRIES = 7; 
    private final int secret;
    private static final Random random = new Random(1);
    private String hint;
    private int availableGuesses;
    private boolean gameOver;

    // important
    private HiLoObserver observer;
    public HiLo(){
        this.secret = random.nextInt(100)+1;
        this.hint = null;
        this.availableGuesses = MAX_TRIES;
        this.gameOver = false;
        this.observer = null;
    }

    // Important
    private void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
    }

    // Important
    public void register(HiLoObserver observer) {
        this.observer = observer;
    }

    public String getHint(){
        return hint;
    }
    public int getAvailableGuesses(){
        return availableGuesses;
    }
    public boolean isGameOver(){
        return gameOver;
    }
    
    public void makeGuess(int guess){
        if(availableGuesses > 0){
            if(guess == secret){
                this.hint = guess + " is correct. You won!";
                this.gameOver = true;
            }
            else{
                if(availableGuesses == 1){
                    this.hint = "You lost! The secret number was " + secret; 
                    this.gameOver = true;
                }
                else if(guess > secret) {
                    this.hint = guess + " is too high!";
                }
                else{
                    this.hint = guess + " is too low!";
                }
            }  
        }
        else{
            this.gameOver = true;
        }
        availableGuesses--;

        // important
        notifyObserver();
    }
}

// Make an observer. register it.
// update it, call update whenever necessary.
// That's your four-step process for the observer path. Okay, make an observer, register the observer.
// update the observer when necessary, call the update to when things change
// alright.
