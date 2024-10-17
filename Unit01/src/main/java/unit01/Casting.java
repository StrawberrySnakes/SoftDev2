package unit01;

public class Casting {
    public static void main(String[] args) {
        // cannot convert from long to int but can from into to long 
        long a = 5;
        int b = (int)a;
        System.out.println(a + " " + b);
        // This works automatically 
        char c = 'c';
        int e = c;
        // back into a char
        char f = (char)e;
        System.out.println(c+" "+e+" "+f);



    }
}
