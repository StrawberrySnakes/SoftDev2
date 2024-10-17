// Dessa Shapiro
package unit13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a task with a name and a time to complete.
 * The natural ordering of tasks is based on completion time from shortest to longest.
 * If two tasks have the same completion time, they are ordered by name.
 */
public class Task implements Comparable<Task> {
    private String name;
    private int timeToComplete;

    public Task(String name, int timeToComplete) {
        this.name = name;
        this.timeToComplete = timeToComplete;
    }

    public String getName() {return this.name;}
    public int getTimeToComplete() {return this.timeToComplete;}


    /**
     * Finds the maximum subset of tasks that can be completed within the given maximum time.
     * 
     * @param tasks   the list of tasks
     * @param maxTime the maximum amount of time
     * @return the maximum subset of tasks that can be completed within the given time
     */
    public static List<Task> findMax(List<Task> tasks, int maxTime) {
        Collections.sort(tasks);
        List<Task> subset = new ArrayList<>();
        int totalTime = 0;
        for (Task task : tasks) {
            if (totalTime + task.timeToComplete <= maxTime) {
                subset.add(task);
                totalTime += task.timeToComplete;
            } else {
                break;
            }
        }
        return subset;
    }

    @Override
    public int compareTo(Task other) {
        if (this.timeToComplete == other.timeToComplete) {
            return this.name.compareTo(other.name);
        }
        return Integer.compare(this.timeToComplete, other.timeToComplete);
    }
}
