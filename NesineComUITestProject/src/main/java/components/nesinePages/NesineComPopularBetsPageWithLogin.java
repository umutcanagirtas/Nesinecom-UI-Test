package components.nesinePages;

import base.BasePages;
import helpers.ActionClass;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class NesineComPopularBetsPageWithLogin extends BasePages {
    private final WebDriver driver;

    public NesineComPopularBetsPageWithLogin(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='nsn-popularBets']//button[text()='Futbol']")
    private WebElement footballTab;
    @FindBy(xpath = "//div[@class='matchCode']")
    private List<WebElement> matchCodes;
    @FindBy(xpath = "//div[@class='playedCount']")
    private List<WebElement> playedCounts;
    @FindBy(xpath = "//a[text()='Hesabım ']")
    private WebElement account;
    @FindBy(xpath = "//a[text()='Çıkış']")
    private WebElement accountExitButton;
    @FindBy(xpath = "//h1[@class='pageTitle'][text()='POPÜLER BAHİSLER']")
    private WebElement popularBetsPageTitle;

    public WebElement getPopularBetsPageTitle() {
        CustomElementWaits.waitUntilElementFind(driver,popularBetsPageTitle);
        return popularBetsPageTitle;
    }

    public WebElement getAccount() {
        CustomElementWaits.waitUntilElementFind(driver,account);
        return account;
    }

    public WebElement getAccountExitButton() {
        CustomElementWaits.waitUntilElementToClickable(driver,accountExitButton);
        return accountExitButton;
    }

    public List<WebElement> getMatchCodes() {
        CustomElementWaits.visibilityOfAllElements(driver, matchCodes);
        return matchCodes;
    }

    public List<WebElement> getPlayedCounts() {
        CustomElementWaits.visibilityOfAllElements(driver, playedCounts);
        return playedCounts;
    }

    public WebElement getFootballTab() {
        CustomElementWaits.waitUntilElementToClickable(driver, footballTab);
        return footballTab;
    }

    public void clickFootballTab() {
        getFootballTab().click();
    }

    public List<String> getTextMatchCodes() {
        List<String> codes = new ArrayList<>();
        for (WebElement code : getMatchCodes()) {
            codes.add(code.getText());
        }
        return codes;
    }

    public List<String> getTextPlayedCounts() {
        List<String> counts = new ArrayList<>();
        for (WebElement count : getPlayedCounts()) {
            counts.add(count.getText());
        }
        return counts;
    }
    public void clickExitButton(){
        ActionClass.moveToMouseOnElement(driver,getAccount());
        ActionClass.moveToMouseOnElement(driver,getAccountExitButton());
        getAccountExitButton().click();
    }

}
