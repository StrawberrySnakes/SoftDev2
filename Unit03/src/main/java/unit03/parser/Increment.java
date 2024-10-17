package unit03.parser;

public class Increment implements Expression {

    private final Expression expression;

    public Increment(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() + 1;
    }
    
}
