package tests;

import loggerUtility.LoggerUtility;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SwitchWindowPage;
import sharedData.Hooks;

public class SwitchWindowTest extends Hooks {

    @Test
    public void testMethod(){

        LoggerUtility.infoLog("Navigating to Switch Window page...");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSwitchWindow();

        SwitchWindowPage switchWindowPage = new SwitchWindowPage(getDriver());
        LoggerUtility.infoLog("Opening and handling a new tab...");
        switchWindowPage.dealWindowProcess();

        LoggerUtility.infoLog("Handling the alert popup...");
        switchWindowPage.dealAlertProcess();

        LoggerUtility.infoLog("Test completed successfully, quitting the driver.");
        getDriver().quit();
    }
}
