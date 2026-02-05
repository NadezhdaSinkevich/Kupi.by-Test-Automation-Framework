package kupi_by.ui;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class TestHomePage {
    public HomePage homePage;

    @BeforeEach
    public void openHomePageAndAcceptCookie(){
        homePage = new HomePage();
        homePage.open();
        homePage.acceptCookie();
    }

    @Test
    public void testClickButtonLogin(){
        homePage.clickButtonLogin();
    }

    @Test
    public void testIconButtonLogin(){
        Assertions.assertEquals(homePage.iconButtonLoginHref,homePage.getIconButtonLogin());
    }

    @Test
    public void testTextButtonLogin(){
        Assertions.assertEquals(homePage.textButtonLogin,homePage.getTextButtonLogin());
    }

    @AfterEach
    public void closeHomePage(){
        Driver.quitDriver();
    }

}
