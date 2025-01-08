package fc.java.course2.part2;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {

    public static void main(String[] args) {

        String str1 = "Hello World";
        Map<Character, Integer> map = new HashMap<>();

        char[] strArr = str1.toCharArray();
        for (char c : strArr) {
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        System.out.println("character counts: ");
        map.forEach((key,value) -> System.out.println(key+": "+value));

    }


}
