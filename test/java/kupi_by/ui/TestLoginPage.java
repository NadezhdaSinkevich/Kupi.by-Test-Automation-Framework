package kupi_by.ui;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestLoginPage {

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
    public void testTextButtonLogin(){
        Assertions.assertEquals(loginPage.buttonLoginText,loginPage.getTextButtonLogin(),"text Button Login incorrect");
    }

    @AfterEach
    public void closeLoginPage() {
        Driver.quitDriver();
    }
}
