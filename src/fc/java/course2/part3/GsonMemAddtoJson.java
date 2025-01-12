package fc.java.course2.part3;

import com.google.gson.Gson;
import fc.java.model3.Address;
import fc.java.model3.Member;

public class GsonMemAddtoJson {
    public static void main(String[] args) {
         Address adr = new Address("gangnam","seoul","korea");
         Member mem = new Member("lee",78,"gmail.com",adr);

         Gson gson = new Gson();
         String json = gson.toJson(mem);
         System.out.println(json);



    }
}
