package components.nesinePages;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NesineComHomePageWithLogin extends BasePages {
    private final WebDriver driver;
    public NesineComHomePageWithLogin(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    @FindBy(xpath = "//b[@id='spnMemberId']")
    private WebElement memberId;
    @FindBy(xpath = "//i[@class='popular-bets']")
    private WebElement popularBets;

    public WebElement getMemberId() {
        CustomElementWaits.waitUntilElementFind(driver,memberId);
        return memberId;
    }

    public WebElement getPopularBets() {
        CustomElementWaits.waitUntilElementToClickable(driver,popularBets);
        return popularBets;
    }
    public String getTextMemberId(){
        return getMemberId().getText();
    }
    public void clickPopularBets(){
        getPopularBets().click();
    }
}
