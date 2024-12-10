package tests;

import configFiles.DataConfig;
import loggerUtility.LoggerUtility;
import modelObject.CompleteWebFormModel;
import org.testng.annotations.Test;
import pages.CompleteWebFormPage;
import pages.HomePage;
import sharedData.Hooks;

public class CompleteWebFormTest extends Hooks {

    @Test
    public void testMethod() {

        CompleteWebFormModel testData = new CompleteWebFormModel();
        testData.populateObject(DataConfig.COMPLETEWEBFORM_DATA);

        LoggerUtility.infoLog("Starting CompleteWebFormTest");

        LoggerUtility.infoLog("Navigating to HomePage and interacting with Complete Web Form");
        HomePage elementsPage = new HomePage(getDriver());
        elementsPage.clickCompleteWebForm();

        LoggerUtility.infoLog("Filling out Complete Web Form with provided data");
        CompleteWebFormPage completeWebFormPage = new CompleteWebFormPage(getDriver());
        completeWebFormPage.clickCompleteWebForm(testData);

        LoggerUtility.infoLog("Test completed successfully, quitting the driver.");
        getDriver().quit();
    }
}