package test_suite;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSearchSuggestionsSteps {
    @Given("^User is on Google Home Page$")
    public void user_is_on_Google_Home_Page() throws Throwable {
        System.out.println("execute first step");
    }

    @When("^User enter words in search field$")
    public void user_enter_words_in_search_form() throws Throwable {
        System.out.println("execute second step");
    }


    @Then("^next text is displayed: 'showing results blablablah'$")
    public void nextTextIsDisplayedShowingResultsBlablabla() throws Throwable {
        System.out.println("execute third step");
    }

}
