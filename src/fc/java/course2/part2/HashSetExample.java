package fc.java.course2.part2;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    //set: 순서가 없고, 중복이 불가능하다

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add("pineapple");


        set.forEach(System.out::println);

        set.remove("orange");
        boolean contains = set.contains("orange");
        System.out.println(contains);



    }

}

