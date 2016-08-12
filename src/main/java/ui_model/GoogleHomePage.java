package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    public static final String SEARCH_FIELD_ID = "lst-ib";
    public static final String SEARCH_BUTTON_CLASSNAME = ".lsb";
    private static final String SUGGESTION_FIELD_CLASSNAME = ".ssp.card-section";


    @FindBy(id = SEARCH_FIELD_ID)
    public WebElement searchField;

    @FindBy(css = SEARCH_BUTTON_CLASSNAME)
    public WebElement searchButton;

    @FindBy(css = SUGGESTION_FIELD_CLASSNAME)
    public WebElement suggestionField;


    public static GoogleHomePage init(WebDriver driver) {
        return PageFactory.initElements(driver, GoogleHomePage.class);
    }
}
