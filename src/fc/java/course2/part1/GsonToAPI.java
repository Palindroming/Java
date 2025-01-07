package fc.java.course2.part1;

import com.google.gson.Gson;
import fc.java.model2.Person;

public class GsonToAPI {

    public static Gson json = new Gson();


    public static void main(String[] args) {
        Person person = new Person("john",30);




        System.out.println(json.toJson(person));
        System.out.println(person.toString());

    }
}
