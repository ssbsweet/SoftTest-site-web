import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import srv.softtest.BasePage;
import srv.softtest.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class TestMainPage extends BasePage {

//BEFORE METHOD

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("https://softest.pro/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.mainPage = new MainPage(driver);
        jse = (JavascriptExecutor)driver;
        softAssert = new SoftAssert();
    }

//TESTS

    @Test
    public void currentSiteCheck() {
        mainPage.getTitle();
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
    public void testingGoButtonCheck() {
        basePage.testButtonClick();
    }
    @Test
    public void auditGoButtonCheck() {
        basePage.auditButtonClick();
    }
    @Test
    public void aboutGoButtonCheck() {
        basePage.aboutButtonClick();
    }
    @Test
    public void downArrowClickCheck() throws InterruptedException {
        mainPage.downArrowButton();
    }
    @Test
    public void presentationWorkCheck() throws InterruptedException {
        mainPage.presentationClick();
    }
    @Test
    public void testLogoAssert() {
        mainPage.getTestLogoLinks();
    }
    @Test
    public void auditLogoAssert() {
        mainPage.getAuditLogoLinks();
    }
    @Test
    public void messagesFormCheck() {
        basePage.buttonIndentAndAutoFull();
    }
    @Test
    public void messagesFooterFormCheck() {
        basePage.messageFooterSend();
    }
}
