package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public By labelMainPath = By.xpath("//form[@class='form-authorization form _show']/div[@class='form__title']");
    public By placeholderEmailPath = By.xpath("//input[@id='form-authorization-email']");
    public By placeholderPasswordPath = By.xpath("//input[@id='form-authorization-password']");
    public By textButtonLoginPath = By.xpath("//button[@class='form-authorization__button form-button-primary']");

    public String labelMainText = "Личный кабинет";
    public String placeholderEmailText = "Ваш email";
    public String placeholderPasswordText = "Пароль";
    public String buttonLoginText = "Войти";

    private WebDriver driver;

    public LoginPage() {
        this.driver = Driver.getDriver();
    }

    public String getLabelMain(){
       return Driver.waitAndGetText(labelMainPath);
    }

    public String getPlaceholderEmail(){
        return Driver.waitAndGetTextByAttribute(placeholderEmailPath,"placeholder");
    }

    public String getPlaceholderPassword(){
        return Driver.waitAndGetTextByAttribute(placeholderPasswordPath,"placeholder");
    }

    public String getTextButtonLogin(){
        return Driver.waitAndGetText(textButtonLoginPath);
    }
}
