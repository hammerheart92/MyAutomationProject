package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import pages.CompleteWebFormPage;
import pages.ElementsPage;

import java.time.Duration;

public class CompleteWebFormTest {

    public WebDriver driver;

    @Test
    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickCompleteWebForm();

        CompleteWebFormPage completeWebFormPage = new CompleteWebFormPage(driver);
        completeWebFormPage.clickCompleteWebForm("Apaczai", "Laszlo", "Automation Testing", "High School",
                "Male", "5-9", "Feb","19", "2011");

        driver.quit();
    }

}