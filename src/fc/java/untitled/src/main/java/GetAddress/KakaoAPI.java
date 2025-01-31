package GetAddress;

import java.net.URLEncoder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class KakaoAPI {

    private static final String API_KEY = "7ca5b52c0688707d5a9f1ae36fe65055";

    public static double[] getAddressCoordinate(String address) throws Exception {
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        String requestURL = apiUrl + "?query="+ encodedAddress;


        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(requestURL);
        httpget.setHeader("Authorization", "KakaoAK " + API_KEY);

        try (CloseableHttpResponse response = httpClient.execute(httpget)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            JsonArray documents = jsonObject.getAsJsonArray("documents");

            if (documents.size() > 0) {
                JsonObject document = documents.get(0).getAsJsonObject();
                double latitude = document.get("y").getAsDouble();
                double longitude = document.get("x").getAsDouble();
                return new double[]{latitude, longitude};
            } else {
                return null;
            }
        }
    }
}