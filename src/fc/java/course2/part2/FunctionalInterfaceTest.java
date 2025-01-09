package fc.java.course2.part2;

import fc.java.model2.MathOperation;

public class FunctionalInterfaceTest implements MathOperation {


    public static void main(String[] args) {



        MathOperation mathOperation = new FunctionalInterfaceTest();
        int result = mathOperation.operation(10,20);
        System.out.println(result);
    }
    @Override
    public int operation(int a, int b) {
        return a + b;
    }



}
