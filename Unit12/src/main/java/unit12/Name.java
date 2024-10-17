package unit12;
import java.net.*;
import java.io.*;
// import java.util.*;

public class Name {

    public static void main(String[] args) throws IOException {
        
        Socket client = new Socket("129.21.40.201", 12345);
        OutputStream output = client.getOutputStream();
        PrintWriter printer = new PrintWriter(output);
        printer.println("Dessa Shapiro");
        printer.flush();
        client.close();
        
    }
    
}
