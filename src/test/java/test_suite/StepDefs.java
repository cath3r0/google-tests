package test_suite;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_model.GoogleHomePage;
import ui_model.GoogleResultPage;
import ui_model.GoogleTranslatePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDefs {

    private WebDriver browser = null;
    private GoogleHomePage googleHomePage;
    private GoogleTranslatePage googleTranslatePage;
    private GoogleResultPage googleResultPage;
    private String buff;
    private int numberOfResults1;
    private int numberOfResults2;
    private int numberOfResults10;


    public static final int STANDART_WAIT_TIME = 10;

    public void waitUntilElementIsVisible(WebElement element) {
        new WebDriverWait(browser, STANDART_WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementsAreVisible(List<WebElement> list) {
        new WebDriverWait(browser, STANDART_WAIT_TIME).until(ExpectedConditions.visibilityOfAllElements(list));
    }

    @Given("^User is on Google Home Page$")
    public void goToGoogleHomePage() throws Throwable {
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
        googleHomePage = GoogleHomePage.init(browser);
        googleTranslatePage = GoogleTranslatePage.init(browser);
        googleResultPage = GoogleResultPage.init(browser);
        browser.get("http://www.google.com.ua/");
    }

    @When("^User enters \"(apple|translate.google.com)\" in search field$")
    public void fillSearchField(String searchWord) throws Throwable {
        googleHomePage.searchField.sendKeys(searchWord);
        googleHomePage.searchButton.click();
    }

    @Then("^Suggestions \"([^\"]*)\" are displayed$")
    public void suggestionsAreDisplayed(String suggestionText) throws Throwable {
        waitUntilElementIsVisible(googleHomePage.suggestionField);
        Assert.assertEquals("Suggestions aren't displayed", suggestionText, googleHomePage.suggestionField.getText());
        browser.quit();
    }

    @And("^Opens first link and fills in first field \"([^\"]*)\" and Clicks on any inactive language$")
    public void translateWord(String searchWord) throws Throwable {
        waitUntilElementsAreVisible(googleResultPage.links);
        googleResultPage.getLink(1).click();
        waitUntilElementIsVisible(googleTranslatePage.sourceArea);
        googleTranslatePage.sourceArea.sendKeys(searchWord);
        waitUntilElementIsVisible(googleTranslatePage.resultArea);
        buff = googleTranslatePage.resultArea.getText();
        googleTranslatePage.inactiveLanguageButton.click();
    }

    @Then("^Check if translated text has been changed$")
    public void checkIfTranslatedTextHasBeenChanged() throws Throwable {
        Assert.assertNotEquals("Translated text hasn't been changed", buff, googleTranslatePage.resultArea.getText());
        browser.quit();
    }

    @And("^Gets number of results$")
    public void getNumberOfResults() throws Throwable {
//        waitUntilElementsAreVisible(googleResultPage.links);
//        Thread.sleep(2000);
        numberOfResults1 = googleResultPage.links.size();
    }

    @And("^Navigates through second and tenth page$")
    public void navigateToSecondAndTenthPage() throws Throwable {
//        waitUntilElementIsVisible(googleResultPage.page2Button);
//        Thread.sleep(3000);
        googleResultPage.page2Button.click();
        numberOfResults2 = googleResultPage.links.size();
//        Thread.sleep(3000);
//        waitUntilElementIsVisible(googleResultPage.page10Button);
        googleResultPage.page10Button.click();
        Thread.sleep(2000);
        numberOfResults10 = googleResultPage.links.size();
    }

    @Then("^Check if the same number of results are displayed on second and tenth page as on the first page$")
    public void checkNumberOfResults() throws Throwable {
        Assert.assertEquals("Number of results is not the same on different pages", numberOfResults1, (numberOfResults2 & numberOfResults10));
        browser.quit();
    }
}
