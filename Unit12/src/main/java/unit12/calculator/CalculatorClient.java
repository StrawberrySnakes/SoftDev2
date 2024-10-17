// Dessa Shapiro
package unit12.calculator;

import java.net.*;
import java.util.*;
import java.io.*;


public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Create a DatagramSocket for sending and receiving UDP packets
        DatagramSocket socket = new DatagramSocket();

        // Define the byte arrays for sending and receiving data
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        // Define the server's address and port
        InetAddress serverAddress = InetAddress.getByName("nitron.se.rit.edu");
        int serverPort = 12400;

        // Create a list of supported operations
        List<BinaryOperation> operations = new ArrayList<>(7);
        operations.add(new Addition());
        operations.add(new Subtraction());
        operations.add(new Multiplication());
        operations.add(new Division());
        operations.add(new FloorDivision());
        operations.add(new Exponent());

        // Create a Calculator instance with the supported operations
        // Calculator calculator = new Calculator(operations);

        //loop for user interaction
        while (true) {
            System.out.print("Enter math operation (or nothing to exit): ");
            String input = scanner.nextLine();
            if (input.isBlank()) {
                break;
            }
            // Convert input to bytes and create a DatagramPacket to send to the server
            sendData = input.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);

            // Receive result from the server and print it
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Result: " + result);
        }

        scanner.close();
        socket.close();
    }
}


    

