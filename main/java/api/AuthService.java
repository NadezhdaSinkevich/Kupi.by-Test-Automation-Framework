package api;

import io.restassured.response.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthService {
    public String urlLoginPage = "https://kupi.by/user/auth";
    private Response response;

    private Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("t", "1770295767129");
        return queryParams;
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json; charset=utf-8");
        headers.put("x-requested-with", "XMLHttpRequest");
        return headers;
    }

    private String getBody(String email, String password) {
        String body = "{\n" +
                "\"login\": \"login\",\n" +
                "\"type\": \"email_password\",\n" +
                "\"email\": \"" + email + "\",\n" +
                "\"password\": \"" + password + "\",\n" +
                "\"_token\": \"PV07i5GQ4yeGJG88IP81Fn2Ks1TiabPh1gWKkhNE\"\n" +
                "}";

        return body;
    }

    public void doRequest(String email, String password) {
        response =
                given().baseUri("https://kupi.by")
                        .queryParams(getQueryParams())
                        .headers(getHeaders())
                        .body(getBody(email, password))
                        .when()
                        .post(urlLoginPage);
    }

    public String getResponseMessage(){
        return  response.body().jsonPath().getString("message");
    }

    public String getResponseError(){
        return  response.body().jsonPath().getString("errors");
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }
}
