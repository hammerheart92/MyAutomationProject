package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(linkText = "Autocomplete")
    public WebElement autocompleteMenu;
    @FindBy(linkText = "Complete Web Form")
    public WebElement completeWebFormMenuElement;

    public void clickAutocomplete() {
        elementMethods.clickElement(autocompleteMenu);

    }

    public void clickCompleteWebForm() {
        elementMethods.clickElement(completeWebFormMenuElement);
    }

}
