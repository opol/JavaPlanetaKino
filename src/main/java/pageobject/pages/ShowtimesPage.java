package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.pages.LoginPage;
import pageobject.pages.HeaderPage;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Ulyana on 25-Oct-16.
 */
public class ShowtimesPage extends Page {
    public ShowtimesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "tomorrow")
    private WebElement tomorrowShow;

    @FindBy(xpath=".//*[@id='showtimes-container']/div[3]/div[4]/div[2]/div/div[2]/div[2]/div/a[1]")
    private WebElement firstAvailableMovieTomorrow;

    @FindBy(id = "btn-bye-tickets")
    private WebElement buyTicketsBtn;

    @FindBy(xpath = ".//*[@id='hallscheme']/div[2]")
    private WebElement hallSchema;

    @FindBy(id = "platon-form")
    private WebElement payByCardForm;

    public boolean loggedUserBuyTicketForTomorrowShowtimeTab(String username, String password) {
        HeaderPage headerPage = new HeaderPage(webDriver);
        LoginPage loginpage = new LoginPage(webDriver);
        loginpage.userLogin(username, password);
        headerPage.clickOnShowtimesTab();
        tomorrowShow.click();
        firstAvailableMovieTomorrow.click();
        selectSeat();
        buyTicketsBtn.click();
        buyTicketsBtn.click();
        return payByCardForm.isDisplayed();
    }

    public void selectSeat (){
        List<WebElement> seats = hallSchema.findElements(By.tagName("div"));
        for (int i=0; i<seats.size(); i++ ){
            WebElement seat = seats.get(i);
            if (seat.getAttribute("id") != null) {
                seat.click();
            }
        }
    }
}
