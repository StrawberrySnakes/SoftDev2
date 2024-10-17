// Dessa Shapiro
package unit12.calculator;
import java.net.*;
import java.util.*;
import java.io.*;

public class CalculatorServer {

    public static void main(String[] args) throws IOException {

        try (DatagramSocket serverSocket = new DatagramSocket(12400)) {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            // Create a list of supported operations
            List<BinaryOperation> operations = new ArrayList<>(7);
            operations.add(new Addition()); 
            operations.add(new Subtraction());
            operations.add(new Multiplication());
            operations.add(new Division());
            operations.add(new FloorDivision());
            operations.add(new Exponent());

            Calculator calculator = new Calculator(operations);

            System.out.println("Server running....");

            while (true) {
                // Receive request
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String receivedExpression = new String(receivePacket.getData(), 0, receivePacket.getLength());
                String[] tokens = receivedExpression.strip().split(" ");

                String result;

                if (tokens.length < 3) {
                    result = "error";
                } else {
                    // Parse operands
                    float operand1 = Float.parseFloat(tokens[0]);
                    float operand2 = Float.parseFloat(tokens[2]);
                    // Calculate result
                    result = String.valueOf(calculator.calculate(tokens[1], operand1, operand2));
                    }
                    
                // result to bytes
                sendData = result.getBytes();

                // Get client's address
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                //send the result back to the client
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                
                // Send the packet
                serverSocket.send(sendPacket);
                }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}

