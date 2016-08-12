package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultPage extends GoogleHomePage {

    public static final String LINKS_CSS = ".r a";

    @FindAll({@FindBy(css = LINKS_CSS)})
    public List<WebElement> links;

    public WebElement getLink(int linkNumber) {
        return links.get(linkNumber);
    }

    public static GoogleResultPage init(WebDriver driver) {
        return PageFactory.initElements(driver, GoogleResultPage.class);
    }

}
