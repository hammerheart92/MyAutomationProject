package sharedData;

import BrowserService.ChromeService;
import BrowserService.EdgeService;
import org.openqa.selenium.WebDriver;

public class SharedData {

    private WebDriver driver;

    public void setUpDriver(){
        String browser = System.getProperty("browser");

        switch (browser){
            case "edge":
                EdgeService edgeService = new EdgeService();
                edgeService.openBrowser();
                driver = edgeService.getDriver();
                break;
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser();
                driver = chromeService.getDriver();
                break;

        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
