package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(css = ".lsb")
    private WebElement searchButton;

    @FindBy(css = ".ssp.card-section")
    private WebElement suggestionField;


    public static GoogleHomePage init(WebDriver driver) {
        return PageFactory.initElements(driver, GoogleHomePage.class);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSuggestionField() {
        return suggestionField;
    }
}
