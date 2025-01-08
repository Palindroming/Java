package fc.java.course2.part2;

import fc.java.model2.BookDTO;
import fc.java.model2.Person;

import java.util.ArrayList;
import java.util.List;

public class ArraylistGeneric {

    public static void main(String[] args) {

        List<Person> list = new ArrayList();

        list.add(new Person("park",25));
//        list.add("Hello"); //타입 안전성 위반
        list.add(new Person("hwang",28));
        list.forEach(System.out::println);




    }

}
