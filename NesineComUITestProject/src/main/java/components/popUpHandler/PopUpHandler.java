package components.popUpHandler;

import helpers.CustomElementWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpHandler {
    public static void tutorialPopUpClose(WebDriver driver){
        CustomElementWaits.waitUntilElementToClickable(driver, driver.findElement(By.xpath("//div[@id='tutorial']//button[text()='Kapat']")));
        driver.findElement(By.xpath("//div[@id='tutorial']//button[text()='Kapat']")).click();
    }
    public static void acceptCookies(WebDriver driver){
        CustomElementWaits.waitUntilElementToClickable(driver, driver.findElement(By.xpath("//button[text()='Kabul Et']")));
        driver.findElement(By.xpath("//button[text()='Kabul Et']")).click();
    }
}
