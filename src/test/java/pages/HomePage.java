package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Autocomplete")
    private WebElement autocompleteMenu;
    @FindBy(linkText = "Complete Web Form")
    private WebElement completeWebFormMenu;
    @FindBy(linkText = "File Upload")
    private WebElement fileUploadMenu;
    @FindBy(linkText = "Switch Window")
    private WebElement switchWindowMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAutocomplete() {
        elementMethods.clickElement(autocompleteMenu);
        LoggerUtility.infoLog("The user click on Autocomplete menu");
    }

    public void clickCompleteWebForm() {
        elementMethods.clickElement(completeWebFormMenu);
        LoggerUtility.infoLog("The user click on Complete Web Form menu ");
    }

    public void clickFileUpload(){
        elementMethods.clickElement(fileUploadMenu);
        LoggerUtility.infoLog("The user click on File Upload menu ");
    }

    public void  clickSwitchWindow(){
        elementMethods.clickElement(switchWindowMenu);
        LoggerUtility.infoLog("The user clicks on Switch Windows menu");
    }
}
