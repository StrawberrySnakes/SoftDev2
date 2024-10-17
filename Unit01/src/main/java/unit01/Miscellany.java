package unit01;

// import java.lang.reflect.Array;
import java.util.Arrays;

public class Miscellany {
    public static String reverseChars(String inString) {
        String reversed = "";
        for(int i = 0; i<inString.length(); i++) {
            reversed = inString.charAt(i) + reversed;

        }
        return reversed;
    }

    public static int[] squares(int n) {
        int[] result = new int[n];
        // length is not a method it is part of the language.. it is reserved keyword in the java method
        for (int i = 0; i < result.length; i++) {
            result[i] = i*i;
        }
        return result;
    }

    public static int[][] multiplicationTable(int rows, int columns) {
        int[][] result = new int[rows][columns];
        for(int r = 0; r < rows; r++) {
            for(int c =0; c < columns; c++) {
                result[r][c] = (r+1)*(c+1);
            }
        }

        return result;
        
    }

    public static void main(String[] args) {
        String inString = "abcdefg";
        String reversed = reverseChars(inString);
        System.out.println(reversed);
        int value = 10;
        System.out.println(Arrays.toString(squares(value)));
        int r = 3;
        int c = 4;
        int[][] table = multiplicationTable(r, c);
        for (int i = 0; i< table.length; i++) {
            System.out.println(Arrays.toString(table[i]));
        }

    }
}
