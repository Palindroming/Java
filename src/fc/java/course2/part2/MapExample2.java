package fc.java.course2.part2;

import java.util.List;

public class MapExample2 {
    public static void main(String[] args) {

        List<String> words = List.of("apple","banana","orange","cherry");

        words.stream().map(n -> n.toUpperCase()).forEach(System.out::println);
    }
}
