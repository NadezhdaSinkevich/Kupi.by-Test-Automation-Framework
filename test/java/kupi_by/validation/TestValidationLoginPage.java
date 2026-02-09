package kupi_by.validation;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestValidationLoginPage {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    public void openHomePageAndCloseCookiesAndClickEnter() {
        homePage = new HomePage();
        homePage.open();
        homePage.acceptCookie();
        homePage.clickButtonLogin();
        loginPage = new LoginPage();
    }

    @Test
    public void testMinBoundaryPassword(){
        loginPage.inputPassword("ddd");
        loginPage.inputEmail(loginPage.testEmail);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Количество символов должно быть не менее 4.",loginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testMaxBoundaryPassword(){
        loginPage.inputPassword("qqqqqqqqqqqqqqqqqqqqqqqqqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwweeeeeeeeeeeeeeeeeeeeeeeeeqq");
        loginPage.inputEmail(loginPage.testEmail);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Количество символов в поле Пароль не может превышать 255.",loginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testMaxBoundaryEmail(){
        loginPage.inputEmail("qQqqqqqqqqqqqqqqqqqqqqqqqqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqwwwwwwwwwwwwwwwwwwwwwwwwww5wwwweeeeeeeeeeeeeeeeeeeeeeeeeqqqqqqqe@rambler.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Количество символов в поле E-Mail адрес не может превышать 255.",loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void testEmptyPassword(){
        loginPage.inputPassword("");
        loginPage.inputEmail(loginPage.testEmail);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Поле не может быть пустым", loginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testEmptyEmail(){
        loginPage.inputEmail("");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Поле не может быть пустым", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void testSpacesPassword(){
        loginPage.inputPassword("  ");
        loginPage.inputEmail(loginPage.testEmail);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Поле не может быть пустым", loginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testSpacesEmail(){
        loginPage.inputEmail("  ");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Поле не может быть пустым", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test1FormatRegexEmail(){
        loginPage.inputEmail("hehe@ramblerru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test2FormatRegexEmail(){
        loginPage.inputEmail("heherambler.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test3FormatRegexEmail(){
        loginPage.inputEmail("he he@rambler.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test4FormatRegexEmail(){
        loginPage.inputEmail("hehe@rambler. ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test5FormatRegexEmail(){
        loginPage.inputEmail("@rambler.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test6FormatRegexEmail(){
        loginPage.inputEmail("hehe@.");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test7FormatRegexEmail(){
        loginPage.inputEmail("hehe@@rambler.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test8FormatRegexEmail(){
        loginPage.inputEmail("hehe@ддд.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test9FormatRegexEmail(){
        loginPage.inputEmail("he№$#he@rambler.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test10FormatRegexEmail(){
        loginPage.inputEmail("hehe@ram№$#bler.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test11FormatRegexEmail(){
        loginPage.inputEmail("хехе@rambler.ru");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test12FormatRegexEmail(){
        loginPage.inputEmail("hehe@rambler.r1u");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test13FormatRegexEmail(){
        loginPage.inputEmail("hehe@rambler.r$#u");
        loginPage.inputPassword(loginPage.testPassword);
        loginPage.clickButtonLogin();
        Assertions.assertEquals("Неверный email", loginPage.getTextErrorMessageEmail());
    }

    @AfterEach
    public void closeLoginPage() {
        Driver.quitDriver();
    }
}