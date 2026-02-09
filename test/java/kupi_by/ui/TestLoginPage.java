package kupi_by.ui;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.DataFaker;

public class TestLoginPage {

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
    public void testLabelMain(){
       Assertions.assertEquals(loginPage.labelMainText,loginPage.getLabelMain(),"text Label Main incorrect");
   }

    @Test
    public void testPlaceholderEmail(){
        Assertions.assertEquals(loginPage.placeholderEmailText,loginPage.getPlaceholderEmail(),"placeholder Email incorrect");
    }

    @Test
    public void testPlaceholderPassword(){
        Assertions.assertEquals(loginPage.placeholderPasswordText,loginPage.getPlaceholderPassword(),"placeholder Password incorrect");
    }

    @Test
    public void testPlaceholderEmailAfterCleaningField(){
        loginPage.inputEmail(dataGenerate.getCorrectEmail());
        loginPage.clearFieldEmail();
        Assertions.assertEquals(loginPage.placeholderEmailText,loginPage.getPlaceholderEmail(),"placeholder Email incorrect");
    }

    @Test
    public void testPlaceholderPasswordAfterCleaningField(){
        loginPage.inputPassword(dataGenerate.getCorrectPassword());
        loginPage.clearFieldPassword();
        Assertions.assertEquals(loginPage.placeholderPasswordText,loginPage.getPlaceholderPassword(),"placeholder Password incorrect");
    }

    @Test
    public void testTextButtonLogin(){
        Assertions.assertEquals(loginPage.buttonLoginText,loginPage.getTextButtonLogin(),"text Button Login incorrect");
    }

    @Test
    public void testTextButtonForgotPassword(){
        Assertions.assertEquals(loginPage.buttonForgotPasswordText, loginPage.getTextButtonForgotPassword(),"text Button Forgot Password incorrect");
    }

    @Test
    public void testTextButtonRegistration(){
        Assertions.assertEquals(loginPage.buttonRegistrationText, loginPage.getTextButtonRegistration(),"text Button Registration incorrect");
    }

    @Test
    public void testClickButtonCloseLoginForm(){
        loginPage.clickButtonCloseLoginForm();
    }

    @Test
    public void testClickButtonForgotPassword(){
        loginPage.clickButtonForgotPassword();
    }

    @Test
    public void testClickButtonRegistration(){
        loginPage.clickButtonRegistration();
    }

    @Test
    public void testIconCloseLoginPageHref(){
        Assertions.assertEquals(loginPage.iconCloseLoginPageHref,loginPage.getIconCloseLoginPageHref(),"href Icon Close Button incorrect");
    }

    @AfterEach
    public void closeLoginPage() {
        Driver.quitDriver();
    }
}
