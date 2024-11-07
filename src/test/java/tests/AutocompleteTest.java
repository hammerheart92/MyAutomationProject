package tests;

import modelObject.AutocompleteModel;
import org.testng.annotations.Test;
import pages.AutocompletePage;
import pages.HomePage;
import sharedData.Hooks;

public class AutocompleteTest extends Hooks {

    @Test
    public void testMethod() {

        AutocompleteModel testData = new AutocompleteModel();
        testData.populateObject("src/main/resources/inputData/AutocompleteResource.json");

        loggerUtility.infoLog("Navigating to HomePage and interacting with Autocomplete");
        HomePage elementsPage = new HomePage(getDriver());
        elementsPage.clickAutocomplete();

        loggerUtility.infoLog("Filling out Autocomplete with provided data");
        AutocompletePage autocompletePage = new AutocompletePage(getDriver());
        autocompletePage.fillProcess(testData);
        autocompletePage.validateFilledFields(testData);

        loggerUtility.infoLog("Test completed successfully, quitting the driver.");
        getDriver().quit();
    }
}
