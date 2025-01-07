package fc.java.model2;

public class StringManipulation {

    public static void main(String[] args) {
        //HelloWorld라는 문자열을 생성하세요.
        String str = new String("HelloWorld"); //객체로 취급
        char firstChar = str.charAt(0);
        String replacedString = str.replaceAll("o","X");
        int index = str.indexOf(("W"));
        int length = str.length();
        String upper = str.toUpperCase();
        String lower = str.toLowerCase();
        String substring = str.substring(5);

        System.out.println(firstChar);
    }
}
