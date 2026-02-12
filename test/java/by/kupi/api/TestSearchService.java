package by.kupi.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestSearchService {
    private SearchService searchService;
    private static Logger logger = LogManager.getLogger(TestAuthService.class);

    @BeforeEach
    void beginTest(TestInfo testInfo) {
        searchService = new SearchService();
        logger.info("START TEST: [{}]", testInfo.getDisplayName());
    }

    @Test
    @DisplayName("test")
    public void testElementSearch() {
        searchService.doRequest(searchService.testElementForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementForSearch))
        );
    }
    @Test
    @DisplayName("test")
    public void testCategoriesSearch() {
        searchService.doRequest(searchService.testCategoriesForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertEquals(0, searchService.getElementsCount())
        );
    }

    @Test
    @DisplayName("test")
    public void testSubcategoriesSearch() {
        searchService.doRequest(searchService.testSubcategoriesForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount() > 0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testSubcategoriesForSearch))
        );
    }

    @Test
    @DisplayName("test")
    public void testEmptySearch() {
        searchService.doRequest("");
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount() > 0)
        );
    }

    @Test
    @DisplayName("test")
    public void testOutStockSearch() {
        searchService.doRequest(searchService.testElementOutStockForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementOutStockForSearch))
        );
    }

    @Test
    @DisplayName("test")
    public void testElementPartialForSearch() {
        searchService.doRequest(searchService.testElementPartialForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementPartialForSearch))
        );
    }

    @Test
    @DisplayName("test")
    public void testElementRegistrDependencyForSearch() {
        searchService.doRequest(searchService.testElementRegistrDependencyForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().toLowerCase().contains(searchService.testElementRegistrDependencyForSearch.toLowerCase()))
        );
    }

    @Test
    @DisplayName("test")
    public void testDoubleElementForSearch() {
        searchService.doRequest(searchService.testElementForSearch+searchService.testElementForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue( searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementForSearch))
        );
    }

    @Test
    @DisplayName("test")
    public void testIncorrectSymbolsForSearch() {
        searchService.doRequest(searchService.testIncorrectSymbolsForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertEquals(0, searchService.getElementsCount())
        );
    }

    @Test
    @DisplayName("test")
    public void testElementSpaces() {
        searchService.doRequest("      "+searchService.testElementForSearch + "        ");
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementForSearch))
        );
    }

    @Test
    @DisplayName("test")
    public void testElementSpacesIn() {
        searchService.doRequest(searchService.testElementSpacesForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue( searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().replaceAll("\\s", "").contains(searchService.testElementSpacesForSearch.replaceAll("\\s", "")))
        );
    }

    @AfterEach
    void closeTest(TestInfo testInfo) {
        logger.info("FINISH TEST: [{}]", testInfo.getDisplayName());
        logger.info("*********************************************");
    }
}