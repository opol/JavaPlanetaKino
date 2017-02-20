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

    @Test(enabled=false,priority = 1)
    public void verifyUserLoginSuccess () {
        LoginPage loginPage = header.clickOnLoginLink();
        Assert.assertTrue(loginPage.loginSucess("ulyana.opolska@gmail.com", "banana"), "Update your data popup is not displayed:");
    }

    @Test(enabled=false,priority = 2)
    public void verifyUserLoginFail () {
        LoginPage loginPage = header.clickOnLoginLink();
        Assert.assertTrue(loginPage.loginFail("ulyana.opolska@gmail.com", "ban"),"Login failed error message is not displayed:");
    }

    @Test(enabled=false,priority=3)
    public void verifyRegisterBtn () {
        LoginPage loginPage = header.clickOnLoginLink();
        Assert.assertTrue(loginPage.registerBtnDisplayed(), "Register button is not displayed:");
        Assert.assertEquals(loginPage.verifyRegisterBtnLink(), "https://cabinet.planetakino.ua/account-register", "Register link is incorrect:");
    }

    @Test(priority=4)
    public void verifyLoginPgDecs() {
        LoginPage loginPage = header.clickOnLoginLink();
        Assert.assertEquals(loginPage.verifyLoginPgDescHdr(), "Зверни увагу!", "Login page description header is incorrect:");
        Assert.assertEquals(loginPage.verifyLoginPgDescPrg1(), "Якщо ти реєструвався у кінотеатрі, для тебе уже було створено Особистий Кабінет на сайті та у мобільному додатку. У цьому випадку тобі необхідно скористатися входом, а не реєструватися заново.", "Paragraph1 of login page desc is incorrect:");
        Assert.assertEquals(loginPage.verifyLoginPgDescPrg2(), "Якщо ти не знаєш пароль, пройди процедуру відновлення паролю.", "Paragraph2 of login page desc is incorrect:");
        Assert.assertEquals(loginPage.verifyLoginPgDescPrg3(),"Якщо ти не пам’ятаєш e-mail або номер телефону, звернись до нашого Контакт Центру:", "Paragraph3 of login page desc is incorrect:");
        Assert.assertEquals(loginPage.verifyLoginPgDescLst(),"[онлайн-чат на нашому сайті;, info@planetakino.ua;, 0 800 300 600 (щоденно з 9:00 до 22:00; безкоштовно по Україні з будь-якого номеру).]","Login page description list is incorrect:");
    }

}

