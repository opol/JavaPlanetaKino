package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ulyana on 25-Oct-16.
 */
public class HeaderPage extends Page {

    @FindBy(id = "logo")
    WebElement logo;

    @FindBy(linkText = "Розклад")
    WebElement showtimesLink;

    @FindBy (id="currentCitySpan")
    WebElement selectedCityElm;

    @FindBy(xpath = ".//*[@id='currentCitySpan']/span")
    WebElement citySelectBtn;

    @FindBy(xpath = ".//*[@id='navigation']/div/div[6]/div/ul")
    WebElement citySelectDrpdown;

    @FindBy(linkText = "Вхід")
    WebElement loginLink;

    @FindBy(xpath = ".//*[@id='navigation']/div[2]/div[4]/div/div/ul/li[3]/a")
    WebElement lvivKC;

    @FindBy(linkText = "Фільми")
    WebElement moviesLink;

    @FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a")
    WebElement lvov2ReluxLink;

    @FindBy(xpath = ".//*[@id='navigation']/div[1]/div[3]/div/span")
    WebElement headerAddonMenuBtn;

    @FindBy(xpath = ".//*[@id='navigation']/div[1]/div[3]/div/div")
    WebElement headerAddonMenuDrpdwn;


    public boolean verifyHeaderAddonMenuList(List addonMenuList) {
        headerAddonMenuBtn.click();
        List<WebElement> addonMenu = headerAddonMenuDrpdwn.findElements(By.tagName("li"));
        if (addonMenu.g)
    }






    public HeaderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean logoImageVerification() {
        return logo.isDisplayed();
    }

    public String citySelectionVerification(){
        citySelectBtn.click();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        citySelectBtn.click();
        lvivKC.click();
        return citySelectBtn.getAttribute("abbr");
    }

    public String selectCity(String selectedCity, String cityLinkTxt) {
        String currentCity = selectedCityElm.getAttribute("abbr");
        if (currentCity != selectedCity){
            citySelectBtn.click();
            citySelectDrpdown.findElement(By.linkText(cityLinkTxt)).click();
        }
        return selectedCityElm.getAttribute("abbr");
    }


    public boolean showtimesTabIsDisplayed() {
        return showtimesLink.isDisplayed();}

    public boolean showtimesTabIsLink(){
        if (showtimesLink.getAttribute("href") != null){
            return true;
        }
        else {
        return false;}
    }

    public String showtimesLinkVerification (String selectedCity, String cityLinkTxt){
        String currentCity = selectedCityElm.getAttribute("abbr");
        if (currentCity != selectedCity){
            citySelectBtn.click();
            citySelectDrpdown.findElement(By.linkText(cityLinkTxt)).click();
        }
        return showtimesLink.getAttribute("href");
    }

    public boolean moviesTabIsDisplayed() {
        return moviesLink.isDisplayed();
    }

    public boolean moviesTabIsLink(){
        if (moviesLink.getAttribute("href") != null){
            return true;
        }
        else {
            return false;}
    }


    public boolean loginLinkIsDisplayed() {
        return showtimesLink.isDisplayed();}

    public String loginLinkAttributeVerification (){
        return loginLink.getAttribute("href");
    }


    public ShowtimesPage clickOnShowtimesTab() {
        showtimesLink.click();
        return PageFactory.initElements(webDriver, ShowtimesPage.class);}

    public LoginPage clickOnLoginLink() {
        loginLink.click();
        return PageFactory.initElements(webDriver, LoginPage.class);
    }

    public String moviesLinkIsCorrect (String selectedCity, String cityLinkTxt){
        String currentCity = selectedCityElm.getAttribute("abbr");
        if (currentCity != selectedCity){
            citySelectBtn.click();
            citySelectDrpdown.findElement(By.linkText(cityLinkTxt)).click();
        }
        return moviesLink.getAttribute("href");
    }


    public String reluxLinkVerification(String selectedCity, String cityLinkTxt){
        String currentCity = selectedCityElm.getAttribute("abbr");
        if (currentCity != selectedCity){
            citySelectBtn.click();
            citySelectDrpdown.findElement(By.linkText(cityLinkTxt)).click();
        }

        return lvov2ReluxLink.getAttribute("href");
    }

}
