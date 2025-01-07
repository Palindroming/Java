package fc.java.model2;

public class StringCompare {
    public static void main(String[] args) {

        String str1 = "HELLO";
        String str2 = "WORLD";

        if(str1.equals(str2)){
            System.out.println("Same");

        }else System.out.println("Nope");

        int result = str1.compareTo(str2);

        if(result ==0){
            System.out.println("Same");
        } else if(result<0){
            System.out.println("str1<str2");
        } else System.out.println("str1>str2");
    }
}
