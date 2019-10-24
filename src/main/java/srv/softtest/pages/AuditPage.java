package srv.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srv.softtest.BasePage;
import srv.softtest.PageObject;

import static org.testng.Assert.assertEquals;
import static srv.softtest.BasePage.actions;
import static srv.softtest.BasePage.softAssert;

public class AuditPage extends PageObject {

    BasePage basePage = new BasePage();

//LOCATORS

    //LOCATORS
    @FindBy(css = ".styled-components__ContainerShBoxBig-sc-1aj187q-8:nth-child(1) > .styled-components__ShBox-sc-1aj187q-9")
    private WebElement typesOfAuditBlock1;

    @FindBy(css = ".styled-components__ContainerShBoxBig-sc-1aj187q-8:nth-child(1) .col-sm-6:nth-child(1) > .card-item-value")
    private WebElement typesOfAuditBlock1Hover;

    @FindBy(css = ".styled-components__ContainerShBoxBig-sc-1aj187q-8:nth-child(2) > .styled-components__ShBox-sc-1aj187q-9")
    private WebElement typesOfAuditBlock2;

    @FindBy(css = ".styled-components__ContainerShBoxBig-sc-1aj187q-8:nth-child(2) .col-sm-6:nth-child(1) > .card-item-value")
    private WebElement typesOfAuditBlock2Hover;

    @FindBy(css = ".styled-components__ContainerShBoxBig-sc-1aj187q-8:nth-child(3) > .styled-components__ShBox-sc-1aj187q-9")
    private WebElement typesOfAuditBlock3;

    @FindBy(css = ".styled-components__ContainerShBoxBig-sc-1aj187q-8:nth-child(3) .col-sm-6:nth-child(1) > .card-item-value")
    private WebElement typesOfAuditBlock3Hover;

    @FindBy(css = ".styled-components__ContainerShBoxBig-sc-1aj187q-8:nth-child(4) > .styled-components__ShBox-sc-1aj187q-9")
    private WebElement typesOfAuditBlock4;

    @FindBy(css = ".styled-components__ContainerShBoxBig-sc-1aj187q-8:nth-child(4) .col-sm-6:nth-child(1) > .card-item-value")
    private WebElement typesOfAuditBlock4Hover;

//SUPER DRIVER

    public AuditPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS
    public void getUrl() {
        assertEquals(driver.getCurrentUrl(), "http://softtest.srv.lan/#/audit");
    }
    public void typesOfAuditBlocksHover() {
        WebElement[] typesOfAuditBlocks = new WebElement[] {
                this.typesOfAuditBlock1,
                this.typesOfAuditBlock2,
                this.typesOfAuditBlock3,
                this.typesOfAuditBlock4};
        WebElement[] typesOfAuditBlocksHover = new WebElement[] {
                this.typesOfAuditBlock1Hover,
                this.typesOfAuditBlock2Hover,
                this.typesOfAuditBlock3Hover,
                this.typesOfAuditBlock4Hover};
        for (int i = 0; i < typesOfAuditBlocks.length; i++ ) {
            actions.moveToElement(typesOfAuditBlocks[i]).perform();
            softAssert.assertTrue(typesOfAuditBlocksHover[i].isDisplayed());
        }
        softAssert.assertAll();
    }
}
