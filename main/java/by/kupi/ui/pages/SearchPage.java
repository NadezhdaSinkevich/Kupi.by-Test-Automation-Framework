package by.kupi.ui.pages;

import by.kupi.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    public By searchFieldPath = By.xpath("//input[@id='form-search-input']");
    public By buttonSearchPath = By.xpath("//button[@class='form-search__button form-search__button-search button-default']");
    public By iconSearchPath = By.xpath("//button[@class='form-search__button form-search__button-search button-default']/*[local-name()=\"svg\"]/*[local-name()=\"use\"]");
    public By iconDeleteSearchPath = By.xpath("//button[@id='form-search-button-reset']/*[local-name()=\"svg\"]/*[local-name()=\"use\"]");
    public By buttonDeleteSearchPath = By.xpath("//button[@id='form-search-button-reset']");
    public By buttonSearchDropdowmPath = By.xpath("//button[@id='form-search-search-prefix']");
    public By errorMessagePath = By.xpath("//span[@class='FindTips__textNoResult']");

    public String placeholderSearchText = "поиск";
    public String iconSearchHref = "#icon-search";
    public String iconSearchDeleteHref = "#icon-close";
    public String errorMessageText = "К сожалению, ничего не найдено";
    public String buttonSearchDropdownText = "Поиск по ";

    private WebDriver driver;

    public SearchPage() {
        this.driver = Driver.getDriver();
    }

    public String getPlaceholderSearch(){
        return Driver.waitAndGetTextByAttribute(searchFieldPath,"placeholder");
    }

    public void clearFieldSearch(){
        Driver.waitAndClearField(searchFieldPath);
    }

    public String getIconSearchHref(){
        return Driver.waitAndGetTextByAttribute(iconSearchPath,"href");
    }

    public String getIconSearchDeleteHref(){
        return Driver.waitAndGetTextByAttribute(iconDeleteSearchPath,"href");
    }

    public void clickButtonSearch(){
        Driver.waitAndClick(buttonSearchPath);
    }

    public void clickButtonDeleteSearch(){
        Driver.waitAndClick(buttonDeleteSearchPath);
    }

    public void inputTextToSearch(String text){
        Driver.waitAndInputText(searchFieldPath,text);
    }

    public String getTextErrorMessageSearch(){
        return Driver.waitAndGetText(errorMessagePath);
    }

    public String makeDinamicTextSearchButton(String inputText){
        return "Поиск по \"" + inputText + "\"";
    }

    public String getTextButtonSearchDropdown(){
        return Driver.waitAndGetText(buttonSearchDropdowmPath);
    }

    public void clickButtonSearchDropdowm(){
        Driver.waitAndClick(buttonSearchDropdowmPath);
    }
}