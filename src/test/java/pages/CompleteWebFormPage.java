package pages;

import modelObject.CompleteWebFormModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CompleteWebFormPage extends BasePage {

    public CompleteWebFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameElement;
    @FindBy(id = "last-name")
    private WebElement lastNameElement;
    @FindBy(id = "job-title")
    private WebElement jobTitleElement;
    @FindBy(id = "radio-button-1")
    private WebElement highSchoolElement;
    @FindBy(id = "radio-button-2")
    private WebElement collegeElement;
    @FindBy(id = "radio-button-3")
    private WebElement gradSchoolElement;
    @FindBy(id = "checkbox-1")
    private WebElement maleElement;
    @FindBy(id = "checkbox-2")
    private WebElement femaleElement;
    @FindBy(id = "checkbox-3")
    private WebElement preferNotToSayElement;
    @FindBy(id = "select-menu")
    private WebElement yearsOfExperienceElement;
    @FindBy(id = "datepicker")
    private WebElement dateElement;
    @FindBy(linkText = "Submit")
    private WebElement submitElement;

    public void clickCompleteWebForm(CompleteWebFormModel testData) {

        elementMethods.fillElement(firstNameElement, testData.getFirstName());
        loggerUtility.infoLog("The user fills the First name field with " + testData.getFirstName() + " value");
        Assert.assertEquals(firstNameElement.getAttribute("value"),testData.getFirstName(),"First name value is not correct");

        elementMethods.fillElement(lastNameElement, testData.getLastName());
        loggerUtility.infoLog("The user fills the Last name field with " + testData.getLastName() + " value");
        Assert.assertEquals(lastNameElement.getAttribute("value"),testData.getLastName(),"Last name value is not correct");

        elementMethods.fillElement(jobTitleElement, testData.getJobTitle());
        loggerUtility.infoLog("The user fills the Job title field with " + testData.getJobTitle() + " value");
        Assert.assertEquals(jobTitleElement.getAttribute("value"),testData.getJobTitle(),"Job tile value is not correct");

        selectEducationLevel(testData.getEducationLevel());
        selectSex(testData.getSex());
        elementMethods.selectDropdownElement(yearsOfExperienceElement, testData.getYearsOfExperience());
        loggerUtility.infoLog("The user selects his Years of experience from the option list " + testData.getYearsOfExperience() + " value");
        String selectedExperience = elementMethods.getSelectedDropdownOption(yearsOfExperienceElement);
        Assert.assertEquals(selectedExperience, testData.getYearsOfExperience(),
                "Years of experience value is not correct!");

        // Send the date value directly to the date input field in the format MM/DD/YYYY
        String fullDate = testData.getMonth() + "/" + testData.getDay() + "/" + testData.getYear();
        elementMethods.fillElement(dateElement, fullDate); // Input the date in the field

        Assert.assertEquals(dateElement.getAttribute("value"), fullDate,
                "Date value is not correct!");

        loggerUtility.infoLog("The user selects the Date from the option list");
        elementMethods.waitVisibleElement(submitElement);
        elementMethods.clickElement(submitElement);
        loggerUtility.infoLog("The user Submits the form ");

        // Wait for the URL to change to confirmation page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/thanks"));
        loggerUtility.infoLog("Redirection to the confirmation page was successful.");

        // Wait for the confirmation message to be visible
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thanks for submitting your form']")));

        // Validate the confirmation message
        Assert.assertEquals(confirmationMessage.getText(), "Thanks for submitting your form",
                "The confirmation message is incorrect or not displayed.");
        loggerUtility.infoLog("The confirmation message validated successfully.");

    }

    public void selectEducationLevel(String educationLevel) {
        loggerUtility.infoLog("Selecting education level: " + educationLevel);
        switch (educationLevel.toLowerCase()) {
            case "high school":
                elementMethods.clickElement(highSchoolElement);
                Assert.assertTrue(highSchoolElement.isSelected(),"High School radio button is not selected!");
                loggerUtility.infoLog("Selected High School.");
                break;
            case "college":
                elementMethods.clickElement(collegeElement);
                Assert.assertTrue(collegeElement.isSelected(),"Collage radio button is not selected!");
                loggerUtility.infoLog("Selected Collage.");
                break;
            case "grad school":
                elementMethods.clickElement(gradSchoolElement);
                Assert.assertTrue(gradSchoolElement.isSelected(),"Grad School radio button is not selected!");
                loggerUtility.infoLog("Selected Grad School.");
                break;
            default:
                loggerUtility.errorLog("Invalid education level: " + educationLevel);
                Assert.fail("Invalid education level selected!");
        }
    }

    public void selectSex(String sex){
        loggerUtility.infoLog("Selecting sex: " + sex);
        switch (sex.toLowerCase()){
            case "male":
                elementMethods.clickElement(maleElement);
                Assert.assertTrue(maleElement.isSelected(),"Male checkbox is not selected!");
                loggerUtility.infoLog("Selected Male.");
                break;
            case "female":
                elementMethods.clickElement(femaleElement);
                Assert.assertTrue(femaleElement.isSelected(),"Female checkbox is not selected!");
                loggerUtility.infoLog("Selected Female.");
                break;
            case "prefer not to say":
                elementMethods.clickElement(preferNotToSayElement);
                Assert.assertTrue(preferNotToSayElement.isSelected(),"Prefer not to say checkbox is not selected!");
                loggerUtility.infoLog("Selected Prefer Not to Say.");
                break;
            default:
                loggerUtility.errorLog("Invalid sex option: " + sex);
                Assert.fail("Invalid sex option selected!");
        }
    }
}


