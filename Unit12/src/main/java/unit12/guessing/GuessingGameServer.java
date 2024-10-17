package unit12.guessing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The GuessingGameServer class extends Duplexer and implements the Runnable interface.
 * It acts as the server for the guessing game, handling client requests and game logic.
 */
public class GuessingGameServer extends Duplexer implements Runnable {
    GuessingGameImpl game;  // Instance of the guessing game implementation

    /**
     * Constructor to initialize the GuessingGameServer with a socket connection.
     * @param sock The socket connection to encapsulate.
     * @throws IOException If an I/O error occurs during initialization.
     */
    public GuessingGameServer(Socket sock) throws IOException {
        super(sock);   // Call the constructor of the superclass (Duplexer)
        this.game = new GuessingGameImpl();  // Initialize the guessing game implementation
    }

    /**
     * Runs the server, handling client requests and game logic.
     */
    public void run() {
        String request = "";    // Initialize the request string
        while (!request.equals("QUIT")) {   // Loop until the client sends a quit command
            request = receive();    // Receive the client request
            System.out.println("RECV: " + request);    // Print the received request
            String[] tokens = request.split(" ");   // Split the request into tokens
            String response = "";   // Initialize the response string
            switch (tokens[0]) {
                case "QUIT":
                    game.quit();    // Quit the game
                    response = "GAME_OVER"; // Set the response to indicate game over
                    break;
                case "RESTART":
                    game.restart(); // Restart the game
                    response = "RESTARTED"; // Set the response to indicate restart
                    break;
                case "GUESS":
                    GuessResult result = game.guess(Integer.parseInt(tokens[1]));  // Make a guess
                    response = result.toString();   // Convert the guess result to string
                    break;
                default:
                    response = "ERROR: Unknown Command - " + request;  // Set an error response for unknown commands
            }

            System.out.println("SEND: " + response);   // Print the response being sent
            send(response); // Send the response to the client
        }
        try {
            close();    // Close the connection with the client
        } catch (IOException e) {
            e.printStackTrace();   // Print any IO exceptions that occur during closing
        }
    }

    /**
     * Main method to start the server and listen for client connections.
     * @param args Command-line arguments (not used).
     * @throws IOException If an I/O error occurs while listening for client connections.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);   // Create a server socket on port 12345

        try {
            while (true) {  // Continuously listen for client connections
                System.out.println("Waiting for a client...");
                Socket client = server.accept();    // Accept a client connection
                GuessingGameServer gameServer = new GuessingGameServer(client);   // Create a game server for the client
                System.out.println("Starting the game...");
                new Thread(gameServer).start(); // Start a new thread to handle the game server
            }
        } catch (IOException e) {
            server.close(); // Close the server socket in case of IO exception
        }
    }
}
