package fc.java.course2.part2;

import fc.java.model2.Pair;

public class GenericPairTest {

    public static void main(String[] args) {
        Pair<String,Integer> p1 = new Pair<>("a", 1);
        System.out.println(p1.getKey());



    }

}
