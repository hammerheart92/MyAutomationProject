package sharedData;

import BrowserService.ChromeService;
import BrowserService.EdgeService;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
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

    public void quitDriver(){
        driver.quit();
    }
}
