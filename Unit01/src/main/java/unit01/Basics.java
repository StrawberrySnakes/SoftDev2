package unit01;

public class Basics {
    public static void main(String[] args) {
        for(int i=1; i<=100; i++) {
            if((i%3 == 0 || i%7==0) && i%21!=0) {
                System.out.println(i);
            } else {
                continue;
            }
        }
        
    }
}
