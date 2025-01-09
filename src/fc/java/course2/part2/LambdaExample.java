package fc.java.course2.part2;

import fc.java.model2.MathOperation;

public class LambdaExample {
    public static void main(String[] args) {
        //코드를 간결, 확장, 구현이 쉽다

        MathOperation add = (x, y) -> x+y;
        MathOperation sub = (x, y) -> x-y;

        System.out.println(add.operation(2,6));
        System.out.println(sub.operation(2,6));


//        MathOperation add = new MathOperation() {
//            @Override
//            public int operation(int x, int y) {
//                return x + y;
//            }
//
//        };
//
//        System.out.println(add.operation(1, 2));
    }
}
