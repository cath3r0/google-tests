package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    private static final String SEARCH_FIELD_ID = "lst-ib";
    private static final String SEARCH_BUTTON_CLASSNAME = ".lsb";
    private static final String SUGGESTION_FIELD_CLASSNAME = ".ssp.card-section";


    @FindBy(id = SEARCH_FIELD_ID)
    private WebElement searchField;

    @FindBy(css = SEARCH_BUTTON_CLASSNAME)
    private WebElement searchButton;

    @FindBy(css = SUGGESTION_FIELD_CLASSNAME)
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
