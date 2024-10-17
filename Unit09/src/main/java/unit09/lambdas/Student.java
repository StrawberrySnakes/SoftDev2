package unit09.lambdas;
import java.util.*;

/**
 * A class that represents a student with a first and last na
 */
public class Student implements Comparable<Student> { // remove Comparable
    /**
     * The student's first name.
     */
    private final String firstName;

    /**
     * The student's last name.
     */
    private final String lastName;

    /**
     * Creates a new student.
     * 
     * @param firstName The new student's first name.
     * @param lastName The new student's last name.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Student other) {
        return this.firstName.compareTo(other.firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" + this.lastName + ", " + this.firstName + "}";
    }

    public static int compareByFirstName(Student a, Student b) {
        return a.firstName.compareToIgnoreCase(b.firstName);
    }

    public static void main(String[] args) {
        List<Student> students = new LinkedList<>();
        students.add(new Student("B", "Y"));
        students.add(new Student("D", "W"));
        students.add(new Student("A", "Z"));
        students.add(new Student("C", "X"));
        Collections.sort(students);
        System.out.println(students);

        // Sort using anonymous class
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student b, Student a) {
                return a.getLastName().compareTo(b.getLastName());
            }
        });
        System.out.println(students);

        // Using Lambda
        Comparator<Student> studentComparatorLambda = (Student a, Student b) -> {
            return a.getLastName().compareTo(b.getLastName());
        };
        students.sort(studentComparatorLambda);
        System.out.println(students);

        // Use short lambda
        students.sort((a, b)-> a.getLastName().compareTo(b.getLastName()));
        System.out.println(students);

        // Use method reference
        students.sort(Student::compareByFirstName);
        System.out.println(students);
        students.sort(Student::compareTo);
        System.out.println(students);

        // Use stream 

        // adding a filter to only give ones with a in them, called predicate 
        students.stream().filter(s->s.toString().toLowerCase().contains("a")).forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
        // gives us the build in string way
        students.stream().forEach(System.out::println);

    }

    
    

}
