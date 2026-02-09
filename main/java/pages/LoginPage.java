package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public By labelMainPath = By.xpath("//form[@class='form-authorization form _show']/div[@class='form__title']");
    public By emailPath = By.xpath("//input[@id='form-authorization-email']");
    public By passwordPath = By.xpath("//input[@id='form-authorization-password']");
    public By textButtonLoginPath = By.xpath("//button[@class='form-authorization__button form-button-primary']");
    public By errorMessageEmailPath = By.xpath("//form[@id='form-authorization']/div[@class='form-field'][1]/div[@class='form-field-error-message']");
    public By errorMessagePasswordPath = By.xpath("//form[@id='form-authorization']/div[@class='form-field'][2]/div[@class='form-field-error-message']");
    public By buttonLoginPath = By.xpath("//button[@class='form-authorization__button form-button-primary']");

    public String labelMainText = "Личный кабинет";
    public String placeholderEmailText = "Ваш email";
    public String placeholderPasswordText = "Пароль";
    public String buttonLoginText = "Войти";

    public String testEmail = "hehe@rambler.ru";
    public String testPassword = "qwerty";

    public String errorMessageMinBoundary = "Количество символов должно быть не менее 4.";
    public String errorMessageMaxBoundaryPassword = "Количество символов в поле Пароль не может превышать 255.";
    public String errorMessageMaxBoundaryEmail = "Количество символов в поле E-Mail адрес не может превышать 255.";
    public String errorMessageEmptyField = "Поле не может быть пустым";
    public String errorMessageIncorrectFormatEmail = "Неверный email";


    private WebDriver driver;

    public LoginPage() {
        this.driver = Driver.getDriver();
    }

    public String getLabelMain(){
       return Driver.waitAndGetText(labelMainPath);
    }

    public String getPlaceholderEmail(){
        return Driver.waitAndGetTextByAttribute(emailPath,"placeholder");
    }

    public String getPlaceholderPassword(){
        return Driver.waitAndGetTextByAttribute(passwordPath,"placeholder");
    }

    public String getTextButtonLogin(){
        return Driver.waitAndGetText(textButtonLoginPath);
    }

    public String getTextErrorMessageEmail(){
        return Driver.waitAndGetText(errorMessageEmailPath);
    }

    public String getTextErrorMessagePassword(){
        return Driver.waitAndGetText(errorMessagePasswordPath);
    }

    public void inputEmail(String text){
        Driver.waitAndInputText(emailPath,text);
    }

    public void inputPassword(String text){
        Driver.waitAndInputText(passwordPath,text);
    }

    public void clickButtonLogin(){
        Driver.waitAndClick(buttonLoginPath);
    }
}
