package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage{

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;
    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetButton;

    public void chooseFile(){

        String filePath = System.getProperty("user.dir") + "/src/main/resources/testFile.txt";
        fileInput.sendKeys(filePath);
        loggerUtility.infoLog("The user selected a file to upload: " + filePath);
    }

    public void resetFile(){
        elementMethods.clickElement(resetButton);
        loggerUtility.infoLog("The user selected the reset button: " + resetButton);
    }
}
