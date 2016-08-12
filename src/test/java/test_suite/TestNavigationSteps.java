package test_suite;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class TestNavigationSteps {

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
