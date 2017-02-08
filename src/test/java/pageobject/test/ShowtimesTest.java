package pageobject.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.pages.ShowtimesPage;
import pageobject.testbase.TestBase;

/**
 * Created by Ulyana on 25-Oct-16.
 */
public class ShowtimesTest extends TestBase{
    @Test
    public void verifyServicesLink() {
        ShowtimesPage showtimesPage = header.clickOnShowtimesTab();

    }
}
