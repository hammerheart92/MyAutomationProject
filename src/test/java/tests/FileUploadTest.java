package tests;

import loggerUtility.LoggerUtility;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;
import sharedData.Hooks;

public class FileUploadTest extends Hooks {

    @Test
    public void testMethod(){

        HomePage elementsPage = new HomePage(getDriver());
        elementsPage.clickFileUpload();
        LoggerUtility.infoLog("Navigating to HomePage and interacting with File Upload");

        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.chooseFile();

        FileUploadPage resetFile = new FileUploadPage(getDriver());
        resetFile.resetFile();

        LoggerUtility.infoLog("Test completed successfully, quitting the driver.");
        getDriver().quit();
    }
}
