// Dessa Shapiro
package unit05.Iterators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableReader implements Iterable<String>, Iterator<String>, AutoCloseable {
    private BufferedReader bufferedReader;
    private String currentLine;

    /**
     * 
     * @param fileName
     * @throws IOException
     */
    public IterableReader(String fileName) throws IOException {
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            currentLine = bufferedReader.readLine();
        } catch (IOException e) {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    @Override
    public void close() throws IOException {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }

    @Override
    public boolean hasNext() {
        return currentLine != null;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String finalLine = currentLine;
        try {
            currentLine = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return finalLine;
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }

    public static void main(String[] args) {
        
    }
    
}
