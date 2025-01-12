package fc.java.course2.part3;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.Buffer;
import java.sql.SQLOutput;

public class WeatherExample {

    public static void main(String[] args) {
        String api_key = "fd13e0353ac32f05566a5a43dfd41c95";
        String city = "Seoul";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+api_key+"&units=metric";

        try{
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod(("GET"));
            con.setRequestProperty("Accept", "application/json");

            int responseCode = con.getResponseCode(); //200
            if(responseCode == 200){
                System.out.println("Weather API returned 200 OK");
              BufferedReader in =   new BufferedReader(new InputStreamReader(con.getInputStream()));
              /*자바는 네트워크 통신에서 오는 데이터나 파일 데이터를 모두 바이트 단위로 처리합니다.
                사람이 읽을 수 있는 문자 데이터로 변환하려면 InputStream(바이트) → InputStreamReader(문자) → BufferedReader(효율적 읽기)와 같은 계층적 처리가 필요합니다.*/
                String inputLine;
                StringBuffer content = new StringBuffer();
                while((inputLine=in.readLine())!=null){
                    content.append(inputLine);
                }
                in.close();
                System.out.println("content: "+content.toString());
                JsonObject WeatherData= JsonParser.parseString(content.toString()).getAsJsonObject();
                JsonObject main = WeatherData.getAsJsonObject("main");
                double temp= main.get("temp").getAsDouble();
                System.out.println(temp);
                con.disconnect();

            } else {
                System.out.println("Weather API returned 404 NOT FOUND");
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
