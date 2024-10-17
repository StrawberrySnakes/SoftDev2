package unit12.echo;
import java.net.*;
// import java.util.Scanner;
import java.io.*;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server =  new DatagramSocket(54321);
        byte[] buffer = new byte[1024];
        DatagramPacket incomming = new DatagramPacket(buffer, buffer.length);
        server.receive(incomming);
        String msg = new String(incomming.getData(), 0, incomming.getLength());

        DatagramPacket outgoing = new DatagramPacket(msg.getBytes(), msg.length(), incomming.getAddress(), incomming.getPort());

        server.send(outgoing);

        server.close();
    }
}
