package fc.java.course2.part2;

import fc.java.model2.PersonFactory;
import fc.java.model2.Person;

public class PersonFactoryTest {
    public static void main(String[] args) {
//        PersonFactory factory = Person::new;
//        System.out.println(factory.create("park",26).getAge());

        PersonFactory factory = new PersonFactory() {
            @Override
            public Person create(String name, int age) {
                return new Person(name, age);
            }
        };

        System.out.println(factory.create("Kim",59).toString());

    }


}
