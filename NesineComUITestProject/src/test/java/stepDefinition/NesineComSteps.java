package stepDefinition;

import base.BaseClass;


import components.nesinePages.NesineComHomePageWithLogin;
import components.nesinePages.NesineComHomePageWithOutLogin;
import components.nesinePages.NesineComPopularBetsPageWithLogin;
import helpers.GalenFramework;
import helpers.ResponseSpec;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.PopularBetList;
import models.ResponseModel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static base.Constants.*;


public class NesineComSteps extends BaseClass {
    List<String> playedCountsForWeb = new ArrayList<>();
    List<String> matchCodesForWeb = new ArrayList<>();
    List<String> playedCountsForApi = new ArrayList<>();
    List<String> matchCodesForApi = new ArrayList<>();
    NesineComHomePageWithOutLogin homePageWithOutLogin;
    NesineComHomePageWithLogin homePageWithLogin;
    NesineComPopularBetsPageWithLogin popularBetsPageWithLogin;


    @Given("Create Browser as {string}")
    public void createBrowser(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        driver.manage().window().maximize();
        homePageWithOutLogin = new NesineComHomePageWithOutLogin(driver);
        homePageWithLogin = new NesineComHomePageWithLogin(driver);
        popularBetsPageWithLogin = new NesineComPopularBetsPageWithLogin(driver);
    }

    @And("Go to NesineCom homepage")
    public void goToNesineComHomepage() {
        driver.get(BASE_URL);
    }

    @And("Close Tutorial PopUp Or Accept Cookies")
    public void closeTutorialPopUp() {
        //PopUpHandler.acceptCookies(driver);
    }

    @When("Login")
    public void Login() {
        homePageWithOutLogin.setLogin(USER_NAME, USER_PASSWORD);
        Assert.assertEquals(MEMBER_ID, homePageWithLogin.getTextMemberId(), "User Login Failed!!!");
    }

    @And("Click Popular Bets")
    public void clickPopularBets() {
        homePageWithLogin.clickPopularBets();
    }

    @And("Check Correct url as {string}")
    public void checkCorrectURL(String url) {
        popularBetsPageWithLogin.getPlayedCounts();
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, url, "Url doesn't match!!!");
    }

    @And("Click Football Tab")
    public void clickFootballTab() {
        popularBetsPageWithLogin.clickFootballTab();
    }

    @And("Get Played Count And Code")
    public void getPlayedCountAndCode() {
        matchCodesForWeb = popularBetsPageWithLogin.getTextMatchCodes();
        playedCountsForWeb = popularBetsPageWithLogin.getTextPlayedCounts();
        Collections.sort(matchCodesForWeb);
        Collections.sort(playedCountsForWeb);
    }

    @And("Create Post as GetPopularBets Service {string}")
    public void createPostAsGetPopularBetsService(String body) {
        RestAssured.baseURI = API_URL;
        Response response = services.getPopularBets(body, ResponseSpec.checkStatusCodeOk());
        System.out.println(response.body());
        ResponseModel responseModel = response.body().as(ResponseModel.class);
        List<PopularBetList> betLists = responseModel.getPopularBetList();
        for (PopularBetList bet : betLists) {
            matchCodesForApi.add(bet.getMarketNo());
            playedCountsForApi.add(String.valueOf(bet.getPlayedCount()));
            Collections.sort(matchCodesForApi);
            Collections.sort(playedCountsForApi);
        }
    }

    @Then("Compare Service Data With Web Data")
    public void compareServiceDataWithWebData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(matchCodesForWeb, matchCodesForApi, "lists are doesn't match!!!");
        softAssert.assertEquals(playedCountsForWeb, playedCountsForApi, "lists are doesn't match!!!");
        softAssert.assertAll();
    }

    @And("Sign Out Of Account")
    public void signOutOfAccount() {
        popularBetsPageWithLogin.clickExitButton();
    }

    @And("Check Layout Login Button")
    public void checkLayoutLoginButton() throws IOException {
        homePageWithOutLogin.getLoginButton();
        GalenFramework.checkLayout(driver, NESINE_GSPEC_FILE_PATH, "desktop");
    }
}