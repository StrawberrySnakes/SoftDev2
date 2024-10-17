package unit01;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calcuon {
    public static float add(float x, float y) {
        return x+y;
    }

    public static float subtract(float x, float y) {
        return x-y;
    }

    public static float multiply(float x, float y) {
        return x*y;
    }

    public static float divide(float x, float y) {
        return x / y;
    }

    public static int raise(int x, int y) {
        int result = 1;
        while(y>0) {
            result = result * x;
            y--;
        }

        return result;
    }


    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operand 1");
            float x = scanner.nextFloat();
            System.out.println("Enter operand 2");
            float y = scanner.nextFloat();
            scanner.close();

        
            System.out.println(add(x, y));
            System.out.println(subtract(x, y));
            System.out.println(multiply(x, y));
            System.out.println(divide(x, y));
            System.out.println(raise((int)x, (int)y));
        } catch(InputMismatchException ime) {
            System.err.println("Please enter valid numeric values");

        }
       
        
        
    }
}
