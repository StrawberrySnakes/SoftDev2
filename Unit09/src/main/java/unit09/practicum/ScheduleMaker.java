// Dessa Shapiro
package unit09.practicum;

import java.util.*;

public class ScheduleMaker {
    public static List<Course> makeSchedule(List<Course> courses) {
        // Sort courses by end time
        /**
         * Greedy algorithm.
         * 
         * 1. Sort the list of courses by end time.
         * 2. Create an empty schedule list.
         * 3. Iterate through each course in the sorted list:
         *      a. If the course starts after the end time of the last scheduled course,
         *         add it to the schedule and update the last scheduled course.
         * 4. Return the final schedule.
         * 
         */
        Collections.sort(courses, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return Integer.compare(c1.getEnd(), c2.getEnd());
            }
        });

        List<Course> schedule = new ArrayList<>();
        Course lastCourse = null;

        for (Course course : courses) {
            if (lastCourse == null || course.getStart() >= lastCourse.getEnd()) {
                schedule.add(course);
                lastCourse = course;
            }
        }
        return schedule;
    }
}

    

