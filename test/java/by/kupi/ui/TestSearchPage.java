package by.kupi.ui;

import by.kupi.driver.Driver;
import by.kupi.ui.pages.HomePage;
import by.kupi.ui.pages.LoginPage;
import by.kupi.ui.pages.SearchPage;
import by.kupi.utils.DataFaker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSearchPage {
    private SearchPage searchPage;
    private HomePage homePage;
    private DataFaker dataGenerate = new DataFaker();

    @BeforeEach
    public void openHomePageAndCloseCookiesAndClickEnter() {
        homePage = new HomePage();
        homePage.open();
        homePage.acceptCookie();
        searchPage = new SearchPage();
    }

    @Test
    public void testPlaceholderSearch(){
        Assertions.assertEquals(searchPage.getPlaceholderSearch(),searchPage.placeholderSearchText,"placeholder incorrect");
    }

    @Test
    public void testPlaceholderSearchAfterCleaningField(){
        searchPage.inputTextToSearch(dataGenerate.getCorrectPassword());
        searchPage.clearFieldSearch();
        Assertions.assertEquals(searchPage.placeholderSearchText,searchPage.getPlaceholderSearch(),"placeholder incorrect");
    }

    @Test
    public void testIconIconSearch(){
        Assertions.assertEquals(searchPage.iconSearchHref,searchPage.getIconSearchHref(),"href Icon incorrect");
    }

    @Test
    public void testIconIconDeleteSearch(){
        searchPage.inputTextToSearch(dataGenerate.getCorrectPassword());
        Assertions.assertEquals(searchPage.iconSearchDeleteHref,searchPage.getIconSearchDeleteHref(),"href Icon incorrect");
    }

    @Test
    public void testClickButtonSearch(){
        searchPage.clickButtonSearch();
    }

    @Test
    public void testClickButtonDeleteSearch(){
        searchPage.inputTextToSearch(dataGenerate.getCorrectPassword());
        searchPage.clickButtonDeleteSearch();
    }

    @Test
    public void testErrorMessageSearch(){
        searchPage.inputTextToSearch(dataGenerate.getCorrectPassword());
        Assertions.assertEquals(searchPage.errorMessageText,searchPage.getTextErrorMessageSearch(),"error message incorrect");
    }

    @Test
    public void testTextButtonSearchDropdowm(){
        String inputText = dataGenerate.getCorrectPassword();
        searchPage.inputTextToSearch(inputText);
        Assertions.assertEquals(searchPage.makeDinamicTextSearchButton(inputText),searchPage.getTextButtonSearchDropdown(),"search text incorrect");
    }

    @Test
    public void testClickButtonSearchDropdown(){
        searchPage.inputTextToSearch(dataGenerate.getCorrectPassword());
        searchPage.clickButtonSearchDropdowm();
    }

    @AfterEach
    public void closeHomePage() {
        Driver.quitDriver();
    }
}
