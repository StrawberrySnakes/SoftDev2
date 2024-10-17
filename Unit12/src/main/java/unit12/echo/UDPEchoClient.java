package unit12.echo;
import java.net.*;
import java.io.*;

public class UDPEchoClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket sock =  new DatagramSocket();

        for(int i = 0; i < 1000; i++) {
            String msg = "DOOFENSHMIRTZ evil inc";
            System.out.println(msg);
            DatagramPacket outgoing = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getByName("localhost"), 54321);

            sock.send(outgoing);

            byte[] buffer = new byte[1024];
            DatagramPacket incomming = new DatagramPacket(buffer, buffer.length);
            sock.receive(incomming); //another blocking call
            String retmsg = new String(incomming.getData(), 0, incomming.getLength());
            System.out.println(retmsg);
        }
        sock.close();

    }
    
}
