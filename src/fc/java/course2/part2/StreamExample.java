package fc.java.course2.part2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Predicate<Integer> isEven = num -> num % 2 == 0;

        int SumOfSquaes = nums.stream().filter(isEven).map(n -> n * n).reduce(0, Integer::sum);
        //map() 메서드 -> 주어진 함수를 스트림의 모든 원소에 적용한 결과로 새로운 스트림 생성
        //reduce() 메서드 -> 스트림의 요소를 결합하여 하나의 결과 값을 생성하는데 사용

        System.out.println("square of sum of even numbers:  "+SumOfSquaes); //220


    }


}
