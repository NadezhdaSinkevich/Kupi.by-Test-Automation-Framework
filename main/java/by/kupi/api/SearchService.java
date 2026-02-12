package by.kupi.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SearchService {
    public String urlSearchPage= "https://kupi.by/template/find/extended";
    private Response response;

    public String testElementOutStockForSearch = "DeLonghi PrimaDonna Class Evo ECAM 550.85.MS";
    public String testElementForSearch = "Scishare Capsule Coffee Machine Mini S1201 (золотистый)";
    public String testElementPartialForSearch = "Xiaomi RedmiBook";
    public String testElementRegistrDependencyForSearch = "XiAoMi";
    public String testIncorrectSymbolsForSearch = "=-/*-+,.";
    public String testElementSpacesForSearch = "Scis hare Capsu  le Coffee Mach  ine Mini S1201 (золотистый)";
    public String testCategoriesForSearch = "Товары для дома";
    public String testSubcategoriesForSearch = "Кофемашина";

    private Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("", "");
        return queryParams;
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json; charset=utf-8");
        headers.put("x-requested-with", "XMLHttpRequest");
        return headers;
    }

    private String getBody(String findText) {
        String body = "{" +
                "\"charset\":\"utf-8\"," +
                "\"findtext\": \"" + findText + "\"," +
                "\"page_size\":12," +
                "\"page_num\":1," +
                "\"noContent\":true" +
                "}";
        return body;
    }

    public void doRequest(String findText) {
        response =
                given().baseUri(urlSearchPage)
                        .queryParams(getQueryParams())
                        .headers(getHeaders())
                        .body(getBody(findText))
                        .when()
                        .post(urlSearchPage);
    }

    public int getElementsCount() {
       String count = response.body().jsonPath().getString("productCount");
       return Integer.parseInt(count);
    }

    public String getResponseElementName() {
        return response.body().jsonPath().getString("productList.name[0]");
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }
}