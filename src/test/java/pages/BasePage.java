package pages;

import helpMethods.ElementMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public LoggerUtility loggerUtility;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        loggerUtility = new LoggerUtility();
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }
}
