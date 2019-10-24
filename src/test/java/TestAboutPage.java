import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import srv.softtest.BasePage;
import srv.softtest.pages.AboutPage;

import java.util.concurrent.TimeUnit;

public class TestAboutPage extends BasePage {

//BEFORE METHOD

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("https://softest.pro/#/about");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.aboutPage = new AboutPage(driver);
        basePage = new BasePage();
        jse = (JavascriptExecutor) driver;
        softAssert = new SoftAssert();
    }

//TESTS

    @Test
    public void currentPageCheck() {
        aboutPage.getUrl();
    }
    @Test
    public void languageChangeCheck() {
        basePage.getEnglishText();
    }
    @Test
    public void backToRussianAssert() {
        basePage.RussianToRussianLanguageButtonClick();
    }
    @Test
    public void logoClickCheck() {
        basePage.logoClick();
    }
    @Test
    public void testingGoButtonCheck() {
        basePage.testButtonClick();
    }
    @Test
    public void auditGoButtonCheck() {
        basePage.auditButtonClick();
    }
    @Test
    public void SocialLinksCheck() {
        aboutPage.socialLinksGo();
    }
    @Test
    public void messagesFormCheck() {
        basePage.buttonIndentAndAutoFull();
    }
}
