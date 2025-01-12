package fc.java.course2.part3;

import fc.java.course2.part3.GsonMemAddtoJson;
import com.google.gson.Gson;
import fc.java.model3.Address;
import fc.java.model3.Member;

public class GsonMemAddFromJson {
    public static void main(String[] args) {

        String json = "{\"name\":\"lee\",\"age\":78,\"email\":\"gmail.com\",\"adress\":{\"city\":\"gangnam\",\"state\":\"seoul\",\"country\":\"korea\"}}\n";
        Gson gson = new Gson();
        Member member = gson.fromJson(json, Member.class);
        System.out.println(member);




    }
}
