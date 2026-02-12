package by.kupi.ui.pages;

import by.kupi.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public By labelMainPath = By.xpath("//form[@class='form-authorization form _show']/div[@class='form__title']");
    public By emailPath = By.xpath("//input[@id='form-authorization-email']");
    public By passwordPath = By.xpath("//input[@id='form-authorization-password']");
    public By buttonLoginPath = By.xpath("//button[@class='form-authorization__button form-button-primary']");
    public By errorMessageEmailPath = By.xpath("//form[@id='form-authorization']/div[@class='form-field'][1]/div[@class='form-field-error-message']");
    public By errorMessagePasswordPath = By.xpath("//form[@id='form-authorization']/div[@class='form-field'][2]/div[@class='form-field-error-message']");
    public By buttonForgotPasswordPath = By.xpath("//div[@class='form-field']/button[@class='form-authorization__button form-button-default']");
    public By buttonRegistrationPath = By.xpath("//div[@class='form-field form-field--center']/button[@class='form-authorization__button form-button-default']");
    public By buttonCloseLoginPagePath = By.xpath("//div[@class='dialog-authorization__inner']/button[@class='button-close button']");
    public By iconCloseLoginPagePath = By.xpath("//div[@class='dialog-authorization__inner']/button[@class='button-close button']/*[local-name()=\"svg\"]/*[local-name()=\"use\"]");

    public String labelMainText = "Личный кабинет";
    public String placeholderEmailText = "Ваш email";
    public String placeholderPasswordText = "Пароль";
    public String buttonLoginText = "Войти";
    public String buttonForgotPasswordText = "Забыли пароль?";
    public String buttonRegistrationText = "Зарегистрироваться";
    public String iconCloseLoginPageHref = "#icon-close";

    public String testEmail = "hehe@rambler.ru";
    public String testPassword = "qwerty";

    public String errorMessageMinBoundary = "Количество символов должно быть не менее 4.";
    public String errorMessageMaxBoundaryPassword = "Количество символов в поле Пароль не может превышать 255.";
    public String errorMessageMaxBoundaryEmail = "Количество символов в поле E-Mail адрес не может превышать 255.";
    public String errorMessageEmptyField = "Поле не может быть пустым";
    public String errorMessageIncorrectFormatEmail = "Неверный email";


    private WebDriver driver;
    private static Logger logger = LogManager.getLogger();

    public LoginPage() {
        logger.info("open login page");
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

    public void clearFieldPassword(){
        Driver.waitAndClearField(passwordPath);
    }

    public void clearFieldEmail(){
        Driver.waitAndClearField(emailPath);
    }

    public String getTextButtonLogin(){
        return Driver.waitAndGetText(buttonLoginPath);
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
        logger.info("click button login");
        Driver.waitAndClick(buttonLoginPath);
    }

    public String getTextButtonForgotPassword(){
        return Driver.waitAndGetText(buttonForgotPasswordPath);
    }

    public String getTextButtonRegistration(){
        return Driver.waitAndGetText(buttonRegistrationPath);
    }

    public void clickButtonCloseLoginForm(){
        logger.info("click button close login form");
        Driver.waitAndClick(buttonCloseLoginPagePath);
    }

    public void clickButtonForgotPassword(){
        logger.info("click button forgot password");
        Driver.waitAndClick(buttonForgotPasswordPath);
    }

    public void clickButtonRegistration(){
        logger.info("click button registration");
        Driver.waitAndClick(buttonRegistrationPath);
    }

    public String getIconCloseLoginPageHref(){
        return Driver.waitAndGetTextByAttribute(iconCloseLoginPagePath,"href");
    }

    public String getTextFieldLogin(){
        return Driver.waitAndGetTextByAttribute(emailPath,"value");
    }

    public String getTextFieldPassword(){
        return Driver.waitAndGetTextByAttribute(passwordPath,"value");
    }
}
