package fc.java.course2.part1;

public class HelloWorldString {
    public static void main(String[] args) {


        String str1 = new String("Hello world");

        String str2 = "Hello world";
        String str3 = "Hello world";

        System.out.println(System.identityHashCode(str1));

        System.out.println(System.identityHashCode(str2));
        System.out.println(System.identityHashCode(str3));
    }
}
