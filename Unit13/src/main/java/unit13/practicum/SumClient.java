package unit13.practicum;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * The SumClient class represents a client application that communicates with the SumServer to perform summation tasks.
 */
public class SumClient {
    private Duplexer duplexer;  // Handles communication with the server
    private Scanner userIn;     // Scanner for user input

    /**
     * Constructor to initialize the SumClient with a connection to the server.
     * @param port The port number to connect to.
     * @throws IOException If an I/O error occurs during initialization.
     */
    public SumClient(int port) throws IOException {
        Socket socket = new Socket("localhost", port); // Connect to the server on localhost and specified port
        duplexer = new Duplexer(socket);    // Initialize the Duplexer for communication
        userIn = new Scanner(System.in);    // Initialize the Scanner for user input
        task(); // Perform summation task
    }

    /**
     * Performs the summation task by continuously prompting the user for numbers to sum and sending requests to the server.
     * @throws IOException If an I/O error occurs during the communication.
     */
    public void task() throws IOException {
        String number = ""; // Initialize number input
        while (!number.equals("0")) {   // Loop until the user inputs 0
            System.out.print("Enter a number: "); // Prompt the user for a number
            number = userIn.nextLine(); // Read user input
            duplexer.send(number);  // Send the number to the server

            String sum = duplexer.read();   // Receive the sum from the server
            System.out.println("Sum = " + sum); // Print the sum
        }
        duplexer.close();   // Close the connection with the server
        userIn.close();     // Close the user input scanner
    }

    /**
     * Main method to create a SumClient instance and connect to the SumServer.
     * @param args Command-line arguments (not used).
     * @throws IOException If an I/O error occurs during initialization.
     */
    public static void main(String[] args) throws IOException {
        new SumClient(9999);    // Create a SumClient instance and connect to the SumServer on port 9999
    }
}
