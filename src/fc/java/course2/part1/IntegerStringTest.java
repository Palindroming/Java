package fc.java.course2.part1;

public class IntegerStringTest {

    public static void main(String[] args) {
        String str = "123";
        String str2 = "123";
        System.out.println(str+str2); //123123 (concat)

        System.out.println(Integer.parseInt(str) + Integer.parseInt(str2)); //246

        int su1= 123;
        int su2= 123;
        System.out.println(""+su1+su2); //123123
        System.out.println(String.valueOf(su1)+String.valueOf(su2));


    }
}
