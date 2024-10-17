package unit01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEdit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the output filename: ");
        String filename = scanner.nextLine();
        try (FileWriter fWriter = new FileWriter(filename)){
        // FileWriter fWriter = new FileWriter(filename);
        PrintWriter writer = new PrintWriter(fWriter);
        System.out.println("Enter text to add to file. Enter blank line to quit: ");
        Boolean done = false;
        while (!(done)) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                done = true;
            } else {
                writer.println(line);
            }
        }

        writer.flush();
        // writer.close();
        // fWriter.close();
        scanner.close();
    } catch(IOException ioe) {
        System.out.println("File error occured"+ ioe.getMessage());

    }
    
    }
    
}
