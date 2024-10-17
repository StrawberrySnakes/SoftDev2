// Dessa Shapiro
package unit13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// server
public class TinyWebServer implements Runnable {

    private boolean running = true;
    private final ServerSocket serverSocket;

    public TinyWebServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("Server started. Listening on port " + port);
    }

    /**
     * 
     * @param clientSocket
     * @throws IOException
     */
    private void handleClient(Socket clientSocket) throws IOException {
        InputStream in = clientSocket.getInputStream();
        OutputStream out = clientSocket.getOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        if (bytesRead > 0) {
            String request = new String(buffer, 0, bytesRead);
            System.out.println("Received request from client:");
            String[] requestLines = request.split("\r\n");
            for (int i = 0; i < 3 && i < requestLines.length; i++) {
                System.out.println(requestLines[i]);
            }

            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Length: 12\r\n" +
                    "Content-Type: text/plain; charset=utf-8\r\n\r\n" +
                    "Hello World!\r\n";
            out.write(response.getBytes());
            out.flush();
        }
        clientSocket.close();
        System.out.println("Connection closed.");
    }

    @Override
    public void run() {
        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                Thread clientThread = new Thread(() -> {
                    try {
                        handleClient(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TinyWebServer server = new TinyWebServer(8080);
        Thread serverThread = new Thread(server);
        serverThread.start();
    }
}
