// Dessa Shapiro

package unit01;

import java.util.Scanner;

public class Primes {

    public static boolean isPrime(int n) {
        int num;
        num = n-1;
        boolean result;
        if (n>1) {
        for(int i = n; num > 1; num--) {
            if (i % num == 0) {
                return false;
            } else {
                continue;
            }
        }
        result = true;
        return result;} else {return false;}

    }
    public static void main(String[] args) {
        while(true) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int num = scanner.nextInt();
        if(num>1) {
            System.out.println(num + " " + isPrime(num));
        } else {
            scanner.close();
            break;
        }
        scanner.close();
    }

    }
}
    

