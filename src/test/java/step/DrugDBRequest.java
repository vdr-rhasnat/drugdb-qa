package step;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DrugDBRequest {
    public static Response GetByNdc(String endpoint, String token) {
        System.out.println("Hitting endpoint " + endpoint);
        System.out.println();

        Response response = given().header("Authorization", "Bearer " +token).get(endpoint);

        response.prettyPrint();

        System.out.println();
        System.out.println();

        return response;
    }
}
