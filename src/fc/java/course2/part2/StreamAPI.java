package fc.java.course2.part2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamAPI {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
//        IntStream nums = Arrays.stream(numbers);
//        nums.forEach(x -> System.out.println(x*2));

        int sumOfEven = Arrays.stream(numbers).filter(n -> n % 2 == 0).sum(); //람다식
        System.out.println(sumOfEven);

        int [] evenNumbers = Arrays.stream(numbers).filter(n -> n%2 ==0).toArray();
        System.out.println(Arrays.toString(evenNumbers));
        //forEach문 안됨 배열이기 때문에
        Arrays.stream(evenNumbers).forEach(n -> System.out.println(n));


    }

}
