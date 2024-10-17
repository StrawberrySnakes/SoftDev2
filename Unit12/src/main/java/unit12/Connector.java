package unit12;

import java.net.*;
import java.util.Scanner;
import java.io.*;

/**
 * The Connector class connects to a time server and prints the response.
 */
public class Connector {

    // Entry point of the program
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Connect to the time server
        Socket client = new Socket("time.nist.gov", 13);
        // Get input stream from the server
        InputStream input = client.getInputStream();
        // Create a scanner to read from the input stream
        Scanner scanner = new Scanner(input);
        // Read and print the response from the server
        while (scanner.hasNext()) {
            String msg = scanner.next();
            System.out.print(msg + " ");
        }
        // Close the connection and scanner
        client.close();
        scanner.close();
        System.out.println(); // Print a newline for formatting
    }
}
