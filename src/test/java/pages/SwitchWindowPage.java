package pages;

import helpMethods.AlertMethods;
import helpMethods.TabMethods;
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
        loggerUtility.infoLog("The user opens a new Window tab");
        elementMethods.clickElement(openNewTab);
        TabMethods tabMethods = new TabMethods(driver);

        loggerUtility.infoLog("Switching to the new tab...");
        tabMethods.switchSpecificTab(1);

        loggerUtility.infoLog("Closing the new tab...");
        tabMethods.closeCurrentTab();

        loggerUtility.infoLog("Switching back to the original tab...");
        tabMethods.switchSpecificTab(0);
    }

    public void dealAlertProcess(){
        loggerUtility.infoLog("Triggering the alert popup.");
        elementMethods.clickElement(openAlert);
        AlertMethods alertMethods = new AlertMethods(driver);
        alertMethods.acceptAlert();
        loggerUtility.infoLog("Alert popup handled successfully.");
    }
}
