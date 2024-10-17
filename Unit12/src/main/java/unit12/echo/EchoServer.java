package unit12.echo;
import java.net.*;
import java.util.Scanner;
import java.io.*;
// connects to client
// waits for client to come in and connect to it

public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        Socket client = server.accept(); //blocks until a client connects 
        
        Scanner in = new Scanner(client.getInputStream());
        String msg = in.nextLine();
        System.out.println(msg);

        in.close();
        client.close();
        server.close();
        
    }
    
}
