package srv.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srv.softtest.BasePage;
import srv.softtest.PageObject;

import static org.testng.Assert.assertEquals;
import static srv.softtest.BasePage.softAssert;

public class TestPage extends PageObject {

    BasePage basePage = new BasePage();

//LOCATORS

    @FindBy(css = "#root > div > main > section.styled-components__TestingTypes-sc-176cr5a-5.cOcOjS.styled-components__Section-sc-176cr5a-0.cTZeFn > div > div > div > div:nth-child(1) > div")
    private WebElement solutionsBlock1;

    @FindBy(css = "#root > div > main > section.styled-components__TestingTypes-sc-176cr5a-5.cOcOjS.styled-components__Section-sc-176cr5a-0.cTZeFn > div > div > div > div:nth-child(2) > div")
    private WebElement solutionsBlock2;

    @FindBy(css = "#root > div > main > section.styled-components__TestingTypes-sc-176cr5a-5.cOcOjS.styled-components__Section-sc-176cr5a-0.cTZeFn > div > div > div > div:nth-child(3) > div")
    private WebElement solutionsBlock3;

    @FindBy(css = "#root > div > main > section.styled-components__TestingTypes-sc-176cr5a-5.cOcOjS.styled-components__Section-sc-176cr5a-0.cTZeFn > div > div > div > div:nth-child(4) > div")
    private WebElement solutionsBlock4;

    @FindBy(css = "#root > div > main > section.styled-components__TestingTypes-sc-176cr5a-5.cOcOjS.styled-components__Section-sc-176cr5a-0.cTZeFn > div > div > div > div:nth-child(5) > div")
    private WebElement solutionsBlock5;

    @FindBy(css = "#root > div > main > section.styled-components__TestingTypes-sc-176cr5a-5.cOcOjS.styled-components__Section-sc-176cr5a-0.cTZeFn > div > div > div > div:nth-child(6) > div")
    private WebElement solutionsBlock6;

    @FindBy(css = "#root > div > main > section.styled-components__TestingTypes-sc-176cr5a-5.cOcOjS.styled-components__Section-sc-176cr5a-0.cTZeFn > div > div > div > div:nth-child(7) > div")
    private WebElement solutionsBlock7;

    @FindBy(css = "#root > div > main > section.styled-components__TestingTypes-sc-176cr5a-5.cOcOjS.styled-components__Section-sc-176cr5a-0.cTZeFn > div > div > div > div:nth-child(8) > div")
    private WebElement solutionsBlock8;

    @FindBy(css = ".styled-components__ContainerShBox-sc-1aj187q-7:nth-child(1) .btn_active")
    private WebElement moreButton1;

    @FindBy(css = ".styled-components__ContainerShBox-sc-1aj187q-7:nth-child(2) .btn_active")
    private WebElement moreButton2;

    @FindBy(css = ".styled-components__ContainerShBox-sc-1aj187q-7:nth-child(3) .btn_active")
    private WebElement moreButton3;

    @FindBy(css = ".styled-components__ContainerShBox-sc-1aj187q-7:nth-child(4) .btn_active")
    private WebElement moreButton4;

    @FindBy(css = ".styled-components__ContainerShBox-sc-1aj187q-7:nth-child(5) .btn_active")
    private WebElement moreButton5;

    @FindBy(css = ".styled-components__ContainerShBox-sc-1aj187q-7:nth-child(6) .btn_active")
    private WebElement moreButton6;

    @FindBy(css = ".styled-components__ContainerShBox-sc-1aj187q-7:nth-child(7) .btn_active")
    private WebElement moreButton7;

    @FindBy(css = ".styled-components__ContainerShBox-sc-1aj187q-7:nth-child(8) .btn_active")
    private WebElement moreButton8;

    @FindBy(css = ".modalcard-title")
    private WebElement solutionBlockText1;

    @FindBy(css = ".modalcard-close")
    private WebElement solutionBlockClose;

    @FindBy(css = ".offers-list-item:nth-child(1)")
    private WebElement complexSolutionsButon1;

    @FindBy(css = ".offers-list-item:nth-child(2)")
    private WebElement complexSolutionsButon2;

    @FindBy(css = ".offers-list-item:nth-child(3)")
    private WebElement complexSolutionsButon3;

    @FindBy(css = ".offers-list-item:nth-child(4)")
    private WebElement complexSolutionsButon4;

    @FindBy(css = ".offers-list-item:nth-child(5)")
    private WebElement complexSolutionsButon5;

    @FindBy(css = ".offers-list-item:nth-child(6)")
    private WebElement complexSolutionsButon6;

    @FindBy(css = ".offer-title")
    private WebElement complexSolutionsText1;

//SUPER DRIVER

    public TestPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void getUrl() {
        assertEquals(driver.getCurrentUrl(), "https://softest.pro/#/test");
    }
    public void hoverCheck() throws InterruptedException {
        WebElement[] solutionBlocks = new WebElement[] {
                this.solutionsBlock1,
                this.solutionsBlock2,
                this.solutionsBlock3,
                this.solutionsBlock4,
                this.solutionsBlock5,
                this.solutionsBlock6,
                this.solutionsBlock7,
                this.solutionsBlock8};
        WebElement[] moreButtons = new WebElement[] {
                this.moreButton1,
                this.moreButton2,
                this.moreButton3,
                this.moreButton4,
                this.moreButton5,
                this.moreButton6,
                this.moreButton7,
                this.moreButton8,};
        for (int i = 0; i < solutionBlocks.length; i++) {
            solutionBlocks[i].click();
            Thread.sleep(1000);
            softAssert.assertTrue(moreButtons[i].isDisplayed());
        }
        softAssert.assertAll();
    }
    public void moreButtonsInSolutionClick() throws InterruptedException {
        WebElement[] solutionBlocks = new WebElement[] {
                this.solutionsBlock1,
                this.solutionsBlock2,
                this.solutionsBlock3,
                this.solutionsBlock4,
                this.solutionsBlock5,
                this.solutionsBlock6,
                this.solutionsBlock7,
                this.solutionsBlock8};
        WebElement[] moreButtons = new WebElement[] {
                this.moreButton1,
                this.moreButton2,
                this.moreButton3,
                this.moreButton4,
                this.moreButton5,
                this.moreButton6,
                this.moreButton7,
                this.moreButton8,};
        String[] textFromSolutionBlocks = new String[]{
                "Функциональное тестирование",
                "Интеграционное тестирование",
                "Регрессионное тестирование",
                "Автоматизация тестирования",
                "Smoke-тестирование",
                "Тестирование документации",
                "Пользовательское тестирование",
                "Юзабилити-тестирование"};
        for (int i = 0; i < solutionBlocks.length; i++) {
            solutionBlocks[i].click();
            moreButtons[i].click();
            Thread.sleep(500);
            softAssert.assertEquals(this.solutionBlockText1.getText(),textFromSolutionBlocks[i]);
            Thread.sleep(500);
            this.solutionBlockClose.click();
        }
        softAssert.assertAll();
    }
    public void complexSolutionsSelect() {
        WebElement[] complexSolutionButtons = new WebElement[]{
                this.complexSolutionsButon1,
                this.complexSolutionsButon2,
                this.complexSolutionsButon3,
                this.complexSolutionsButon4,
                this.complexSolutionsButon5,
                this.complexSolutionsButon6};
        String[] complexSolutionsTexts = new String[] {
                "Системное тестирование",
                "Тестирование производительности",
                "Тестирование сайта",
                "Тестирование мобильных приложений",
                "Оценка и анализ производительности процесса тестирования",
                "Аутсорсинг тестирования"};
        for (int i = 0; i < complexSolutionButtons.length; i++) {
            complexSolutionButtons[i].click();
            softAssert.assertEquals(this.complexSolutionsText1.getText(), complexSolutionsTexts[i]);
        }
        softAssert.assertAll();
    }
}
