// Dessa Shapiro
package unit12.tinychat;
import java.net.*;
import java.io.*;
import java.util.*;

public class TinyChatServer {
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        try (ServerSocket serverSocket = new ServerSocket(12410)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                // Listen for incoming connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Create a new thread for each client
                ClientHandler clientHandler = new ClientHandler(clientSocket, clients);
                Thread clientThread = new Thread(clientHandler);
                clients.add(clientHandler);
                clientThread.start();
            }
        }
        
    }
}


