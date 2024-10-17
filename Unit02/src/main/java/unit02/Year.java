package unit02;

import java.util.Arrays;
import java.util.Random;

public class Year {
    // static = part of the class
    public static final int DAYS_IN_YEAR = 365;
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2023;
    private static final Random RNG = new Random();

    private final int yearNumber;


     /**
     * @param yearNumber
     * 
     * 
     */
    public Year(int yearNumber) {
        this.yearNumber = yearNumber;
    }
    /**
     * 
     * @return the year number
     */

    public int getYear() {return yearNumber;}

    /**
     * 
     * @return number of days in the year
     */
    public int numberOfDays() {
        return Year.daysInYear(this.yearNumber);
    }

    @Override
    public String toString() {
        return "Year: {YearNumber: "+ this.yearNumber + ", Days in Year: " + Year.daysInYear(this.yearNumber) +"}";
    }

   
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Year){
            Year other = (Year)obj;
            return this.yearNumber == other.yearNumber;
        } else {
            return false;
        }
    }

    public static int daysInYear(int year) {
        if(year % 400 == 0) {
            return DAYS_IN_YEAR + 1;
        } else if(year%100 != 0 && year%4 == 0) {
            return DAYS_IN_YEAR + 1;
        } else {
            return DAYS_IN_YEAR;
        }
    }

    public static Year[] parseYears(String years) {
        String[] tokens = years.split(" ");
        Year[] result = new Year[tokens.length];
        for (int i = 0; i<tokens.length; i++) {
            int yearNumber = Integer.parseInt(tokens[1]);
            result[i] = new Year(yearNumber);
        }
        return result;
    }

    public static Year randomYear() {
        int bound = MAX_YEAR - MIN_YEAR +1;
        int yearNumber = MIN_YEAR + RNG.nextInt(bound);
        return new Year(yearNumber);
    }

    public static void main(String[] args) {
        for (int i = 1900; i<1940; i++) {
            Year year = new Year(i);
            System.out.println(i + " " + year + " " + year.numberOfDays());
        }
        Year y1 = new Year(1900);
        Year y2 = new Year(1901);
        Year y3 = new Year(1901);

        System.out.println(y1.equals(y2));
        System.out.println(y1.equals(y3));
        System.out.println(y2.equals(y3));

        String years = "1900 1901 1902 1903 1904";
        Year[] yearArray = Year.parseYears(years);
        System.out.println(Arrays.toString(yearArray));

        System.out.println(Year.randomYear());
        



    }

}
