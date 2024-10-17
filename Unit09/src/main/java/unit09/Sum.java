package unit09;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Sum {

    private static int sum (int n) {
        IntStream stream = IntStream.rangeClosed (1, n);
        //stream.forEach (System.out::println);
        return stream.sum ();
    }

    private static int shiftedSum (int n, int shift) {
        IntStream stream = IntStream.rangeClosed (1, n);
        return stream.map (x -> x + shift).sum ();
    }

    // Map example using an anonymous class
    private static void squareStream (int n) {
        IntStream stream = IntStream.rangeClosed (1, n);
        stream.map (new IntUnaryOperator() {
            public int applyAsInt (int value) {
                return value * value;
            }
        }).forEach (System.out::println);
    }

    public static void main(String[] args) {
        squareStream(10);
        System.out.println (sum (20));
        System.out.println (shiftedSum (20, 42));
    }
}