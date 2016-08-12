package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleTranslatePage {

    public static final String INACTIVE_LANGUAGE_BUTTON_CSS = "#gt-tl-sugg > div:nth-child(2)";
    public static final String SOURCE_AREA_ID = "source";
    public static final String RESULT_AREA_CSS = "#result_box > span:nth-child(1)";

    @FindBy(css = INACTIVE_LANGUAGE_BUTTON_CSS)
    public WebElement inactiveLanguageButton;

    @FindBy(id = SOURCE_AREA_ID)
    public WebElement sourceArea;

    @FindBy(css = RESULT_AREA_CSS)
    public WebElement resultArea;

    public static GoogleTranslatePage init(WebDriver driver) {
        return PageFactory.initElements(driver, GoogleTranslatePage.class);
    }

}
