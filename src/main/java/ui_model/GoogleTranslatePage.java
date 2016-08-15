package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleTranslatePage {

    @FindBy(css = "#gt-tl-sugg > div:nth-child(2)")
    private WebElement inactiveLanguageButton;

    @FindBy(id = "source")
    private WebElement sourceArea;

    @FindBy(css = "#result_box > span:nth-child(1)")
    private WebElement resultArea;

    public void clickOnInactiveLanguageButton() {
        inactiveLanguageButton.click();
    }

    public WebElement getInactiveLanguageButton() {
        return inactiveLanguageButton;
    }

    public WebElement getResultArea() {
        return resultArea;
    }

    public WebElement getSourceArea() {
        return sourceArea;
    }

    public String getTextFromResultArea() {
        return resultArea.getText();
    }

    public static GoogleTranslatePage init(WebDriver driver) {
        return PageFactory.initElements(driver, GoogleTranslatePage.class);
    }

    public void sendKeysToSourceArea(String searchWord) {
        sourceArea.sendKeys(searchWord);
    }
}
