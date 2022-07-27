package Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostRequest {
    String uri;
    String endpoint;
    RequestSpecification requestSpecification = RestAssured.given();

    public PostRequest(String uri, String endpoint) {
        this.endpoint=endpoint;
        requestSpecification.baseUri(uri);
        requestSpecification.header("Content-type", "application/json");
    }
   public void addToken(String token)
   {
       requestSpecification.header("Authorization", "Bearer "+token);
   }

    public Response send(Object body) {
        Response response =requestSpecification
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
        return response;
    }
}
