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

    public By imageElementDropdowmPath = By.xpath("//div[@class='BlockItemTips']/a[@class='imgBlockTips']/img[@class='iconItemTips']");
    public By textElementDropdownPath = By.xpath("//div[@class='infoItemTips']/a[@class='titleTips']");
    public By priceElementDropdownPath = By.xpath("//div[@class='infoItemTips']/div[@class='itemPriceTips']/span[@class='FirstPrice']");
    public By categoriesDropdownPath = By.xpath("//div[@class='blockSectionTips']/a");

    public String placeholderSearchText = "поиск";
    public String iconSearchHref = "#icon-search";
    public String iconSearchDeleteHref = "#icon-close";
    public String errorMessageText = "К сожалению, ничего не найдено";

    public String testElementTextForSearch = "Xiaomi Book Pro 16\" OLED 2022 (Core i5-1240P, 16Gb, 512Gb, Intel Iris Xe Graphics) (JYU4468CN)";
    public String testElementImageForSearch ="https://kupi.by/pics/items/icon_20240327190306286_5787-1.jpg";
    public String testElementPriceForSearch = "5000 руб.";

    public String testCategoriesForSearch = "Товары для дома";
    public String testCategoriesHrefForSearch ="https://kupi.by/texnika-dlya-doma/";

    public String testSubcategoriesForSearch = "Кофемашины";
    public String testSubcategoriesElementTextForSearch = "Кофемашина DeLonghi Dinamica ECAM 350.15.B";
    public String testSubcategoriesElementImageForSearch ="https://kupi.by/pics/items/icon_20240924180942811_Delonghi-ECAM-350.15.B-1.jpg";
    public String testSubcategoriesElementPriceForSearch = "1460 руб.";


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

    public String getImageElementDropdowmPath(){
        return Driver.waitAndGetTextByAttribute(imageElementDropdowmPath,"src");
    }

    public String getTextElementDropdownPath(){
        return Driver.waitAndGetText(textElementDropdownPath);
    }

    public String getPriceElementDropdowm(){
        return Driver.waitAndGetText(priceElementDropdownPath);
    }

    public String getCategoriesSearchHref(){
        return Driver.waitAndGetTextByAttribute(categoriesDropdownPath,"href");
    }

    public String getTextCategoriesSearch() {
        return Driver.waitAndGetText(categoriesDropdownPath);
    }
}