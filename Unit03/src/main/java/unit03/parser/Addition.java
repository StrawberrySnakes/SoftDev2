package unit03.parser;

public class Addition implements Expression {
    private final Expression expression1;
    private final Expression expression2;


    public Addition(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;

    }

    @Override
    public double evaluate() {
        double one = expression1.evaluate();
        double two = expression2.evaluate();
        return one + two;
    }
}
