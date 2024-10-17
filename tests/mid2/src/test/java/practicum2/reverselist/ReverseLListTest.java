package practicum2.reverselist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class ReverseLListTest {
    @Test
    public void reverseLLTest() {
        List<Integer> testList = new ReverseLList<>();
        for (int i = 1; i <= 10; i++){
            testList.add(i);
        }
        int actual = 10;
        for (int ele : testList){
            assertEquals(ele, actual);
            actual--;
        }
    }
}
