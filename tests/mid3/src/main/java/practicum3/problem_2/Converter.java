// Dessa Shapiro
package practicum3.problem_2;

public class Converter {
    public interface TempConvert {
        double convert(double temp);
    }

    public static class Inner implements TempConvert {
        @Override
        public double convert(double temp) {
            return temp * 9 / 5 + 32;
        }
    }

    public static double KtoF(double k) {
        return (k - 273.15) * 9 / 5 + 32;
    }

    public static TempConvert inner = new Inner();

    public static TempConvert anonymous = new TempConvert() {
        @Override
        public double convert(double f) {
            return (f - 32) * 5 / 9;
        }
    };

    public static TempConvert lambda = (t) -> (t - 32) * 5 / 9 + 273.15;

    public static TempConvert methodref = Converter::KtoF;

    public static void main(String[] args) {
        System.out.println("Use the JUnit tests!!!");
    }
}

