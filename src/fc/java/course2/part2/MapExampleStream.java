package fc.java.course2.part2;

import java.util.Arrays;
import java.util.List;

public class MapExampleStream {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,5);

        List<Integer> SquareNumbers = numbers.stream().map(n -> n*n).toList();
        System.out.println(SquareNumbers);





    }
}
