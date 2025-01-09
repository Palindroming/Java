package fc.java.course2.part2;

import fc.java.model2.MathOperation;

public class FunctionalInterfaceTest2  {


    public static void main(String[] args) {

        MathOperationImpl mp = new MathOperationImpl();
        System.out.println("using impl: "+ mp.operation(2,5));
        MathOperation mo = new MathOperation() {

            //MathOperation 인터페이스를 [익명 내부클래스]를 사용
            @Override
            public int operation(int x, int y) {
                return x*y;
            }
        };

        System.out.println("using anonyomus class: "+ mo.operation(2, 5));

    }
}