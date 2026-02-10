package kupi_by.api;

import api.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.DataFaker;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuthService {
    private AuthService authService = new AuthService();
    private DataFaker dataGenerate = new DataFaker();

    @Test
    public void testMaxBoundaryPassword(){
        authService.doRequest(authService.testEmail,dataGenerate.getMaxBoundaryPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageMaxBoundaryPassword, authService.getResponseMessage())
        );
    }

    @Test
    public void testMaxBoundaryEmail(){
        authService.doRequest(dataGenerate.getMaxBoundaryEmail(), dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageMaxBoundaryEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void testEmptyPassword() {
        authService.doRequest(authService.testEmail,"");
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageEmptyPassword, authService.getResponseMessage())
        );
    }

    @Test
    public void testEmptyEmail() {
        authService.doRequest("", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageEmptyEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void testSpacePassword() {
        authService.doRequest(authService.testEmail, "  ");
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageEmptyPassword, authService.getResponseMessage())
        );
    }

    @Test
    public void testSpaceEmptyLogin() {
        authService.doRequest("  ", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageEmptyEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void testSpacesInEmail() {
        String email = "  " + authService.testEmail + "  ";
        authService.doRequest(email,authService.testPassword);
        Assertions.assertEquals(200, authService.getStatusCode());
    }

    @Disabled
    @Test
    public void testSpacesInPassword() {
        String password = "  " + authService.testPassword + "  ";
        authService.doRequest(authService.testEmail,password);
        Assertions.assertEquals(200, authService.getStatusCode());
    }

    @Test
    public void test1FormatRegexEmail() {
        authService.doRequest("hehe@ramblerru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test2FormatRegexEmail() {
        authService.doRequest("heherambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test3FormatRegexEmail() {
        authService.doRequest("he he@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test4FormatRegexEmail() {
        authService.doRequest("hehe@rambler. ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test5FormatRegexEmail() {
        authService.doRequest("@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test6FormatRegexEmail() {
        authService.doRequest("hehe@.", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test7FormatRegexEmail() {
        authService.doRequest("hehe@@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }


    @Test
    public void test8FormatRegexEmail() {
        authService.doRequest("hehe@ддд.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test9FormatRegexEmail() {
        authService.doRequest("he№$#he@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test10FormatRegexEmail() {
        authService.doRequest("hehe@ram№$#bler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }


    @Test
    public void test11FormatRegexEmail() {
        authService.doRequest("хехе@rambler.ru", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }


    @Test
    public void test12FormatRegexEmail() {
        authService.doRequest("hehe@rambler.r1u", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void test13FormatRegexEmail() {
        authService.doRequest("hehe@rambler.r$#u", dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectFormatEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void testIncorrectRegisteredPassword(){
        authService.doRequest(authService.testEmail, dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectPassword, authService.getResponseMessage())
        );
    }

    @Test
    public void testUnregisteredEmail(){
        authService.doRequest(dataGenerate.getCorrectEmail(), dataGenerate.getCorrectPassword());
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals(authService.errorMessageIncorrectEmail, authService.getResponseMessage())
        );
    }

    @Test
    public void testEmptyForm() {
        authService.doRequest("", "");
        authService.getResponseErrorEmail();
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Поле E-Mail адрес обязательно для заполнения. (and 1 more error)", authService.getResponseMessage()),
                () -> assertEquals("Поле E-Mail адрес обязательно для заполнения.", authService.getResponseErrorEmail()),
                () -> assertEquals("Поле Пароль обязательно для заполнения.", authService.getResponseErrorPassword())
        );
    }
}
