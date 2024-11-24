package pages;

import modelObject.CompleteWebFormModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

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
        elementMethods.fillElement(lastNameElement, testData.getLastName());
        loggerUtility.infoLog("The user fills the Last name field with " + testData.getLastName() + " value");
        elementMethods.fillElement(jobTitleElement, testData.getJobTitle());
        loggerUtility.infoLog("The user fills the Job title field with " + testData.getJobTitle() + " value");
        selectEducationLevel(testData.getEducationLevel());
        selectSex(testData.getSex());
        elementMethods.selectDropdownElement(yearsOfExperienceElement, testData.getYearsOfExperience());
        loggerUtility.infoLog("The user selects his Years of experience from the option list " + testData.getYearsOfExperience() + " value");

        // Send the date value directly to the date input field in the format MM/DD/YYYY
        String fullDate = testData.getMonth() + "/" + testData.getDay() + "/" + testData.getYear();
        elementMethods.fillElement(dateElement, fullDate); // Input the date in the field
        loggerUtility.infoLog("The user selects the Date from the option list");
        elementMethods.clickElement(submitElement);
        loggerUtility.infoLog("The user Submits the form ");

    }

    public void selectEducationLevel(String educationLevel) {
        loggerUtility.infoLog("Selecting education level: " + educationLevel);
        switch (educationLevel.toLowerCase()) {
            case "high school":
                elementMethods.clickElement(highSchoolElement);
                loggerUtility.infoLog("Selected High School.");
                break;
            case "college":
                elementMethods.clickElement(collegeElement);
                loggerUtility.infoLog("Selected Collage.");
                break;
            case "grad school":
                elementMethods.clickElement(gradSchoolElement);
                loggerUtility.infoLog("Selected Grad School.");
                break;
            default:
                loggerUtility.errorLog("Invalid education level: " + educationLevel);
        }
    }

    public void selectSex(String sex){
        loggerUtility.infoLog("Selecting sex: " + sex);
        switch (sex.toLowerCase()){
            case "male":
                elementMethods.clickElement(maleElement);
                loggerUtility.infoLog("Selected Male.");
                break;
            case "female":
                elementMethods.clickElement(femaleElement);
                loggerUtility.infoLog("Selected Female.");
                break;
            case "prefer not to say":
                elementMethods.clickElement(preferNotToSayElement);
                loggerUtility.infoLog("Selected Prefer Not to Say.");
                break;
            default:
                loggerUtility.errorLog("Invalid sex option: " + sex);
        }
    }

    public void validateFilledFields(CompleteWebFormModel testData){
        SoftAssert softAssert = new SoftAssert();

        // Validate the text fields
        softAssert.assertEquals(firstNameElement.getAttribute("value"), testData.getFirstName(), "First name field value does not match");
        loggerUtility.infoLog("Validated the First Name field.");

        softAssert.assertEquals(lastNameElement.getAttribute("value"), testData.getLastName(), "Last name field value does not match");
        loggerUtility.infoLog("Validated the Last Name field.");

        softAssert.assertEquals(jobTitleElement.getAttribute("value"), testData.getJobTitle(), "Job title field value does not match");
        loggerUtility.infoLog("Validated the Job Title field.");

        // Validate the selected education level (radio buttons)
        switch (testData.getEducationLevel().toLowerCase()) {
            case "high school":
                softAssert.assertTrue(highSchoolElement.isSelected(), "High School should be selected.");
                break;
            case "college":
                softAssert.assertTrue(collegeElement.isSelected(), "College should be selected.");
                break;
            case "grad school":
                softAssert.assertTrue(gradSchoolElement.isSelected(), "Grad School should be selected.");
                break;
            default:
                loggerUtility.errorLog("Invalid education level specified in test data: " + testData.getEducationLevel());
        }
        loggerUtility.infoLog("Validated the Education Level field.");

        // Validate the selected gender (checkboxes)
        switch (testData.getSex().toLowerCase()) {
            case "male":
                softAssert.assertTrue(maleElement.isSelected(), "Male should be selected.");
                break;
            case "female":
                softAssert.assertTrue(femaleElement.isSelected(), "Female should be selected.");
                break;
            case "prefer not to say":
                softAssert.assertTrue(preferNotToSayElement.isSelected(), "Prefer Not to Say should be selected.");
                break;
            default:
                loggerUtility.errorLog("Invalid sex option specified in test data: " + testData.getSex());
        }
        loggerUtility.infoLog("Validated the Sex field.");

        // Validate the dropdown selection for Years of Experience
        String selectedExperience = elementMethods.getSelectedOption(yearsOfExperienceElement);
        softAssert.assertEquals(selectedExperience, testData.getYearsOfExperience(), "Years of Experience does not match.");
        loggerUtility.infoLog("Validated the Years of Experience field.");

        // Validate the date field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dateElement));
        String expectedDate = testData.getMonth() + "/" + testData.getDay() + "/" + testData.getYear();
        softAssert.assertEquals(dateElement.getAttribute("value"), expectedDate, "Date field value does not match.");
        loggerUtility.infoLog("Validated the Date field.");

        // Finalize all assertions
        softAssert.assertAll();

    }
}


