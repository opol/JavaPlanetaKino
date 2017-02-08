package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageobject.pages.Page;
import pageobject.pages.HeaderPage;

/**
 * Created by Ulyana on 26-Oct-16.
 */
public class LoginPage extends Page{

    @FindBy(id = "txtEmail")
    private WebElement userNameFld;

    @FindBy(id = "password")
    private WebElement passwordFld;

    @FindBy(xpath = ".//*[@id='enter_forma']/div[3]/input")
    private WebElement signInBtn;

    @FindBy(xpath = ".//*[@id='enter_forma']/div[2]/a")
    private WebElement restorePswdLnk;

    @FindBy(id = "login-error")
    private WebElement loginError;

    @FindBy(xpath = ".//*[@id='activation-form']/div")
    private WebElement updateYourDataPopup;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean loginSucess (String username, String password) {
        userNameFld.clear();
        userNameFld.sendKeys(username);
        passwordFld.clear();
        passwordFld.sendKeys(password);
        signInBtn.click();
        return updateYourDataPopup.isDisplayed();
    }

    public boolean loginFail (String username, String password) {
        userNameFld.clear();
        userNameFld.sendKeys(username);
        passwordFld.clear();
        passwordFld.sendKeys(password);
        signInBtn.click();
        return loginError.isDisplayed();
    }

    public CabinetPage returnCabinetPage (String username, String password) {
        userNameFld.clear();
        userNameFld.sendKeys(username);
        passwordFld.clear();
        passwordFld.sendKeys(password);
        signInBtn.click();
        return PageFactory.initElements(webDriver, CabinetPage.class);
    }

    /*public void setRootScreenshotsDir(String absolutePath){
        String resourcesImagesDir = absolutePath;
        String expectedDir = resourcesImagesDir + "/testScreenshots/expectedScreenshots/";
        String actualDir = resourcesImagesDir + "/testScreenshots/actualScreenshots/";
        String diffDir = resourcesImagesDir + "/testScreenshots/markedImages/";
        String resultGifsDir = resourcesImagesDir + "/testScreenshots/gifs/";
        createFolders();
    }

    private void createFolders() {
    }*/

}
