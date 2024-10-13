package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void clickAutocomplete(String addressValue, String streetValue, String street2Value, String cityValue,
                                  String stateValue, String zipCodeValue, String countryValue) {

        elementMethods.fillElement(addressElement, addressValue);
        loggerUtility.infoLog("The user fills the Address field with " + addressValue + " value");
        elementMethods.fillElement(streetAddressElement, streetValue);
        loggerUtility.infoLog("The user fills the Street address field with " + streetValue + " value");
        elementMethods.fillElement(streetAddress2Element, street2Value);
        loggerUtility.infoLog("The user fills the Street address 2 field with " + street2Value + " value");
        elementMethods.fillElement(cityElement, cityValue);
        loggerUtility.infoLog("The user fills the City field with " + cityValue + " value");
        elementMethods.fillElement(stateElement, stateValue);
        loggerUtility.infoLog("The user fills the State field with " + stateValue + " value");
        elementMethods.fillElement(zipCodeElement, zipCodeValue);
        loggerUtility.infoLog("The user fills the Zip Code field with " + zipCodeValue + " value");
        elementMethods.fillElement(countryElement, countryValue);
        loggerUtility.infoLog("The user fills the Country field with " + countryValue + " value");
    }
}


