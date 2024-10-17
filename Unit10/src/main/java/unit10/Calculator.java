// Dessa Shapiro
// Something like this will be on the test

package unit10;

// Class Calculator provides operations using anonymous classes and lambdas
public class Calculator {
    
    // Functional interface for operations
    public interface Operation {
        public double execute(double left, double right);
    }

    // Anon classes
    public static Operation getOperation(String operation) {
        // Return operation based on the input string
        if (operation.equals("+")) {
            return new Operation() {
                public double execute(double left, double right) {
                    return left + right; // Addition
                };
            };
        } else if (operation.equals("-")) {
            return (left, right) -> left - right; // Subtraction using lambda expression
        } else if (operation.equals("*")) {
            return (left, right) -> left * right; // Multiplication using lambda expression
        } else if (operation.equals("^")) {
            return Math::pow; // Exponentiation using method reference
        }
        throw new UnsupportedOperationException(); // Unsupported operation
    }

    public static void main(String[] args) {
        double left = 5;
        double right = 4;
        String op = "+";
        Operation operation = getOperation(op); // Get operation based on input string
        System.out.println(left + op + right + " = " + operation.execute(left, right)); // Print result
        op = "-";
        operation = getOperation("-"); // Get operation for subtraction
        System.out.println(left + op + right + " = " + operation.execute(left, right)); // Print result
        op = "*";
        operation = getOperation(op); // Get operation for multiplication
        System.out.println(left + op + right + " = " + operation.execute(left, right)); // Print result
        op = "^";
        operation = getOperation(op); // Get operation for exponentiation
        System.out.println(left + op + right + " = " + operation.execute(left, right)); // Print result
    }
}
