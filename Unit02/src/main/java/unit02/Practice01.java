// Dessa Shapiro

package unit02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Practice01 {
    
    
    public static String arrayToString(int[] anArray) {
        String result = "[";
        int len = anArray.length;
        for(int i = 0; len>0; len--) {
            int value = anArray[i];
            if(len == 1) {
                result += value;
            } else {
            result += value+", ";
            }
            i++;
        }

        return result+"]";
    }

    public static int printLines(String filename, String letter){
        try {
        FileReader fReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fReader);
        String line;
        int result = 0;
        while((line = reader.readLine())!=null) {
            String newLine = line.toLowerCase();
            if(newLine.startsWith(letter)) {
                result += 1;
            }
        }
        
        reader.close();
        fReader.close();
        return result;
        } catch(IOException ioe) {
            System.out.println("file not found");
            return 0;
        }
       



        
    }

    public static void main(String[] args) {
        int[] anArray = {1, 2, 1};
        System.out.println(arrayToString(anArray));
        System.out.println(printLines("data/alice.txt", "a"));
        }
        
}

