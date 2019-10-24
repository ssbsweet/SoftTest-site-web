package srv.softtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srv.softtest.BasePage;
import srv.softtest.PageObject;

import static org.testng.Assert.*;
import static srv.softtest.BasePage.jse;
import static srv.softtest.BasePage.softAssert;

public class MainPage extends PageObject {

    BasePage basePage = new BasePage();

//LOCATORS

    @FindBy(css = "title")
    private WebElement title;

    @FindBy(css = ".active > .styled-components__Button-sc-1aj187q-0")
    private WebElement downArrow;

    @FindBy(css = "#root > div > div.styled-components__Wrapper-sc-1oiiyq1-0.dkZKEX > div > div > div:nth-child(2) > div > a > span > div")
    private WebElement testLogo;

    @FindBy(css = "#root > div > div.styled-components__Wrapper-sc-1oiiyq1-0.dkZKEX > div > div > div:nth-child(3) > div > a > span > div")
    private WebElement auditLogo;

    @FindBy(css = "li:nth-child(1) > div")
    private WebElement presentationButton1;

    @FindBy(css = "li:nth-child(2) > div")
    private WebElement presentationButton2;

    @FindBy(css = "li:nth-child(3) > div")
    private WebElement presentationButton3;

    @FindBy(css = "li:nth-child(4) > div")
    private WebElement presentationButton4;

    @FindBy(css = "li:nth-child(5) > div")
    private WebElement presentationButton5;

    @FindBy(css = "div.item.active > h1")
    private WebElement presentationText1;

//SUPER DRIVER

    public MainPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void getTitle() {
        assertEquals(this.title.getAttribute("text"),"SoftTest");
    }
    public void downArrowButton() throws InterruptedException {
        this.downArrow.click();
        Thread.sleep(500);
        Long scrollYposittion = (Long) jse.executeScript("return document.getElementsByTagName('html')[0].scrollTop");
        assertTrue(scrollYposittion != 0);
    }
    public void getTestLogoLinks() {
        String logo1 = this.testLogo.getAttribute("src");
        this.testLogo.click();
        String logo2 = driver.findElement(By.cssSelector(".styled-components__MotivationImg-sc-176cr5a-4.jCCpUi")).getAttribute("src");
        assertSame(logo1, logo2);
    }
    public void getAuditLogoLinks() {
        String logo1 = this.auditLogo.getAttribute("src");
        this.auditLogo.click();
        String logo2 = driver.findElement(By.cssSelector("#root > div > main > div.container > div > div.col-image.col-lg-5.col-md-4 > div > object")).getAttribute("src");
        assertSame(logo1, logo2);
    }
    public void presentationClick() throws InterruptedException {
        WebElement[] presentationButtons = new WebElement[] {
                this.presentationButton1,
                this.presentationButton2,
                this.presentationButton3,
                this.presentationButton4,
                this.presentationButton5};
        String[] presentationTexts = new String[] {
                "Мультиплатформенное тестирование",
                "Тестирование производительности",
                "Тестирование эргономики",
                "Оптимизация архитектуры",
                "Устранение уязвимостей",};
        for (int i = 0; i < presentationButtons.length; i++) {
            presentationButtons[i].click();
            Thread.sleep(1000);
            softAssert.assertEquals(this.presentationText1.getText(), presentationTexts[i]);
        }
        softAssert.assertAll();
    }
}
