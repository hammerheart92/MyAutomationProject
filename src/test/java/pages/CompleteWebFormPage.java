package pages;

import loggerUtility.LoggerUtility;
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
        LoggerUtility.infoLog("The user fills the First name field with " + testData.getFirstName() + " value");
        Assert.assertEquals(firstNameElement.getAttribute("value"),testData.getFirstName(),"First name value is not correct");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getFirstName() + " value of the table content");

        elementMethods.fillElement(lastNameElement, testData.getLastName());
        LoggerUtility.infoLog("The user fills the Last name field with " + testData.getLastName() + " value");
        Assert.assertEquals(lastNameElement.getAttribute("value"),testData.getLastName(),"Last name value is not correct");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getLastName() + " value of the table content");

        elementMethods.fillElement(jobTitleElement, testData.getJobTitle());
        LoggerUtility.infoLog("The user fills the Job title field with " + testData.getJobTitle() + " value");
        Assert.assertEquals(jobTitleElement.getAttribute("value"),testData.getJobTitle(),"Job tile value is not correct");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getJobTitle() + " value of the table content");

        selectEducationLevel(testData.getEducationLevel());
        selectSex(testData.getSex());
        elementMethods.selectDropdownElement(yearsOfExperienceElement, testData.getYearsOfExperience());
        LoggerUtility.infoLog("The user selects his Years of experience from the option list " + testData.getYearsOfExperience() + " value");
        String selectedExperience = elementMethods.getSelectedDropdownOption(yearsOfExperienceElement);
        Assert.assertEquals(selectedExperience, testData.getYearsOfExperience(),
                "Years of experience value is not correct!");
        LoggerUtility.infoLog("Assertion passed: Years of experience value is correct.");

        String fullDate = testData.getMonth() + "/" + testData.getDay() + "/" + testData.getYear();
        LoggerUtility.infoLog("Constructed full date: " + fullDate);
        elementMethods.fillElement(dateElement, fullDate);
        LoggerUtility.infoLog("The user inputs the date value: " + fullDate + " into the date field.");

        Assert.assertEquals(dateElement.getAttribute("value"), fullDate,
                "Date value is not correct!");
        LoggerUtility.infoLog("Assertion passed: Date field value is correct.");

        LoggerUtility.infoLog("The user selects the Date from the option list");
        elementMethods.waitVisibleElement(submitElement);
        elementMethods.clickElement(submitElement);
        LoggerUtility.infoLog("The user Submits the form ");

        // Wait for the URL to change to confirmation page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/thanks"));
        LoggerUtility.infoLog("Redirection to the confirmation page was successful.");

        // Wait for the confirmation message to be visible
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thanks for submitting your form']")));

        // Validate the confirmation message
        Assert.assertEquals(confirmationMessage.getText(), "Thanks for submitting your form",
                "The confirmation message is incorrect or not displayed.");
        LoggerUtility.infoLog("The confirmation message validated successfully.");
        LoggerUtility.infoLog("Assertion passed: Confirmation message is validated successfully.");

    }

    public void selectEducationLevel(String educationLevel) {
        LoggerUtility.infoLog("Selecting education level: " + educationLevel);
        switch (educationLevel.toLowerCase()) {
            case "high school":
                elementMethods.clickElement(highSchoolElement);
                Assert.assertTrue(highSchoolElement.isSelected(),"High School radio button is not selected!");
                LoggerUtility.infoLog("Assertion passed: High School radio button is selected.");
                LoggerUtility.infoLog("Selected High School.");
                break;
            case "college":
                elementMethods.clickElement(collegeElement);
                Assert.assertTrue(collegeElement.isSelected(),"Collage radio button is not selected!");
                LoggerUtility.infoLog("Assertion passed: College radio button is selected.");
                LoggerUtility.infoLog("Selected Collage.");
                break;
            case "grad school":
                elementMethods.clickElement(gradSchoolElement);
                Assert.assertTrue(gradSchoolElement.isSelected(),"Grad School radio button is not selected!");
                LoggerUtility.infoLog("Assertion passed: Grad School radio button is selected.");
                LoggerUtility.infoLog("Selected Grad School.");
                break;
            default:
                LoggerUtility.errorLog("Invalid education level: " + educationLevel);
                Assert.fail("Invalid education level selected!");
        }
    }

    public void selectSex(String sex){
        LoggerUtility.infoLog("Selecting sex: " + sex);
        switch (sex.toLowerCase()){
            case "male":
                elementMethods.clickElement(maleElement);
                Assert.assertTrue(maleElement.isSelected(),"Male checkbox is not selected!");
                LoggerUtility.infoLog("Assertion passed: Male checkbox is selected.");
                LoggerUtility.infoLog("Selected Male.");
                break;
            case "female":
                elementMethods.clickElement(femaleElement);
                Assert.assertTrue(femaleElement.isSelected(),"Female checkbox is not selected!");
                LoggerUtility.infoLog("Assertion passed: Female checkbox is selected.");
                LoggerUtility.infoLog("Selected Female.");
                break;
            case "prefer not to say":
                elementMethods.clickElement(preferNotToSayElement);
                Assert.assertTrue(preferNotToSayElement.isSelected(),"Prefer not to say checkbox is not selected!");
                LoggerUtility.infoLog("Assertion passed: Prefer Not to Say checkbox is selected.");
                LoggerUtility.infoLog("Selected Prefer Not to Say.");
                break;
            default:
                LoggerUtility.errorLog("Invalid sex option: " + sex);
                Assert.fail("Invalid sex option selected!");
        }
    }
}


