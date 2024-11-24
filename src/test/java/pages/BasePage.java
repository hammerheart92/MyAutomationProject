package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;
    public TabMethods tabMethods;
    public LoggerUtility loggerUtility;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        loggerUtility = new LoggerUtility();
        elementMethods = new ElementMethods(this.driver);
        tabMethods = new TabMethods(this.driver);
        alertMethods = new AlertMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }
}
