package base;

import org.testng.annotations.AfterSuite;
import services.responseServices.NesineComServices;
import org.openqa.selenium.WebDriver;

import static base.Constants.API_URL;


public class BaseClass {
    public static WebDriver driver;
    protected NesineComServices services;
    public BaseClass(){
        services= new NesineComServices(API_URL);
    }


    @AfterSuite
    public void afterMethod() {
        driver.quit();
    }

}
