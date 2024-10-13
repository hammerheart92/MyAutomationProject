package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void clickCompleteWebForm(String firstNameValue, String lastNameValue, String jobTitleValue, String educationLevel, String sex,
                                     String yearsOfExperienceValue, String monthSelectValue, String dayValue, String yearValue) {

        elementMethods.fillElement(firstNameElement, firstNameValue);
        loggerUtility.infoLog("The user fills the First name field with " + firstNameValue + " value");
        elementMethods.fillElement(lastNameElement, lastNameValue);
        loggerUtility.infoLog("The user fills the Last name field with " + lastNameValue + " value");
        elementMethods.fillElement(jobTitleElement, jobTitleValue);
        loggerUtility.infoLog("The user fills the Job title field with " + jobTitleValue + " value");
        selectEducationLevel(educationLevel);
        selectSex(sex);
        elementMethods.selectDropdownElement(yearsOfExperienceElement, yearsOfExperienceValue);
        loggerUtility.infoLog("The user selects his Years of experience from the option list " + yearsOfExperienceValue + " value");

        // Send the date value directly to the date input field in the format MM/DD/YYYY
        String fullDate = monthSelectValue + "/" + dayValue + "/" + yearValue;
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
}


