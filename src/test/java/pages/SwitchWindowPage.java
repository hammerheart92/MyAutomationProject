package pages;

import helpMethods.AlertMethods;
import helpMethods.TabMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwitchWindowPage extends BasePage {

    public SwitchWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "new-tab-button")
    private WebElement openNewTab;
    @FindBy(id = "alert-button")
    private WebElement openAlert;

    public void dealWindowProcess(){
        LoggerUtility.infoLog("The user opens a new Window tab");
        elementMethods.clickElement(openNewTab);
        TabMethods tabMethods = new TabMethods(driver);

        LoggerUtility.infoLog("Switching to the new tab...");
        tabMethods.switchSpecificTab(1);

        LoggerUtility.infoLog("Closing the new tab...");
        tabMethods.closeCurrentTab();

        LoggerUtility.infoLog("Switching back to the original tab...");
        tabMethods.switchSpecificTab(0);
    }

    public void dealAlertProcess(){
        LoggerUtility.infoLog("Triggering the alert popup.");
        elementMethods.clickElement(openAlert);
        AlertMethods alertMethods = new AlertMethods(driver);
        alertMethods.acceptAlert();
        LoggerUtility.infoLog("Alert popup handled successfully.");
    }
}
