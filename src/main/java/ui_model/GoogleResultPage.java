package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultPage extends GoogleHomePage {

    @FindAll({@FindBy(css = ".r a")})
    private List<WebElement> links;

    @FindBy(css = "#nav > tbody > tr > td:nth-child(3) > a")
    private WebElement page2Button;

    @FindBy(css = "#nav > tbody > tr > td:nth-child(11) > a")
    private WebElement page10Button;

    public void clickOnPage2Button() {
        page2Button.click();
    }

    public void clickOnPage10Button() {
        page10Button.click();
    }

    public void clickOnSecondLink() {
        links.get(1).click();
    }

    public List<WebElement> getLinks() {
        return links;
    }

    public int getListSize() {
        return links.size();
    }

    public WebElement getPage2Button() {
        return page2Button;
    }

    public WebElement getPage10Button() {
        return page10Button;
    }

    public static GoogleResultPage init(WebDriver driver) {
        return PageFactory.initElements(driver, GoogleResultPage.class);
    }
}
