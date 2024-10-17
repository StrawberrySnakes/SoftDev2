// Dessa Shapiro
package unit10.practicum;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        IntStream range = IntStream.rangeClosed(1, 100);
        System.out.println(range);
        range.filter(s->s%3==0 && s%5==0).forEach(s -> System.out.println("FizzBuzz: " + s));
    }
} 
