package tests;

import configFiles.DataConfig;
import loggerUtility.LoggerUtility;
import modelObject.AutocompleteModel;
import org.testng.annotations.Test;
import pages.AutocompletePage;
import pages.HomePage;
import sharedData.Hooks;

public class AutocompleteTest extends Hooks {

    @Test
    public void testMethod() {

        AutocompleteModel testData = new AutocompleteModel();
        testData.populateObject(DataConfig.AUTOCOMPLETE_DATA);

        LoggerUtility.infoLog("Navigating to HomePage and interacting with Autocomplete");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAutocomplete();

        LoggerUtility.infoLog("Filling out Autocomplete with provided data");
        AutocompletePage autocompletePage = new AutocompletePage(getDriver());
        autocompletePage.fillProcess(testData);
        autocompletePage.validateFilledFields(testData);

        LoggerUtility.infoLog("Test completed successfully, quitting the driver.");
        getDriver().quit();
    }
}
