package test_suite;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class TestGoogleTranslateSteps {

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
}
