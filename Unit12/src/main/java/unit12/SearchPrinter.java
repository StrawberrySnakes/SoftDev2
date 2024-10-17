package unit12;
import java.net.*;
import java.io.*;
import java.util.*;



public class SearchPrinter {
    
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://search.yahoo.com");
        URLConnection connection = url.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }
}

