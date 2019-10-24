package srv.softtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import srv.softtest.pages.AboutPage;
import srv.softtest.pages.AuditPage;
import srv.softtest.pages.MainPage;
import srv.softtest.pages.TestPage;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class BasePage extends PageObject {
    protected static WebDriver driver;
    public static JavascriptExecutor jse;
    public static SoftAssert softAssert;
    public static Actions actions;
    public BasePage basePage;
    public MainPage mainPage;
    public AboutPage aboutPage;
    public TestPage testPage;
    public AuditPage auditPage;

//UNIVERSALS LOCATORS

    @FindBy(css = ".logo > img")
    private WebElement siteLogo;

    @FindBy(css = "a[href='#/test']")
    private WebElement testButton;

    @FindBy(css = "a[href='#/audit']")
    private WebElement auditButton;

    @FindBy(css = "a[href='#/about']")
    private WebElement aboutButton;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(name = "message")
    private WebElement textMessage;

    @FindBy(css = ".styled-components__Button-sc-1aj187q-0:nth-child(1)")
    private WebElement messageFotterSend;

    @FindBy(css = "#modal-root p")
    private WebElement messageOk;

    @FindBy(css = ".styled-components__BLink-sc-1aj187q-4.jICvub.styled-components__Link-sc-1aj187q-3.gYUCXT")
    private WebElement buttonIndent;

    @FindBy(css = "button.styled-components__BigButton-sc-1aj187q-1.bDnVOA")
    private WebElement messageSend;

    @FindBy(css = "div > .languageButton")
    private WebElement languageButton;

    @FindBy(css = ".carousel-inner h1")
    private WebElement getEnglishText;

//SUPER DRIVER

    public BasePage() {
        super(driver);
    }

//BEFORE AND AFTER

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
    }
    @AfterMethod
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
        //driver.quit();
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

//UNIVERSAL OPERATIONS

    public void logoClick() {
        this.siteLogo.click();
        assertEquals(driver.getCurrentUrl(), "https://softest.pro/#/");
    }
    public void testButtonClick() {
        this.testButton.click();
        assertEquals("https://softest.pro/#/test", driver.getCurrentUrl());
    }
    public void auditButtonClick() {
        this.auditButton.click();
        assertEquals("https://softest.pro/#/audit", driver.getCurrentUrl());
    }
    public void aboutButtonClick() {
        this.aboutButton.click();
        assertEquals("https://softest.pro/#/about", driver.getCurrentUrl());
    }
    public void indentForm(String username, String email, String phone, String textMessage) {
        this.username.sendKeys(username);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        this.textMessage.sendKeys(textMessage);
    }
    public void switchTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }
    public void messageFooterSend() {
        this.indentForm(
                "QA TEST", "a"+ System.currentTimeMillis() + "@abc.de",
                "000" +System.currentTimeMillis(),
                "Simple QA TEST, don't answer please!");
        this.messageFotterSend.click();
        assertEquals("Ваша заявка отправлена !", this.messageOk.getText());
    }
    public void buttonIndentAndAutoFull() {
        this.buttonIndent.click();
        this.indentForm(
                "QA TEST", "a"+ System.currentTimeMillis() + "@abc.de",
                "000" +System.currentTimeMillis(),
                "Simple QA TEST, don't answer please!");
        this.messageSend.click();
        assertEquals("Ваша заявка отправлена !", this.messageOk.getText());
    }
    public void RussianToRussianLanguageButtonClick() {
        this.languageButton.click();
        this.languageButton.click();
        assertEquals("Рус", this.languageButton.getText());
    }
    public void getEnglishText() {
        this.languageButton.click();
        assertEquals("Eng", this.languageButton.getText());
    }
}
