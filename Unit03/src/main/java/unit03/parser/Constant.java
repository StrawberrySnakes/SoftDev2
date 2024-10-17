package unit03.parser;

public class Constant implements Expression {

    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return this.value;
    }

    public static void main(String[] args) {
        Constant three = new Constant(3);
        System.out.println(three.evaluate());
        Expression increment = new Increment(three);
        System.out.println(increment.evaluate());
        Expression decrement = new Decrement(three);
        System.out.println(decrement.evaluate());
        System.out.println(new Addition(increment, decrement).evaluate());
        System.out.println(new Subtraction(increment, decrement).evaluate());

    }
    
}
