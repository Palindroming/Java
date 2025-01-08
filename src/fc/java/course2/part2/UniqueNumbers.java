package fc.java.course2.part2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumbers {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,2,4,6,7,1,3};

        Set<Integer> unique = new HashSet<>();


        Arrays.stream(nums).forEach(unique::add);
        unique.forEach(num -> System.out.print(num + " "));



    }

}
