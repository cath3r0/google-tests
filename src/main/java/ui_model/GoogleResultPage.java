package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultPage extends GoogleHomePage {

    public static final String LINKS_CSS = ".r a";
    public static final String PAGE_2_CSS = "#nav > tbody > tr > td:nth-child(3) > a";
    public static final String PAGE_10_XPATH = "//*[@id=\"nav\"]/tbody/tr/td[11]/a";

    @FindAll({@FindBy(css = LINKS_CSS)})
    private List<WebElement> links;

    @FindBy(css = PAGE_2_CSS)
    public WebElement page2Button;

    @FindBy(xpath = PAGE_10_XPATH)
    public WebElement page10Button;


    public WebElement getLink(int linkNumber) {
        return links.get(linkNumber);
    }

    public int getListSize() {
        return links.size();
    }

    public static GoogleResultPage init(WebDriver driver) {
        return PageFactory.initElements(driver, GoogleResultPage.class);
    }

    public List<WebElement> getLinks() {
        return links;
    }
}
