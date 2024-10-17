package Practicum01.countlines;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountLines {

    /**
     * Checks to see if a string contains at least one occurrence of the given word
     * 
     * @param aString - string to check
     * @param aWord - word to check for
     * @return - true if string contains at least one occurrence of the given word, false otherwise
     */
    public static boolean stringContainsWord(String aString,String aWord) {
        boolean found = false;
        String lowerString = aString.toLowerCase();
        String[] tokens = lowerString.split(" ");
        for (int i=0; i<tokens.length; i++) {
            String word = tokens[i];
            if (word.equals(aWord)) {
                found = true;
            }
        }


// YOUR CODE GOES HERE
        return found;
    }
    /**
     * Returns a count of the number of lines that contains at least one occurrence
     * of the given word.
     * @param filename - the filename to read lines from
     * @param word - the word to match against words on a line
     * @return - the count of lines or -1 if any errors with accessing or reading from
     *           the file
     * @throws IOException 
     */
    public static int countLines(String filename,String word) {
        try {
            int count = 0; 
        FileReader freader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(freader);
        while(reader != null) {
            String line = reader.readLine();
            if (stringContainsWord(line, word) == true) {
                count ++;
            } else {
                continue;
            }
            reader.close();
        }

        freader.close();
        
        
        return count;
        } catch (FileNotFoundException fe) {return -1;} catch (IOException e) {
            return -1;
        } 
        
    }
}
