package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static WebElement wait(By xpath) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    public static void waitAndClick(By xpath) {
        wait(xpath).click();
    }

    public static String waitAndGetText(By xpath){
        return wait(xpath).getText();
    }

    public static String waitAndGetTextByAttribute(By xpath, String attribute){
        return wait(xpath).getAttribute(attribute);
    }

    public static void waitAndInputText(By xpath, String text){
        wait(xpath).sendKeys(text);
    }
}