package practicum2.bstminmax;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTMinMaxTest {
    @Test
    public void bstMinMaxTestOneVal() {
        BSTMinMax<Integer> bstmm = new BSTMinMax<>(25);
        assertEquals(25, bstmm.getMin());
        assertEquals(25, bstmm.getMax());
    }
    @Test
    public void bstMinMaxTestMany() {
        BSTMinMax<Integer> bstmm = new BSTMinMax<>(25);
        for(int i = 1; i <= 100; i++) {
            bstmm.insert(i);
        }
        assertEquals(1, bstmm.getMin());
        assertEquals(100, bstmm.getMax());
        bstmm.insert(-1);
        bstmm.insert(1000);
        assertEquals(-1, bstmm.getMin());
        assertEquals(1000, bstmm.getMax());
    }
    @Test
    public void bstMinMaxTestAddHigher() {
        BSTMinMax<Integer> bstmm = new BSTMinMax<>(25);
        bstmm.insert(100);
        assertEquals(25, bstmm.getMin());
        assertEquals(100, bstmm.getMax());
    }
    @Test
    public void bstMinMaxTestAddLower() {
        BSTMinMax<Integer> bstmm = new BSTMinMax<>(25);
        bstmm.insert(1);
        assertEquals(1, bstmm.getMin());
        assertEquals(25, bstmm.getMax());
    }
}
