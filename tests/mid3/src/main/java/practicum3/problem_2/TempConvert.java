package practicum3.problem_2;

/**
 * A functional interface that defines a method for converting between 
 * temperature scales, e.g. from Celsius to Fahrenheit.
 */
public interface TempConvert { 
    /**
     * Converts temperature from one scale to another.
     * 
     * @param temp The temperature in the original scale.
     * 
     * @return The converted temperature.
     */
    public double convert(double temp);
}
