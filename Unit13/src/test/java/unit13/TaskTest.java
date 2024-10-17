package unit13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class TaskTest {

    @Test
    public void testFindMax() {
        // Create a list of tasks
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task A", 2));
        tasks.add(new Task("Task B", 1));
        tasks.add(new Task("Task C", 6));
        tasks.add(new Task("Task D", 3));
        tasks.add(new Task("Task E", 4));
        tasks.add(new Task("Task F", 5));

        // Define the maximum time
        int maxTime = 6;

        // Expected result: [Task A, Task B, Task D]
        List<Task> expectedSubset = new ArrayList<>();
        expectedSubset.add(new Task("Task A", 2));
        expectedSubset.add(new Task("Task B", 1));
        expectedSubset.add(new Task("Task D", 3));

        List<Task> actualSubset = Task.findMax(tasks, maxTime);

        // Compare the expected and actual subsets
        assertEquals(expectedSubset.size(), actualSubset.size());
        for (int i = 0; i < expectedSubset.size(); i++) {
            assertEquals(expectedSubset.get(i).getName(), actualSubset.get(i).getName());
            assertEquals(expectedSubset.get(i).getTimeToComplete(), actualSubset.get(i).getTimeToComplete());
        }
    }
}
