package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ulyana on 25-Oct-16.
 */
public class HeaderPage extends Page {

    @FindBy(id = "logo")
    WebElement logo;


    public HeaderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean logoImageVerification() {
        return logo.isDisplayed();
    }
}
