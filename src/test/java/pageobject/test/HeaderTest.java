package pageobject.test;

import org.apache.log4j.Logger;
import pageobject.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ulyana on 25-Oct-16.
 */
public class HeaderTest extends TestBase {

    @Test(priority = 1)
    public void verifyLogo() {
        Assert.assertTrue(header.logoImageVerification(), "Logo image is not displayed");
        //log.info("Verified logo image on Header");
    }
}
