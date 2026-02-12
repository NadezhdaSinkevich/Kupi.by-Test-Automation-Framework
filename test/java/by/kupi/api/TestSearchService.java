package by.kupi.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestSearchService {
    private SearchService searchService;
    private static Logger logger = LogManager.getLogger(TestSearchService.class);

    @BeforeEach
    void beginTest(TestInfo testInfo) {
        searchService = new SearchService();
        logger.info("START TEST: [{}]", testInfo.getDisplayName());
    }

    @Test
    @DisplayName("testElementSearch")
    public void testElementSearch() {
        logger.info("prepare data to send request");
        searchService.doRequest(searchService.testElementForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementForSearch))
        );
    }
    @Test
    @DisplayName("testCategoriesSearch")
    public void testCategoriesSearch() {
        logger.info("prepare data to send request");
        searchService.doRequest(searchService.testCategoriesForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertEquals(0, searchService.getElementsCount())
        );
    }

    @Test
    @DisplayName("testSubcategoriesSearch")
    public void testSubcategoriesSearch() {
        logger.info("prepare data to send request");
        searchService.doRequest(searchService.testSubcategoriesForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount() > 0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testSubcategoriesForSearch))
        );
    }

    @Test
    @DisplayName("testEmptySearch")
    public void testEmptySearch() {
        logger.info("prepare data to send request");
        searchService.doRequest("");
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount() > 0)
        );
    }

    @Test
    @DisplayName("testOutStockSearch")
    public void testOutStockSearch() {
        logger.info("prepare data to send request");
        searchService.doRequest(searchService.testElementOutStockForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementOutStockForSearch))
        );
    }

    @Test
    @DisplayName("testElementPartialForSearch")
    public void testElementPartialForSearch() {
        logger.info("prepare data to send request");
        searchService.doRequest(searchService.testElementPartialForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementPartialForSearch))
        );
    }

    @Test
    @DisplayName("testElementRegistrDependencyForSearch")
    public void testElementRegistrDependencyForSearch() {
        logger.info("prepare data to send request");
        searchService.doRequest(searchService.testElementRegistrDependencyForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().toLowerCase().contains(searchService.testElementRegistrDependencyForSearch.toLowerCase()))
        );
    }

    @Test
    @DisplayName("testDoubleElementForSearch")
    public void testDoubleElementForSearch() {
        logger.info("prepare data to send request");
        searchService.doRequest(searchService.testElementForSearch+searchService.testElementForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue( searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementForSearch))
        );
    }

    @Test
    @DisplayName("testIncorrectSymbolsForSearch")
    public void testIncorrectSymbolsForSearch() {
        logger.info("prepare data to send request");
        searchService.doRequest(searchService.testIncorrectSymbolsForSearch);
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertEquals(0, searchService.getElementsCount())
        );
    }

    @Test
    @DisplayName("testElementSpaces")
    public void testElementSpaces() {
        logger.info("prepare data to send request");
        searchService.doRequest("      "+searchService.testElementForSearch + "        ");
        assertAll(
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getElementsCount()>0),
                () -> assertTrue(searchService.getResponseElementName().contains(searchService.testElementForSearch))
        );
    }

    @Test
    @DisplayName("testElementSpacesIn")
    public void testElementSpacesIn() {
        logger.info("prepare data to send request");
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
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}