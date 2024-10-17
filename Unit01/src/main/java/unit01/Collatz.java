// Dessa Shapiro
package unit01;

import java.util.Scanner;

public class Collatz {

    public static String sequence(int n) {
        if(n<0) {
            return "";
        }

        String result = "";
        while(n != 1) {
            result += n + " ";
            if(n%2==0) {
                n = n /2;
            } else {
                n =(3*n) +1;
            }
            
        }
        result += 1;
        return result;
        
    }

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("Enter a natural number: ");
        int num = scanner.nextInt();
        if(num>0) {
            System.out.println(sequence(num));
        } else {
            break;
        }
        
    }
    scanner.close();
    
    
}

        
}
    

