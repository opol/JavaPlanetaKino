package pageobject.test;

import pageobject.pages.HeaderPage;
import pageobject.pages.LoginPage;
import pageobject.testbase.TestBase;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ulyana on 28-Oct-16.
 */
public class LoginTest extends TestBase {
    private Logger log = Logger.getLogger(this.getClass());

    @Test(priority = 1)
    public void verifyUserLoginSuccess () {
        LoginPage loginPage = header.clickOnLoginLink();
        Assert.assertTrue(loginPage.loginSucess("ulyana.opolska@gmail.com", "banana"), "Update your data popup is not displayed");
    }

    @Test(priority = 2)
    public void verifyUserLoginFail () {
        LoginPage loginPage = header.clickOnLoginLink();
        Assert.assertTrue(loginPage.loginFail("ulyana.opolska@gmail.com", "ban"),"Login failed error message is not displayed");
    }
}
