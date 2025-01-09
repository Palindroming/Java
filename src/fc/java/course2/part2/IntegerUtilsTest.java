package fc.java.course2.part2;

import fc.java.model2.Converter;
import fc.java.model2.IntegerUtills;

public class IntegerUtilsTest {
    public static void main(String[] args) {

        Converter<String, Integer> cv = IntegerUtills::stringToInt;

        System.out.println(cv.convert("123"));
    }
}

