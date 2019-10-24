import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import srv.softtest.BasePage;
import srv.softtest.pages.AuditPage;

import java.util.concurrent.TimeUnit;

public class TestAuditPage extends BasePage {

//BEFORE METHOD

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://softtest.srv.lan/#/audit");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.auditPage = new AuditPage(driver);
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
        softAssert = new SoftAssert();
    }

//TESTS

    @Test
    public void currentPageCheck() {
        auditPage.getUrl();
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
    public void aboutGoButtonCheck() {
        basePage.aboutButtonClick();
    }
    @Test
    public void typesOfAuditBlocksCheck() {
        auditPage.typesOfAuditBlocksHover();
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