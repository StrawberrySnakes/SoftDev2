package unit12.guessing;

import java.io.*;
import java.net.*;

/**
 * The GuessingGameProxy class extends Duplexer and implements the GuessingGame interface.
 * It acts as a proxy between the client and the server for the guessing game.
 */
public class GuessingGameProxy extends Duplexer implements GuessingGame {

    /**
     * Constructor to initialize the GuessingGameProxy with a socket connection.
     * @param sock The socket connection to encapsulate.
     * @throws IOException If an I/O error occurs during initialization.
     */
    public GuessingGameProxy(Socket sock) throws IOException {
        super(sock);    // Call the constructor of the superclass (Duplexer)
    }

    /**
     * Restarts the guessing game by sending a restart command to the server.
     * Waits for the server response to confirm restart.
     */
    @Override
    public void restart() {
        send("RESTART");                // Send the restart command to the server
        String response = receive();    // Receive the response from the server
        if (!response.equals("RESTARTED")) {
            System.out.println("Server did not restart");    // Print a message if server did not restart
        }
    }

    /**
     * Sends a guess to the server and receives the result.
     * @param number The guessed number.
     * @return The result of the guess.
     */
    @Override
    public GuessResult guess(int number) {
        send("GUESS " + number);            // Send the guess command with the guessed number to the server
        String response = receive();        // Receive the response from the server
        return GuessResult.valueOf(response);  // Convert the response to a GuessResult enum and return
    }

    /**
     * Quits the game by sending a quit command to the server and closing the connection.
     */
    @Override
    public void quit() {
        send("QUIT");       // Send the quit command to the server
        receive();          // Receive the response from the server
        try {
            close();        // Close the connection
        } catch (IOException e) {
            e.printStackTrace();   // Print any IO exceptions that occur during closing
        }
    }
}
