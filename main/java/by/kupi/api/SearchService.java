package by.kupi.api;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SearchService {
    public String urlSearchPage= "https://kupi.by/template/find/extended";
    private Response response;
    private static Logger logger = LogManager.getLogger();

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

    private String getBody(String findText) {
        String body = "{" +
                "\"charset\":\"utf-8\"," +
                "\"findtext\": \"" + findText + "\"," +
                "\"page_size\":12," +
                "\"page_num\":1," +
                "\"noContent\":true" +
                "}";
        logger.info("get body to request");
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
        logger.info("do request");
    }

    public int getElementsCount() {
       String count = response.body().jsonPath().getString("productCount");
        logger.info("get count elements");
       return Integer.parseInt(count);
    }

    public String getResponseElementName() {
        logger.info("get element name");
        return response.body().jsonPath().getString("productList.name[0]");
    }

    public int getStatusCode() {
        logger.info("get statuscode");
        return response.getStatusCode();
    }
}