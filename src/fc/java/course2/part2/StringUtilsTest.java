package fc.java.course2.part2;

import fc.java.model2.Converter;
import fc.java.model2.StringUtils;

public class StringUtilsTest {

    public static void main(String[] args) {

        StringUtils stu = new StringUtils();
        Converter<String,String> cv = stu::reverse;

        cv.convert("hello");






    }
}
