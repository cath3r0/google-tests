package test_suite;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSearchSuggestionsSteps {
    @Given("^User is on Google Home Page$")
    public void user_is_on_Google_Home_Page() throws Throwable {
        System.out.println("execute first step");
    }

    @When("^User enter \"([^\"]*)\" in search field$")
    public void userEnterInSearchField(String arg0) throws Throwable {

    }

    @Then("^Showing results are displayed$")
    public void showingResultsAreDisplayed() throws Throwable {
        System.out.println("execute third step");
    }
}
