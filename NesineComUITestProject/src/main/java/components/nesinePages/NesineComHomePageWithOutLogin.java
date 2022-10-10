package components.nesinePages;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NesineComHomePageWithOutLogin extends BasePages {

    private final WebDriver driver;

    public NesineComHomePageWithOutLogin(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@id='realpass']")
    private WebElement userPasswordField;
    @FindBy(xpath = "//a[text()='GİRİŞ']")
    private WebElement loginButton;

    public WebElement getUserNameField() {
        CustomElementWaits.waitUntilElementToClickable(driver, userNameField);
        return userNameField;
    }

    public WebElement getUserPasswordField() {
        CustomElementWaits.waitUntilElementToClickable(driver, userPasswordField);
        return userPasswordField;
    }

    public WebElement getLoginButton() {
        CustomElementWaits.waitUntilElementToClickable(driver, loginButton);
        return loginButton;
    }

    public void setLogin(String userName, String userPassword) {
        getUserNameField().sendKeys(userName);
        getUserPasswordField().sendKeys(userPassword);
        getLoginButton().click();
    }
}
