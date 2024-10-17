// Dessa Shapiro
package unit13.hangman;

import unit13.backtracker.Backtracker;
import unit13.backtracker.Configuration;

import java.util.*;

/**
 * a class to create a Hangman Solver
 */
public class Solver implements Configuration<Solver> {
    private static final char BLANK = '_';
    private final String secret;
    private final Set<Character> guesses;
    private final StringBuilder revealed;
    private final int wrongGuesses;
    private final Hangman.Status status;

    /**
     * 
     * @param secret
     * @param guesses
     * @param revealed
     * @param wrongGuesses
     * @param status
     */
    public Solver(String secret, Set<Character> guesses, StringBuilder revealed, int wrongGuesses, Hangman.Status status) {
        this.secret = secret;
        this.guesses = guesses;
        this.revealed = revealed;
        this.wrongGuesses = wrongGuesses;
        this.status = status;
    }

    /**
     * 
     * @param secret
     */
    public Solver(String secret) {
        this.secret = secret;
        this.guesses = new HashSet<>();
        this.revealed = new StringBuilder();
        for (char c : secret.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                revealed.append(BLANK);
            } else {
                revealed.append(c);
            }
        }
        this.wrongGuesses = 0;
        this.status = Hangman.Status.IN_PROGRESS;
    }

    /**
     * 
     * @param c
     * @return
     */
    public boolean guess(char c) {
        char uc = Character.toUpperCase(c);
        if (status != Hangman.Status.IN_PROGRESS || guesses.contains(uc)) {
            return false;
        } else {
            guesses.add(uc);

            int count = 0;
            for (int i = 0; i < secret.length(); i++) {
                char s = secret.charAt(i);
                char us = Character.toUpperCase(s);
                if (us == uc) {
                    count++;
                    revealed.setCharAt(i, s);
                }
            }

            Solver newConfiguration = new Solver(secret, guesses, revealed, count > 0 ? wrongGuesses : wrongGuesses + 1, getStatus());

            if (newConfiguration.getStatus() == Hangman.Status.LOST || newConfiguration.getStatus() == Hangman.Status.WON) {
                return true;
            }

            return false;
        }
    }

    @Override
    public Collection<Solver> getSuccessors() {
        List<Solver> successors = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!guesses.contains(c)) {
                Solver successor = new Solver(secret, new HashSet<>(guesses), new StringBuilder(revealed), wrongGuesses, status);
                if (successor.guess(c)) {
                    successors.add(successor);
                }
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        return this.status == Hangman.Status.IN_PROGRESS;
    }

    @Override
    public boolean isGoal() {
        return this.status == Hangman.Status.WON;
    }

    @Override
    public String toString() {
        return getGuesses() + ", " + revealed();
    }

    /**
     * 
     * @return
     */
    public String getGuesses() {
        StringBuilder guessesString = new StringBuilder();
        for (char c : guesses) {
            guessesString.append(c).append(" ");
        }
        return guessesString.toString().trim();
    }

    public Hangman.Status getStatus() {
        return status;
    }

    public String revealed() {
        return revealed.toString();
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a secret phrase: ");
        String secret = scanner.nextLine().toUpperCase();
    
        Solver initialConfiguration = new Solver(secret);
    
        Backtracker<Solver> backtracker = new Backtracker<>(false);
        Solver solution = backtracker.solve(initialConfiguration);
    
        if (solution != null) {
            System.out.println("Solution found: " + solution.toString());
        } else {
            System.out.println("No solution found.");
        }
    
        scanner.close();
    }
}
