package test_suite;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestNavigationSteps {

    @When("^User search vie search field term 'apple'$")
    public void userSearchVieSearchFieldTerm(String arg0) throws Throwable {
        System.out.println("execute first step");
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
