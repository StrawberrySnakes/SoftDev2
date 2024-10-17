// Dessa Shapiro
package unit06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NodeBSTTest {

    @Test
    public void testNodeBST() {
        NodeBST<Integer> bst = new NodeBST<>();

        bst.insert(8);
        bst.insert(6);
        bst.insert(1);
        bst.insert(4);
        bst.insert(9);
        bst.insert(10);
        bst.insert(3);
        bst.insert(2);

        assertEquals(8, bst.size());
        // assertTrue(bst.search(4));
        assertFalse(bst.search(7));
        assertFalse(bst.search(5));
        bst.insert(5);
        assertTrue(bst.search(5));

        assertEquals(8, bst.size());
        bst.insert(5);
        bst.insert(3);
        assertEquals(10, bst.size());
    }

    @Test 
    public void testNodeBSTToString() {
        NodeBST<Integer> bst = new NodeBST<>();
        bst.insert(5);
        bst.insert(3);
        assertEquals("3 5 ", bst.toString());

        bst.insert(7);
        bst.insert(1);
        assertEquals("1 3 5 7 ", bst.toString());
    }
}

