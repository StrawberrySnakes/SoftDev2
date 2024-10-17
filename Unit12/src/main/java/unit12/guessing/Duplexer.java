package unit12.guessing;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * The Duplexer class encapsulates a socket connection with input and output streams.
 */
public class Duplexer {
    private Socket sock;        // Socket object
    private Scanner in;         // Scanner for input stream
    private PrintWriter out;    // PrintWriter for output stream

    /**
     * Constructor to initialize the Duplexer with a Socket.
     * @param sock The socket connection to encapsulate.
     * @throws IOException If an I/O error occurs when creating the scanner or print writer.
     */
    public Duplexer(Socket sock) throws IOException {
        this.sock = sock;
        this.in = new Scanner(sock.getInputStream());             // Initialize scanner for input stream
        this.out = new PrintWriter(sock.getOutputStream());      // Initialize print writer for output stream
    }

    /**
     * Closes the socket connection and associated streams.
     * @throws IOException If an I/O error occurs when closing the socket or streams.
     */
    public void close() throws IOException {
        this.sock.close();    // Close the socket
        this.in.close();      // Close the input scanner
        this.out.close();     // Close the output print writer
    }

    /**
     * Sends a message through the output stream.
     * @param msg The message to send.
     */
    public void send(String msg) {
        out.println(msg);   // Write the message to the output stream
        out.flush();        // Flush the stream to ensure the message is sent immediately
    }

    /**
     * Receives a message from the input stream.
     * @return The received message.
     */
    public String receive() {
        return in.nextLine();   // Read a line from the input stream and return it
    }
}
