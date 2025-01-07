package fc.java.course2.part1;

import com.google.gson.Gson;
import fc.java.model2.Person;

public class GsonFromAPI {

    public static void main(String[] args) {

        // 올바른 JSON 문자열
        String json = "{\"name\":\"John\",\"age\":30}";
        Gson gson = new Gson();

        // JSON을 Person 객체로 변환
        Person person = gson.fromJson(json, Person.class);

        // Person 객체의 age 출력
        System.out.println(person.getAge());
        System.out.println(person.getName());
        System.out.println(person.toString());
    }
}
