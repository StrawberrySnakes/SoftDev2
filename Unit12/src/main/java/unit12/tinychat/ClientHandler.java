// Dessa Shapiro
package unit12.tinychat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;
    private List<ClientHandler> clients;

    public ClientHandler(Socket socket, List<ClientHandler> clients) {
        this.clientSocket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            name = in.readLine();
            System.out.println(name + ": Connected");

            out.println("Connected");

            // Notify existing clients about the new client
            synchronized (clients) {
                for (ClientHandler client : clients) {
                    if (client != this) {
                        client.out.println(name + ": Connected");
                    }
                }
            }

            // Listen for messages from the client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(name + ": " + message);
                synchronized (clients) {
                    for (ClientHandler client : clients) {
                        if (client != this) {
                            client.out.println(name + ": " + message);
                        }
                    }
                }

                if (message == "Quit") {
                    break;
                }
            }

            // Close connection when client quits
            out.println("Closing");
            clientSocket.close();
            synchronized (clients) {
                clients.remove(this);
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}
