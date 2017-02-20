package pageobject.test;

import org.apache.log4j.Logger;
import pageobject.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ulyana on 25-Oct-16.
 */
public class HeaderTest extends TestBase {
    private Logger log = Logger.getLogger(this.getClass());

    @Test(enabled = true, priority = 1)
    public void verifyLogoIsDisplayed() {
        Assert.assertTrue(header.logoImageVerification(), "Logo image is not displayed");
        log.info("Verified logo image on Header");
    }


    @Test (enabled = true,priority = 2)
    public void verifyCitySelection(){
        Assert.assertEquals(header.selectCity("lvov2", "Львів (FORUM LVIV)"),"lvov2", "Intended city is not selected:");

    }

    @Test(enabled = true,priority = 3)
    public void verifyShowtimesTabIsLink() {
        Assert.assertTrue(header.showtimesTabIsDisplayed(), "Showtimes tab is not displayed:");
        Assert.assertTrue(header.showtimesTabIsLink(), "Showtimes tab is not link:");
        log.info("Verified Showtimes tab is displayed on Header");
    }


    @Test(enabled = true,priority = 4)
    public void verifyShowtimesTabRedirectsToCorrectPage() {
        //Assert.assertTrue(header);
        Assert.assertEquals(header.showtimesLinkVerification("lvov2","Львів (FORUM LVIV)"),"http://planetakino.ua/lvov2/showtimes/","Showtimes tab link is incorrect:");
        log.info("Verified Showtimes tab redirects to correct page");
    }

    @Test(enabled = true,priority = 5)
    public void verifyLoginLinkIsDisplayed() {
        Assert.assertTrue(header.loginLinkIsDisplayed(), "Login link is not displayed");
        log.info("Verified login link is displayed on Header");
    }

    @Test(enabled = true,priority = 6)
    public void verifyLoginLinkRedirectsToCorrectPage() {
        Assert.assertEquals(header.loginLinkAttributeVerification(),"https://cabinet.planetakino.ua/?return=http%3A%2F%2Fplanetakino.ua","Login link attribute is incorrect");
        log.info("Verified login link redirects to correct page");
    }

    @Test(enabled = true,priority = 7)
    public void verifyMoviesTabIsLink() {
        Assert.assertTrue(header.moviesTabIsDisplayed(), "Movies tab is not displayed");
        Assert.assertTrue(header.moviesTabIsLink(), "Movies tab is not link");
        log.info("Verified Movies tab is displayed on Header and is link");
    }

    @Test(enabled = true,priority = 8)
    public void verifyMoviesTabRedirectsToCorrectPage() {
        Assert.assertEquals(header.moviesLinkIsCorrect("lvov2","Львів (FORUM LVIV)"),"http://planetakino.ua/lvov2/movies/","Movies tab link is incorrect:");
        log.info("Verified Movies tab redirects to correct page");
    }

    @Test(enabled = true,priority = 9)
    public void verifyReluxTabRedirectsToCorrectPage() {
        Assert.assertEquals(header.reluxLinkVerification("lvov2","Львів (FORUM LVIV)"),"http://planetakino.ua/lvov2/relux/","Relux tab link is incorrect:");
        log.info("Verified Relux tab redirects to correct page");
    }

    @Test(priority=10)
    public void verifyAddonMenuList() {
        Assert.assertEquals(header.verifyAddonList(),
                "[Кінотеатри, Допомога. Відповіді на запитання, Знижки, Подарунковий сертифікат, Мобільний додаток, Новини, Про Планету Кіно, Робота у нас]",
                "Addon list is incorrect:");
    }

}
