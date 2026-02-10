package api;

import io.restassured.response.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class AuthService {
    public String urlLoginPage = "https://kupi.by/user/auth";
    private Response response;

    public String errorMessageMaxBoundaryPassword = "Количество символов в поле Пароль не может превышать 255.";
    public String errorMessageMaxBoundaryEmail = "Количество символов в поле E-Mail адрес не может превышать 255.";
    public String errorMessageEmptyPassword = "Поле Пароль обязательно для заполнения.";
    public String errorMessageEmptyEmail = "Поле E-Mail адрес обязательно для заполнения.";
    public String errorMessageIncorrectEmail = "Выбранное значение для E-Mail адрес некорректно.";
    public String errorMessageIncorrectPassword = "Выбранное значение для Пароль ошибочно.";
    public String errorMessageIncorrectFormatEmail = "Поле E-Mail адрес должно быть действительным электронным адресом.";

    public String testEmail = "hehe@rambler.ru";
    public String testPassword = "qwerty123";

    private static Logger logger = LogManager.getLogger();

    private Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("t", "1770295767129");
        logger.info("get query params to request");
        return queryParams;
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json; charset=utf-8");
        headers.put("x-requested-with", "XMLHttpRequest");
        logger.info("get headers to request");
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
        logger.info("get body to request");
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
        logger.info("do request");
    }

    public String getResponseMessage() {
        logger.info("get response message");
        return response.body().jsonPath().getString("message");
    }

    public String getResponseErrorEmail() {
        logger.info("get response error email");
        return response.body().jsonPath().getString("errors.email[0]");
    }

    public String getResponseErrorPassword() {
        logger.info("get response error password");
        return response.body().jsonPath().getString("errors.password[0]");
    }

    public int getStatusCode() {
        logger.info("get status code");
        return response.getStatusCode();
    }
}