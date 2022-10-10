package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
    public static void moveToMouseOnElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public static void performClick(WebDriver driver) {
        new Actions(driver).click().build().perform();
    }
    public static void moveToElement(WebDriver driver,WebElement element){
        new Actions(driver).moveToElement(element);
    }
}
