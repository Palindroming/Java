package fc.java.course2.part2;

import fc.java.model2.MathOperation;

public class MathOperationImpl implements MathOperation {

    @Override
    public int operation(int a, int b) {
        return (a+b)/2 ;
    }

}
