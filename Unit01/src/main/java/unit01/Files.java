package unit01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Files {

    public static void info(String filename) {
        File file = new File(filename);
        System.out.println("name: " + file.getName());
        System.out.println("path: "+file.getAbsolutePath());
        if(file.exists()) {
            System.out.println("length: "+file.length());
        } else {
            System.out.println("File does not exist");
        }
    }

    public static void printFile(String filename) throws IOException {
        FileReader fReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fReader);

        String line;
        while((line = reader.readLine())!=null) {
            line.toLowerCase();
            
        }
        reader.close();
        fReader.close();
    }
    
    public static void main(String[] args) {
        try { 
            printFile("unit01-StrawberrySnakes/data/alice.txt"); 
        } catch(IOException ioe) {
            System.out.println("Problem printing file: " +ioe.getMessage());

        }

    }
}
