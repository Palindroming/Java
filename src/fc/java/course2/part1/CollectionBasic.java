package fc.java.course2.part1;

import java.util.ArrayList;

public class CollectionBasic {
    public static void main(String[] args) {
        //ArrayList에 10, 20, 30, 40, 50 5개의 정수를 저장하고 출력하세요
        //ArrayList --> Object[] <-- x-- int

        Integer a = 10;
        Integer b = 20;
        Integer c = 30;
        Integer d = 40;
        Integer e = 50;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        list.forEach(System.out::println);
    }
}
