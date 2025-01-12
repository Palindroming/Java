package fc.java.course2.part3;

import com.google.gson.Gson;
import fc.java.model3.Member;

public class GsonFromJson {

    public static void main(String[] args) {

        String json = "{\"name\":\"John Doe\",\"age\":25}";

        Gson gson = new Gson();
        Member mv = gson.fromJson(json, Member.class);
        System.out.println(mv.toString());


    }
}
