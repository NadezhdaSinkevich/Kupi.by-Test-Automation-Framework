package by.kupi.validation;

import by.kupi.ui.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import by.kupi.ui.pages.HomePage;
import by.kupi.ui.pages.LoginPage;
import by.kupi.ui.utils.DataFaker;

public class TestValidationLoginPage {
    private LoginPage loginPage;
    private HomePage homePage;
    private DataFaker dataGenerate = new DataFaker();

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
        loginPage.inputPassword(dataGenerate.getMinBoundaryPassword());
        loginPage.inputEmail(dataGenerate.getCorrectEmail());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageMinBoundary,loginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testMaxBoundaryPassword(){
        loginPage.inputPassword(dataGenerate.getMaxBoundaryPassword());
        loginPage.inputEmail(dataGenerate.getCorrectEmail());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageMaxBoundaryPassword,loginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testMaxBoundaryEmail(){
        loginPage.inputEmail(dataGenerate.getMaxBoundaryEmail());
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageMaxBoundaryEmail,loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void testEmptyPassword(){
        loginPage.inputPassword("");
        loginPage.inputEmail(dataGenerate.getCorrectEmail());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageEmptyField, loginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testEmptyEmail(){
        loginPage.inputEmail("");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageEmptyField, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void testSpacesPassword(){
        loginPage.inputPassword("  ");
        loginPage.inputEmail(dataGenerate.getCorrectEmail());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageEmptyField, loginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testSpacesEmail(){
        loginPage.inputEmail("  ");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageEmptyField, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test1FormatRegexEmail(){
        loginPage.inputEmail("hehe@ramblerru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test2FormatRegexEmail(){
        loginPage.inputEmail("heherambler.ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test3FormatRegexEmail(){
        loginPage.inputEmail("he he@rambler.ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test4FormatRegexEmail(){
        loginPage.inputEmail("hehe@rambler. ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test5FormatRegexEmail(){
        loginPage.inputEmail("@rambler.ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test6FormatRegexEmail(){
        loginPage.inputEmail("hehe@.");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test7FormatRegexEmail(){
        loginPage.inputEmail("hehe@@rambler.ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test8FormatRegexEmail(){
        loginPage.inputEmail("hehe@ддд.ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test9FormatRegexEmail(){
        loginPage.inputEmail("he№$#he@rambler.ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test10FormatRegexEmail(){
        loginPage.inputEmail("hehe@ram№$#bler.ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test11FormatRegexEmail(){
        loginPage.inputEmail("хехе@rambler.ru");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test12FormatRegexEmail(){
        loginPage.inputEmail("hehe@rambler.r1u");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @Test
    public void test13FormatRegexEmail(){
        loginPage.inputEmail("hehe@rambler.r$#u");
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clickButtonLogin();
        Assertions.assertEquals(loginPage.errorMessageIncorrectFormatEmail, loginPage.getTextErrorMessageEmail());
    }

    @AfterEach
    public void closeLoginPage() {
       Driver.quitDriver();
    }
}