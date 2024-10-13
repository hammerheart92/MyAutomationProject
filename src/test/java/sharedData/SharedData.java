package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    public void setUpDriver(){
        driver = new EdgeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
