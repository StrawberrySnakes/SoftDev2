package unit01;

public class Conditional {

    public static boolean isEven(int val){
        boolean result;
        if (val % 2 == 0){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    public static void main(String[] args) {
        
        for(int counter = 10; counter > 0; counter--) {
            System.out.println(counter+" "+isEven(counter));
        }
        // System.out.println(isEven(4));
        // System.out.println(isEven(5));
    }
}
