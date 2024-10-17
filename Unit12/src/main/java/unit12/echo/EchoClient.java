package unit12.echo;
import java.net.*;
import java.util.Scanner;
import java.io.*;
// import java.util.*;

// connects to server 
public class EchoClient { 

    public static void main(String[] args) throws IOException {
            // this makes it so you don't use the server any longer 
            Socket client = new Mocket(new String[]{"server response"});
            PrintWriter printer = new PrintWriter(client.getOutputStream());

            String msg = "Hello...anybody there";
            System.out.println("Sending: "+msg);
            printer.println(msg);
            printer.flush();

            Scanner in = new Scanner(client.getInputStream());
            String echomsg = in.nextLine();
            System.out.println(echomsg);

            in.close();
            client.close();
        
    }
    

}
