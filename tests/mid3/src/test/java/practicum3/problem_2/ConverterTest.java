package practicum3.problem_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ConverterTest {
    @Test
    public void testInner() {
        assertEquals(122.0, Converter.inner.convert(50.0));
    }

    @Test
    public void testAnonymous() {
        assertEquals(50.0, Converter.anonymous.convert(122.0));
    }

    @Test
    public void testLambda() {
        assertEquals(283.15, Converter.lambda.convert(50.0));
    }

    @Test
    public void testMethodReference() {
        assertEquals(50, Converter.methodref.convert(283.15));
    }   
}

