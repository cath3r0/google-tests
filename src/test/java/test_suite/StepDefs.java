package test_suite;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
    @Given("^User is on Google Home Page$")
    public void goToGoogleHomePage() throws Throwable {
        System.out.println("execute first step");
    }

    @When("^User enters \"(Apple|translate.google.com)\" in search field$")
    public void fillSearchField(String arg0) throws Throwable {
        System.out.println("execute first step" + arg0);
    }

    @Then("^Results are displayed$")
    public void checkResultsDisplayed() throws Throwable {
        System.out.println("execute third step");
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
