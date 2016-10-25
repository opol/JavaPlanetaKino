package pageobject.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Ulyana on 25-Oct-16.
 */
public class Page {
    protected WebDriver webDriver;

	/*
	 * Constructor injecting the WebDriver interface
	 *
	 * @param webDriver
	 */

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
