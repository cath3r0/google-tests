package test_suite;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_model.GoogleHomePage;
import ui_model.GoogleResultPage;
import ui_model.GoogleTranslatePage;

import java.util.List;

public class StepDefs {

    private WebDriver browser = null;
    private GoogleHomePage googleHomePage;
    private GoogleTranslatePage googleTranslatePage;
    private GoogleResultPage googleResultPage;
    private String buff;
    private int numberOfResults1, numberOfResults2, numberOfResults10;


    private static final int STANDARD_WAIT_TIME = 10;

    private void waitUntilElementIsVisible(WebElement element) {
        new WebDriverWait(browser, STANDARD_WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    }

    private void waitUntilElementsAreVisible(List<WebElement> list) {
        new WebDriverWait(browser, STANDARD_WAIT_TIME).until(ExpectedConditions.visibilityOfAllElements(list));
    }

    @Before
    public void testSetUp() {
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
        googleHomePage = GoogleHomePage.init(browser);
        googleTranslatePage = GoogleTranslatePage.init(browser);
        googleResultPage = GoogleResultPage.init(browser);
    }

    @Given("^User is on Google Home Page$")
    public void goToGoogleHomePage() {
        browser.get("http://www.google.com.ua/");
    }

    @When("^User enters \"(apple|translate.google.com)\" in search field$")
    public void fillSearchField(String searchWord) {
        googleHomePage.sendKeysToSearchField(searchWord);
        googleHomePage.clickOnSearchButton();
    }

    @Then("^Suggestions \"([^\"]*)\" are displayed$")
    public void suggestionsAreDisplayed(String suggestionText) {
        waitUntilElementIsVisible(googleHomePage.getSuggestionField());
        Assert.assertEquals("Suggestions aren't displayed", suggestionText, googleHomePage.getSuggestionFieldText());
    }

    @When("^Opens first link and fills in first field \"([^\"]*)\" and Clicks on any inactive language$")
    public void translateWord(String searchWord) {
        waitUntilElementsAreVisible(googleResultPage.getLinks());
        googleResultPage.clickOnSecondLink();
        waitUntilElementIsVisible(googleTranslatePage.getSourceArea());
        googleTranslatePage.sendKeysToSourceArea(searchWord);
        waitUntilElementIsVisible(googleTranslatePage.getResultArea());
        buff = googleTranslatePage.getTextFromResultArea();
        googleTranslatePage.clickOnInactiveLanguageButton();
    }

    @Then("^Check if translated text has been changed$")
    public void checkIfTranslatedTextHasBeenChanged() {
        Assert.assertNotEquals("Translated text hasn't been changed", buff, googleTranslatePage.getTextFromResultArea());
    }

    @When("^Gets number of results$")
    public void getNumberOfResults() {
        waitUntilElementsAreVisible(googleResultPage.getLinks());
        numberOfResults1 = googleResultPage.getListSize();
    }

    @When("^Navigates through second and tenth page$")
    public void navigateToSecondAndTenthPage() throws InterruptedException {
        Thread.sleep(1000);
        googleResultPage.clickOnPage2Button();
        numberOfResults2 = googleResultPage.getListSize();
        Thread.sleep(1000);
        googleResultPage.clickOnPage10Button();
        numberOfResults10 = googleResultPage.getListSize();
    }

    @Then("^Check if the same number of results are displayed on second and tenth page as on the first page$")
    public void checkNumberOfResults() {
        Assert.assertEquals("Number of results is not the same on different pages", numberOfResults1, (numberOfResults2 & numberOfResults10));
    }

    @After
    public void testTearDown() {
        browser.quit();
    }
}
