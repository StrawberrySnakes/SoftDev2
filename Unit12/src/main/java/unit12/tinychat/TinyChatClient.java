// Dessa Shapiro
package unit12.tinychat;

import java.io.*;
import java.net.*;

public class TinyChatClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12410);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your name: ");
        String name = userInput.readLine();

        // Send name to the server
        out.println(name);

        // Receive connection confirmation from server
        System.out.println(in.readLine());



        // Listen for server messages
        String userInputMessage;
        while ((userInputMessage = userInput.readLine()) != null) {
            out.println(userInputMessage);
            // Check for quit command
            if (userInputMessage == "Quit") {
                break;
            }
        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                String message;
                try {
                    while ((message = in.readLine()) != null) {
                        if (!message.equals("Closing")) {
                            System.out.println(message);
                        } else {
                            break;
                        }
         }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        };};

        // Wait for the receiving thread
        thread.join();

        socket.close();
        }
    }

