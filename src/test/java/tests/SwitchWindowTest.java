package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SwitchWindowPage;
import sharedData.Hooks;

public class SwitchWindowTest extends Hooks {

    @Test
    public void testMethod(){

        loggerUtility.infoLog("Navigating to Switch Window page...");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSwitchWindow();

        SwitchWindowPage switchWindowPage = new SwitchWindowPage(getDriver());
        loggerUtility.infoLog("Opening and handling a new tab...");
        switchWindowPage.dealWindowProcess();

        loggerUtility.infoLog("Handling the alert popup...");
        switchWindowPage.dealAlertProcess();

        loggerUtility.infoLog("Test completed successfully, quitting the driver.");
        getDriver().quit();
    }
}
