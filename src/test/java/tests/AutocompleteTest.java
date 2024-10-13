package tests;

import org.testng.annotations.Test;
import pages.AutocompletePage;
import pages.HomePage;
import sharedData.Hooks;

public class AutocompleteTest extends Hooks {

    @Test
    public void testMethod() {

        //continue json and data driven
        String addressValue = "Nr.9";
        String streetValue = "Ciucas Alley";
        String street2Value = "Ap.6";
        String cityValue = "Cluj-Napoca";
        String stateValue = "Cluj";
        String zipCodeValue = "540200";
        String countryValue = "Romania";

        loggerUtility.infoLog("Navigating to HomePage and interacting with Autocomplete");
        HomePage elementsPage = new HomePage(getDriver());
        elementsPage.clickAutocomplete();

        loggerUtility.infoLog("Filling out Autocomplete with provided data");
        AutocompletePage autocompletePage = new AutocompletePage(getDriver());
        autocompletePage.clickAutocomplete(addressValue, streetValue, street2Value, cityValue, stateValue, zipCodeValue, countryValue);

        loggerUtility.infoLog("Test completed successfully, quitting the driver.");
        getDriver().quit();

    }
}
