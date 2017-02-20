package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageobject.pages.Page;
import pageobject.pages.HeaderPage;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = ".//*[@id='activation-form']/div/div")
    private WebElement closeBtn;

    @FindBy(id = "btn-register")
    private WebElement registerBtn;

    @FindBy(xpath = ".//*[@id='conteiner']/div[3]/div/div/div[3]/h2")
    private WebElement loginPgDescHdr;

    @FindBy(xpath = ".//*[@id='conteiner']/div[3]/div/div/div[3]/p[1]")
    private WebElement loginPgDescPrg1;

    @FindBy(xpath = ".//*[@id='conteiner']/div[3]/div/div/div[3]/p[2]")
    private WebElement loginPgDescPrg2;

    @FindBy(xpath = ".//*[@id='conteiner']/div[3]/div/div/div[3]/p[3]")
    private WebElement loginPgDescPrg3;

    @FindBy(xpath = ".//*[@id='conteiner']/div[3]/div/div/div[3]/ul")
    private WebElement loginPgDescPrg4;

    @FindBy(xpath =".//*[@id='conteiner']/div[3]/div/div/div[3]/ul")
    private WebElement loginPgDescLst;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Login user method
    public void userLogin (String username, String password) {
        HeaderPage header = new HeaderPage(webDriver);
        header.loginLink.click();
        userNameFld.clear();
        userNameFld.sendKeys(username);
        passwordFld.clear();
        passwordFld.sendKeys(password);
        signInBtn.click();
        closeBtn.click();
    }

    //Method for successful user login verification
    public boolean loginSucess (String username, String password) {
        userNameFld.clear();
        userNameFld.sendKeys(username);
        passwordFld.clear();
        passwordFld.sendKeys(password);
        signInBtn.click();
        return updateYourDataPopup.isDisplayed();
    }

    //Method for failed user login verification
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


    public boolean registerBtnDisplayed () {
        if (registerBtn.isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }

    public String verifyRegisterBtnLink (){
        return registerBtn.getAttribute("href");
    }

    public String verifyLoginPgDescHdr () {
       return loginPgDescHdr.getText();
    }

    public String verifyLoginPgDescPrg1 () {
        return loginPgDescPrg1.getText();
    }

    public String verifyLoginPgDescPrg2 () {
        return loginPgDescPrg2.getText();
    }

    public String verifyLoginPgDescPrg3 () {
        return loginPgDescPrg3.getText();
    }

    public String verifyLoginPgDescPrg4 () {
        return loginPgDescPrg4.getAttribute("li");
    }

    public String verifyLoginPgDescLst (){
        List<WebElement> loginPgDescList = loginPgDescLst.findElements(By.tagName("li"));
        List <String> loginPgDescListString= new ArrayList<String>();
        for (WebElement e: loginPgDescList){
            loginPgDescListString.add(e.getText());
        }
        return loginPgDescListString.toString();
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
