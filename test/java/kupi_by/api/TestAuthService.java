package kupi_by.api;

import api.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import utils.DataFaker;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuthService {
    private AuthService authService = new AuthService();
    private DataFaker dataGenerate = new DataFaker();
    private static Logger logger = LogManager.getLogger(TestAuthService.class);

    @BeforeEach
    void beginTest(TestInfo testInfo) {
        logger.info("START TEST: [{}]", testInfo.getDisplayName());
    }

    @Test
    @DisplayName("testMaxBoundaryPassword")
    public void testMaxBoundaryPassword() {
        logger.info("prepare data to send request");
        authService.doRequest(authService.testEmail, dataGenerate.getMaxBoundaryPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageMaxBoundaryPassword, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testMaxBoundaryEmail")
    public void testMaxBoundaryEmail() {
        logger.info("prepare data to send request");
        authService.doRequest(dataGenerate.getMaxBoundaryEmail(), dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageMaxBoundaryEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testEmptyPassword")
    public void testEmptyPassword() {
        logger.info("prepare data to send request");
        authService.doRequest(authService.testEmail, "");
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageEmptyPassword, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testEmptyEmail")
    public void testEmptyEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageEmptyEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testSpacePassword")
    public void testSpacePassword() {
        logger.info("prepare data to send request");
        authService.doRequest(authService.testEmail, "  ");
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageEmptyPassword, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testSpaceEmptyLogin")
    public void testSpaceEmptyLogin() {
        logger.info("prepare data to send request");
        authService.doRequest("  ", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageEmptyEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testSpacesInEmail")
    public void testSpacesInEmail() {
        logger.info("prepare data to send request");
        String email = "  " + authService.testEmail + "  ";
        authService.doRequest(email, authService.testPassword);
        Assertions.assertEquals(200, authService.getStatusCode());
    }

    @Disabled
    @Test
    @DisplayName("testSpacesInPassword")
    public void testSpacesInPassword() {
        logger.info("prepare data to send request");
        String password = "  " + authService.testPassword + "  ";
        authService.doRequest(authService.testEmail, password);
        Assertions.assertEquals(200, authService.getStatusCode());
    }

    @Test
    @DisplayName("test1FormatRegexEmail")
    public void test1FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("hehe@ramblerru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test2FormatRegexEmail")
    public void test2FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("heherambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test3FormatRegexEmail")
    public void test3FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("he he@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test4FormatRegexEmail")
    public void test4FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("hehe@rambler. ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test5FormatRegexEmail")
    public void test5FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test6FormatRegexEmail")
    public void test6FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("hehe@.", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test7FormatRegexEmail")
    public void test7FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("hehe@@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }


    @Test
    @DisplayName("test8FormatRegexEmail")
    public void test8FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("hehe@ддд.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test9FormatRegexEmail")
    public void test9FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("he№$#he@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test10FormatRegexEmail")
    public void test10FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("hehe@ram№$#bler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test11FormatRegexEmail")
    public void test11FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("хехе@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test12FormatRegexEmail")
    public void test12FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("hehe@rambler.r1u", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("test13FormatRegexEmail")
    public void test13FormatRegexEmail() {
        logger.info("prepare data to send request");
        authService.doRequest("hehe@rambler.r$#u", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testIncorrectRegisteredPassword")
    public void testIncorrectRegisteredPassword() {
        logger.info("prepare data to send request");
        authService.doRequest(authService.testEmail, dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectPassword, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testUnregisteredEmail")
    public void testUnregisteredEmail() {
        logger.info("prepare data to send request");
        authService.doRequest(dataGenerate.getCorrectEmail(), dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    @DisplayName("testEmptyForm")
    public void testEmptyForm() {
        logger.info("prepare data to send request");
        authService.doRequest("", "");
        authService.getResponseErrorEmail();
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Поле E-Mail адрес обязательно для заполнения. (and 1 more error)", authService.getResponseMessage()),
                () -> assertEquals("Поле E-Mail адрес обязательно для заполнения.", authService.getResponseErrorEmail()),
                () -> assertEquals("Поле Пароль обязательно для заполнения.", authService.getResponseErrorPassword())
        );
    }

    @AfterEach
    void closeTest(TestInfo testInfo) {
        logger.info("FINISH TEST: [{}]", testInfo.getDisplayName());
        logger.info("*********************************************");
    }
}