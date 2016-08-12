package test_suite;

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

public class StepDefs {

    WebDriver browser = null;
    GoogleHomePage googleHomePage;

    public static final int STANDART_WAIT_TIME = 10;

    public void waitUntilElementIsVisible(WebElement element) {
        new WebDriverWait(browser, STANDART_WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    }

    @Given("^User is on Google Home Page$")
    public void goToGoogleHomePage() throws Throwable {
        browser = new FirefoxDriver();
        googleHomePage = GoogleHomePage.init(browser);
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

    @And("^Opens first link$")
    public void opensFirstLink() throws Throwable {
        System.out.println("execute second step");
    }

    @And("^Fills in first field 'apple'$")
    public void fillsInFirstField(String arg0) throws Throwable {
        System.out.println("execute third step");
    }

    @And("^Clicks on any inactive language$")
    public void clicksOnAnyInactiveLanguage() throws Throwable {
        System.out.println("execute fourth step");
    }

    @Then("^Check if translated text has been changed$")
    public void checkIfTranslatedTextHasBeenChanged() throws Throwable {
        System.out.println("execute fifth step");
    }

    @And("^Gets number of results$")
    public void getsNumberOfResults() throws Throwable {
        System.out.println("execute second step");
    }

    @And("^Navigates through second and tenth page$")
    public void navigatesThroughSecondAndTenthPage() throws Throwable {
        System.out.println("execute third step");
    }

    @Then("^Check if the same number of results are displayed on second and tenth page as on the first page$")
    public void checkIfTheSameNumberOfResultsAreDisplayedOnSecondAndTenthPageAsOnTheFirstPage() throws Throwable {
        System.out.println("execute fourth step");
    }
}
