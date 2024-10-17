package unit02;

import java.util.Arrays;

public class Objects {
    public static Object[] funWithObjects(Object object) {
        Object[] objArray = new Object[5];
        objArray[0] = object.toString();
        objArray[1] = 123.456f;
        objArray[2] = new Year(2005);
        // static literal array
        int[] ints = {1, 2, 3, 4};
        objArray[4] = ints;
        return objArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(funWithObjects("abcd")));
        System.out.println(Arrays.toString(funWithObjects(1234)));
        System.out.println(Arrays.toString(funWithObjects(new int[4])));
        



    }
}
