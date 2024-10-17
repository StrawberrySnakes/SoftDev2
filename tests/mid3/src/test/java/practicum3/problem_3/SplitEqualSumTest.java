package practicum3.problem_3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import practicum3.backtracker.Backtracker;
import java.util.*;

public class SplitEqualSumTest {
    @Test
    public void testOne() {
        SplitEqualSum ses = new SplitEqualSum(Arrays.asList(3,9,4,2),new ArrayList<Integer>());
        Backtracker<SplitEqualSum> solver = new Backtracker<>(false);
        SplitEqualSum solution = solver.solve(ses);
        SplitEqualSum expected = new SplitEqualSum(Arrays.asList(9),Arrays.asList(3,4,2));
        assertEquals(expected.toString(), solution.toString());
    }

    @Test
    public void testTwo() {
        SplitEqualSum ses = new SplitEqualSum(Arrays.asList(1,1,1,3),new ArrayList<Integer>());
        Backtracker<SplitEqualSum> solver = new Backtracker<>(false);
        SplitEqualSum solution = solver.solve(ses);
        SplitEqualSum expected = new SplitEqualSum(Arrays.asList(3),Arrays.asList(1,1,1));
        assertEquals(expected.toString(), solution.toString());
    }

    @Test
    public void testThree() {
        SplitEqualSum ses = new SplitEqualSum(Arrays.asList(2,5,6,9),new ArrayList<Integer>());
        Backtracker<SplitEqualSum> solver = new Backtracker<>(false);
        SplitEqualSum solution = solver.solve(ses);
        SplitEqualSum expected = new SplitEqualSum(Arrays.asList(5,6),Arrays.asList(2,9));
        assertEquals(expected.toString(), solution.toString());
    }

    @Test
    public void testFour() {
        SplitEqualSum ses = new SplitEqualSum(Arrays.asList(1,2,3,4,5,6,7,8),new ArrayList<Integer>());
        Backtracker<SplitEqualSum> solver = new Backtracker<>(false);
        SplitEqualSum solution = solver.solve(ses);
        SplitEqualSum expected = new SplitEqualSum(Arrays.asList(5,6,7),Arrays.asList(1,2,3,4,8));
        assertEquals(expected.toString(), solution.toString());
    }

    @Test
    public void testNoSolution() {
        SplitEqualSum ses = new SplitEqualSum(Arrays.asList(1,2),new ArrayList<Integer>());
        Backtracker<SplitEqualSum> solver = new Backtracker<>(false);
        SplitEqualSum solution = solver.solve(ses);
        assertEquals(null, solution);
    }
}
