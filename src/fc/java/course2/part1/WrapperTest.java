package fc.java.course2.part1;

public class WrapperTest {
    public static void main(String[] args) {
        // 정수형 변수에 10을 저장하세요.
        int a = 10; //기본 자료형
//        Integer aa = new Integer(10); //사용자 정의 자료형
        Integer aa = 10; //Auto - boxing
        System.out.println(aa.intValue()); //unboxing(Integer -> Int)

        System.out.println(aa.toString());


        Integer bb = 20; //Autoboxing
        int b = bb; //Auto - unboxing
        System.out.println(b);

        float cc = 10.5f;
        Float ff = cc; //Auto-boxing
        System.out.println(ff);

        Float af = 49.1f;
        float aff = af;
        System.out.println(aff);

    }
}
