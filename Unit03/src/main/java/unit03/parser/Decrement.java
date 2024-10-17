package unit03.parser;

public class Decrement implements Expression {

    private final Expression expression;

    public Decrement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() - 1;
    }
    
}