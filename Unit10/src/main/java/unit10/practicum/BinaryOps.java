// Dessa Shapiro
package unit10.practicum;

public class BinaryOps {
    public interface BinaryLogicalOp {
        boolean compute(boolean a,boolean b);
    } 

    public static boolean logicalAnd(boolean a, boolean b) {
        return Boolean.logicalAnd(a, b);
    }
    public static void main(String[] args) {
        BinaryLogicalOp and = BinaryOps::logicalAnd; // Method reference


        BinaryLogicalOp or = new BinaryLogicalOp() {
            @Override
            public boolean compute(boolean a, boolean b) {
                return a || b;
            }
        };

        // Lambda
        BinaryLogicalOp xor = ((a, b)-> a^b);
        
        boolean a = false;
        boolean b = false;

        System.out.println("A:"+a+", B:"+b+ ", AND: "+and.compute(a, b)+", OR: "+or.compute(a, b)+", XOR: " + xor.compute(a, b));
        b = true;
        System.out.println("A:"+a+", B:"+b+ ", AND: "+and.compute(a, b)+", OR: "+or.compute(a, b)+", XOR: " + xor.compute(a, b));
        a=true;
        b=false;
        System.out.println("A:"+a+", B:"+b+ ", AND: "+and.compute(a, b)+", OR: "+or.compute(a, b)+", XOR: " + xor.compute(a, b));
        b=true;
        System.out.println("A:"+a+", B:"+b+ ", AND: "+and.compute(a, b)+", OR: "+or.compute(a, b)+", XOR: " + xor.compute(a, b));






        
    }
    
}
