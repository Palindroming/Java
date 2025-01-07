package fc.java.course2.part2;

import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        //데이터 추가
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("banana");

//        list.forEach(System.out::println);

        for(String s : list) {
            System.out.println(s);
        }


        System.out.println("Fist data: "+ list.get(0));

        System.out.println("Last data: "+ list.get(list.size()-1));

        System.out.println("--------");
        list.remove(0);
        list.forEach(item -> System.out.print(item + " "));
    }
}
