package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import pages.AutocompletePage;
import pages.ElementsPage;

import java.time.Duration;

public class AutocompleteTest {

    public WebDriver driver;

    @Test
    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickAutocomplete();

        AutocompletePage autocompletePage = new AutocompletePage(driver);
        autocompletePage.clickAutocomplete("Nr.9", "Aleea Ciucas", "Ap.6", "Cluj-Napoca",
                "Cluj", "540200", "Romania");

        driver.quit();

    }
}
