package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutocompletePage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public AutocompletePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(linkText = "Autocomplete")
    public WebElement autocompleteMenuElement;
    @FindBy(id = "autocomplete")
    public WebElement addressElement;
    @FindBy(id = "street_number")
    public WebElement streetAddressElement;
    @FindBy(id = "route")
    public WebElement streetAddress2Element;
    @FindBy(id = "locality")
    public WebElement cityElement;
    @FindBy(id = "administrative_area_level_1")
    public WebElement stateElement;
    @FindBy(id = "postal_code")
    public WebElement zipCodeElement;
    @FindBy(id = "country")
    public WebElement countryElement;

    public void clickAutocomplete(String addressValue, String streetValue, String street2Value, String cityValue,
                                  String stateValue, String zipCodeValue, String countryValue) {

        elementMethods.clickElement(autocompleteMenuElement);
        elementMethods.fillElement(addressElement, addressValue);
        elementMethods.fillElement(streetAddressElement, streetValue);
        elementMethods.fillElement(streetAddress2Element, street2Value);
        elementMethods.fillElement(cityElement, cityValue);
        elementMethods.fillElement(stateElement, stateValue);
        elementMethods.fillElement(zipCodeElement, zipCodeValue);
        elementMethods.fillElement(countryElement, countryValue);
    }
}


