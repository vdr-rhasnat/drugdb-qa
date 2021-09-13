package step;

import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Tokenizer {
    public static String getToken(String authUrl, String clientId, String clientSecret, String audience, String grandType) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("audience", audience);
        requestParams.put("grant_type", grandType);
        requestParams.put("client_id", clientId);
        requestParams.put("client_secret", clientSecret);

        Response response =
                given().
                        header("Content-Type", "application/json").
                        body(requestParams.toString()).
                        post(authUrl);
        //response.prettyPrint();
        String token = response.jsonPath().get("access_token");
        System.out.println("Token is " + token);
        System.out.println();
        System.out.println();


        return token;

    }
}
