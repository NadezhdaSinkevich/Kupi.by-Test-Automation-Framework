package kupi_by.api;

import api.AuthService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuthService {

    @Test
    public void testEmptyPassword() {
        AuthService authService = new AuthService();
        authService.doRequest("hehe@rambler.ru", "");

        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Поле Пароль обязательно для заполнения.", authService.getResponseMessage())
        );
    }

    @Test
    public void testEmptyLogin() {
        AuthService authService = new AuthService();
        authService.doRequest("", "12344556qwertyy");

        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Поле E-Mail адрес обязательно для заполнения.", authService.getResponseMessage())
        );
    }

    @Test
    public void testSpacePassword() {
        AuthService authService = new AuthService();
        authService.doRequest("hehe@rambler.ru", "  ");

        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Поле Пароль обязательно для заполнения.", authService.getResponseMessage())
        );
    }

    @Test
    public void testSpaceEmptyLogin() {
        AuthService authService = new AuthService();
        authService.doRequest("  ", "12344556qwertyy");

        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Поле E-Mail адрес обязательно для заполнения.", authService.getResponseMessage())
        );
    }

    @Test
    public void testIncorrectFormatLogin() {
        AuthService authService = new AuthService();
        authService.doRequest("qwerty123", "12344556qwertyy");

        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Поле E-Mail адрес должно быть действительным электронным адресом.", authService.getResponseMessage())
        );
    }

    @Test
    public void testUnauthorizedUser() {
        AuthService authService = new AuthService();
        authService.doRequest("qwerty123@rambler.ru", "12344556qwertyy");

        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Выбранное значение для E-Mail адрес некорректно.", authService.getResponseMessage())
        );
    }

    @Test
    public void testErrorPasswordAuthorizedUser() {
        AuthService authService = new AuthService();
        authService.doRequest("hehe@rambler.ru", "qwe");

        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Выбранное значение для Пароль ошибочно.", authService.getResponseMessage())
        );
    }

    //???? errors
    @Test
    public void testEmptyForm() {
        AuthService authService = new AuthService();
        authService.doRequest("", "");
        authService.getResponseError();
/*
        assertAll(
                () -> assertEquals(422, authService.getStatusCode()),
                () -> assertEquals("Поле E-Mail адрес обязательно для заполнения.", authService.getResponseError()),
                () -> assertEquals("Поле Пароль обязательно для заполнения.", authService.getResponseError())
        );

 */
    }
}
