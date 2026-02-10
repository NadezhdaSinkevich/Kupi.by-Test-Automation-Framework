package by.kupi.ui.pages;

import by.kupi.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public String homepageUrl = "https://kupi.by";

    public By buttonLoginPath = By.xpath("//ul[@class='header__main-controls main-controls']/li[@class='main-controls__item'][1]/button[@class='button-main-controls']");
    public By iconButtonLoginPath = By.xpath("//ul[@class='header__main-controls main-controls']/li[@class='main-controls__item'][1]/button[@class='button-main-controls']/*[local-name()=\"svg\"]/*[local-name()=\"use\"]");
    public By textButtonLoginPath = By.xpath("//*[@id=\"header\"]/div[2]/div/ul[1]/li[1]/button/span");
    public By cookieAcceptButtonPath = By.xpath("//div[@id='ck-pup-default']/div[@class='pup-ck__buttons']/button[@class='pup-ck__button pup-ck__button--primary']");

    public String iconButtonLoginHref = "#icon-account";
    public String textButtonLogin = "Войти";

    public WebDriver driver;
    private static Logger logger = LogManager.getLogger();

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    public void open(){
        logger.info("open home page");
        driver.get(homepageUrl);
    }

    public void acceptCookie(){
        logger.info("accept cookie");
        Driver.waitAndClick(cookieAcceptButtonPath);
    }

    public void clickButtonLogin(){
        logger.info("click button login");
        Driver.waitAndClick(buttonLoginPath);
    }

    public String getIconButtonLogin(){
        return Driver.waitAndGetTextByAttribute(iconButtonLoginPath,"href");
    }

    public String getTextButtonLogin(){
        return Driver.waitAndGetTextByAttribute(textButtonLoginPath,"textContent");
    }
}
