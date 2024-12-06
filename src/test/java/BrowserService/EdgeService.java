package BrowserService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class EdgeService implements BrowserService{
    private WebDriver driver;

    @Override
    public void openBrowser() {
        EdgeOptions options = prepareOptions();
        driver = new EdgeDriver(options);
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Override
    public EdgeOptions prepareOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new"); // Run in headless mode for CI
        options.addArguments("--no-sandbox"); // Required for GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Prevents memory issues
        options.addArguments("--window-size=1920,1080"); // Set a default window size
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
