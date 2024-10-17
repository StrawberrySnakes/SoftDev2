// Dessa Shapiro

package unit01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// import java.util.Arrays;

public class SieveValidator {
    @SuppressWarnings("resource")

    public static int[] readSieve(String filename) {
        try {
        FileReader fReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fReader);
        
        String firstLine = reader.readLine();
        int size = Integer.parseInt(firstLine);

        int[] sieve = new int[size];
        int i = 0;
        String line;

	    while ((line=reader.readLine()) != null) {
            for(char digit : line.toCharArray()) {
                if(digit == '1') {
                    sieve[i] = 1;
                } else {
                    sieve[i] = 0;
                }
                
			}
            i++;
        }
        return sieve;
        } catch (IOException ioe) {
            System.err.println("Could not read sieve");
            return null;
        }
	}

    public static int repairSieve(int[] sieve) {
        int len = sieve.length;
        System.out.println("Validating an array of size "+len);
        int errors = 0;
        for (int num = 0; num<len; num++) {
            int value = sieve[num];
            Boolean prime = Primes.isPrime(num);
            if (prime == true && value != 0) {	
                System.out.println(num +" is incorrectly marked as not prime");
                errors += 1;		
                sieve[num] = 0;
            } else if (prime == false && value != 1) {
                System.out.println(num +" is incorrectly marked as prime");		
                sieve[num] = 1;
                errors+=1;
            } else {
                continue;
            }
        }

        return errors;


    }

    public static void main(String[] args) {
        int[] result = readSieve("unit01-StrawberrySnakes/data/sieve_5.txt");
        if (result != null) {
            System.out.println("Sieve contained "+ repairSieve(result)+ " error(s).");
        }

        int[] resultTwo = readSieve("unit01-StrawberrySnakes/data/sieve_10.txt");
        if (result != null) {
            System.out.println("Sieve contained "+ repairSieve(resultTwo)+ " error(s).");
        }

        int[] resultThree = readSieve("unit01-StrawberrySnakes/data/sieve_55.txt");
        if (result != null) {
            System.out.println("Sieve contained "+ repairSieve(resultThree)+ " error(s).");
        }

        int[] resultFour = readSieve("unit01-StrawberrySnakes/data/sieve_100.txt");
        if (result != null) {
            System.out.println("Sieve contained "+ repairSieve(resultFour)+ " error(s).");
        }

        int[] resultFive = readSieve("unit01-StrawberrySnakes/data/sieve_1000.txt");
        if (result != null) {
            System.out.println("Sieve contained "+ repairSieve(resultFive)+ " error(s).");
        }

        int[] resultSix = readSieve("unit01-StrawberrySnakes/data/sieve_10000.txt");
        if (result != null) {
            System.out.println("Sieve contained "+ repairSieve(resultSix)+ " error(s).");
        }
        
    }

    
}
