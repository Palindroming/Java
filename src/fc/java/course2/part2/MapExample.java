package fc.java.course2.part2;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<String, Integer> studentScore = new HashMap<>();

        studentScore.put("kim",92);
        studentScore.put("john",91);
        studentScore.put("jane",90);
        studentScore.put("mary",80);
        studentScore.put("sam",81);

        System.out.println("kim: " + studentScore.get("kim"));


        studentScore.put("john",80); //수정
        System.out.println("john: " + studentScore.get("john"));


        studentScore.remove("john");
        System.out.println("john: " + studentScore.get("john"));

        System.out.println("------");
//        for(Map.Entry<String, Integer> entry : studentScore.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        studentScore.forEach((key,value)->System.out.println(key+": "+value));




            }
}
