package pages;


import loggerUtility.LoggerUtility;
import modelObject.AutocompleteModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class AutocompletePage extends BasePage {

    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "autocomplete")
    private WebElement addressElement;
    @FindBy(id = "street_number")
    private WebElement streetAddressElement;
    @FindBy(id = "route")
    private WebElement streetAddress2Element;
    @FindBy(id = "locality")
    private WebElement cityElement;
    @FindBy(id = "administrative_area_level_1")
    private WebElement stateElement;
    @FindBy(id = "postal_code")
    private WebElement zipCodeElement;
    @FindBy(id = "country")
    private WebElement countryElement;

    public void fillProcess(AutocompleteModel testData) {

        elementMethods.fillElement(addressElement, testData.getAddressValue());
        LoggerUtility.infoLog("The user fills the Address field with " + testData.getAddressValue() + " value");

        elementMethods.fillElement(streetAddressElement, testData.getStreetValue());
        LoggerUtility.infoLog("The user fills the Street address field with " + testData.getStreetValue() + " value");

        elementMethods.fillElement(streetAddress2Element, testData.getStreet2Value());
        LoggerUtility.infoLog("The user fills the Street address 2 field with " + testData.getStreet2Value() + " value");

        elementMethods.fillElement(cityElement, testData.getCityValue());
        LoggerUtility.infoLog("The user fills the City field with " + testData.getCityValue() + " value");

        elementMethods.fillElement(stateElement, testData.getStateValue());
        LoggerUtility.infoLog("The user fills the State field with " + testData.getStateValue() + " value");

        elementMethods.fillElement(zipCodeElement, testData.getZipCodeValue());
        LoggerUtility.infoLog("The user fills the Zip Code field with " + testData.getZipCodeValue() + " value");

        elementMethods.fillElement(countryElement, testData.getCountryValue());
        LoggerUtility.infoLog("The user fills the Country field with " + testData.getCountryValue() + " value");
    }

    public void validateFilledFields(AutocompleteModel testData) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(addressElement.getAttribute("value"), testData.getAddressValue(), "Address field value does not match");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getAddressValue() + " value in the table content");

        softAssert.assertEquals(streetAddressElement.getAttribute("value"), testData.getStreetValue(), "Street address field value does not match");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getStreetValue() + " value in the table content");

        softAssert.assertEquals(streetAddress2Element.getAttribute("value"), testData.getStreet2Value(), "Street address 2 field value does not match");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getStreet2Value() + " value in the table content");

        softAssert.assertEquals(cityElement.getAttribute("value"), testData.getCityValue(), "City field value does not match");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getCityValue() + " value in the table content");

        softAssert.assertEquals(stateElement.getAttribute("value"), testData.getStateValue(), "State field value does not match");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getStateValue() + " value in the table content");

        softAssert.assertEquals(zipCodeElement.getAttribute("value"), testData.getZipCodeValue(), "Zip Code field value does not match");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getZipCodeValue() + " value in the table content");

        softAssert.assertEquals(countryElement.getAttribute("value"), testData.getCountryValue(), "Country field value does not match");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getCountryValue() + " value in the table content");

        softAssert.assertAll();
        LoggerUtility.infoLog("All asserts are collated");
    }
}


