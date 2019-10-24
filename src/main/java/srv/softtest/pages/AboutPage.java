package srv.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srv.softtest.BasePage;
import srv.softtest.PageObject;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static srv.softtest.BasePage.jse;
import static srv.softtest.BasePage.softAssert;

public class AboutPage extends PageObject {

    BasePage basePage = new BasePage();

//LOCATORS

    @FindBy(css = ".contacts-list-item:nth-child(4) > .contacts-list-item-link")
    private WebElement toVkCom;

    @FindBy(css = ".contacts-list-item:nth-child(5) > .contacts-list-item-link")
    private WebElement toTwitter;

    @FindBy(css = ".contacts-list-item:nth-child(6) > .contacts-list-item-link")
    private WebElement toFacebook;

//SUPER DRIVER

    public AboutPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS
    public void getUrl() {
        assertEquals(driver.getCurrentUrl(), "https://softest.pro/#/about");
    }
    public void socialLinksGo() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        WebElement[] socialButtons = new WebElement[] {
                this.toVkCom,
                this.toTwitter,
                this.toFacebook};
        String[] socilaUrls = new String[] {
                "https://vk.com/",
                "https://twitter.com/",
                "https://www.facebook.com/"};
        for (int i = 0; i < socialButtons.length; i++) {
            jse.executeScript("scroll(0, 2500)");
            socialButtons[i].click();
            basePage.switchTab();
            softAssert.assertEquals(driver.getCurrentUrl(), socilaUrls[i]);
            driver.get("https://softest.pro/#/about");
        }
        softAssert.assertAll();
    }
}
