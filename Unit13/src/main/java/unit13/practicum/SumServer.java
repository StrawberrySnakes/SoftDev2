package unit13.practicum;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The SumServer class represents a server application that calculates the sum of numbers received from clients.
 */
public class SumServer {
    private ServerSocket serverSocket; // Server socket to accept client connections
    private int totalSum; // Total sum of received numbers

    /**
     * Constructor to initialize the SumServer with a port to listen for client connections.
     * @param port The port number to listen on.
     */
    public SumServer(int port) {
        try {
            serverSocket = new ServerSocket(port); // Create a server socket on the specified port
            totalSum = 0; // Initialize total sum to 0
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                handleClient(serverSocket.accept()); // Accept incoming client connections and handle them
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print any IOException that occurs during initialization
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close(); // Close the server socket if not null
            } catch (IOException e) {
                e.printStackTrace(); // Print any IOException that occurs while closing the server socket
            }
        }
    }

    /**
     * Handles a client connection by processing the numbers sent by the client and sending back the total sum.
     * @param clientSocket The client socket representing the connection.
     */
    private void handleClient(Socket clientSocket) {
        Thread clientThread = new Thread(() -> {
            try {
                Duplexer duplexer = new Duplexer(clientSocket); // Initialize the Duplexer for communication with the client
                String number;
                while (!(number = duplexer.read()).equals("0")) { // Read numbers from the client until '0' is received
                    System.out.println("Received number: " + number); // Print the received number
                    int num = Integer.parseInt(number); // Parse the received number
                    totalSum += num; // Add the number to the total sum
                    System.out.println("Total sum: " + totalSum); // Print the updated total sum

                    duplexer.send(String.valueOf(totalSum)); // Send back the total sum to the client
                }
                System.out.println("Final total sum: " + totalSum); // Print the final total sum
                System.out.println("Closing connection..."); // Print message indicating closing of connection
                duplexer.close(); // Close the Duplexer and the client connection
            } catch (IOException e) {
                e.printStackTrace(); // Print any IOException that occurs during communication with the client
            }
        });

        clientThread.start(); // Start the client thread to handle the connection
    }

    /**
     * Main method to create a SumServer instance and start listening for client connections.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new SumServer(9999); // Create a SumServer instance and start listening on port 9999
    }
}
