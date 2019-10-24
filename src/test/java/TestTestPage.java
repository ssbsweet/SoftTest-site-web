import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import srv.softtest.BasePage;
import srv.softtest.pages.TestPage;

import java.util.concurrent.TimeUnit;

public class TestTestPage extends BasePage {

//BEFORE METHOD

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.get("https://softest.pro/#/test");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.testPage = new TestPage(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }

//TESTS

    @Test
    public void currentPageCheck() {
        testPage.getUrl();
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
    public void auditGoButtonCheck() {
        basePage.auditButtonClick();
    }
    @Test
    public void aboutGoButtonCheck() {
        basePage.aboutButtonClick();
    }
    @Test
    public void solutionsCheck() throws InterruptedException {
        testPage.hoverCheck();
    }
    @Test
    public void moreButtonsInSolutionsCheck() throws InterruptedException {
        testPage.moreButtonsInSolutionClick();
    }
    @Test
    public void complexSolutionsCheck() {
        testPage.complexSolutionsSelect();
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
