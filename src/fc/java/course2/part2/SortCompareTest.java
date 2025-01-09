package fc.java.course2.part2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCompareTest {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("홍길동","박정희","이선우");
        Collections.sort(names,String::compareTo);
        System.out.println(names);
        names.forEach(System.out::println);

    }
}
