package pageobject.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.pages.LoginPage;
import pageobject.pages.ShowtimesPage;
import pageobject.testbase.TestBase;

/**
 * Created by Ulyana on 25-Oct-16.
 */
public class ShowtimesTest extends TestBase{
    @Test
    public void verifyBuyTicketsForTomorrow() {
        ShowtimesPage showtimesPage = header.clickOnShowtimesTab();
        Assert.assertTrue(showtimesPage.loggedUserBuyTicketForTomorrowShowtimeTab("ulyana.opolska@gmail.com", "banana123"),"Buying tickets for tomorrow user has not reached payment page:");


    }
}
