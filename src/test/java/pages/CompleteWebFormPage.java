package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CompleteWebFormPage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public CompleteWebFormPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(linkText = "Complete Web Form")
    public WebElement completeWebFormMenuElement;
    @FindBy(id = "first-name")
    public WebElement firstNameElement;
    @FindBy(id = "last-name")
    public WebElement lastNameElement;
    @FindBy(id = "job-title")
    public WebElement jobTitleElement;
    @FindBy(id = "radio-button-1")
    public WebElement highSchoolElement;
    @FindBy(id = "radio-button-2")
    public WebElement collegeElement;
    @FindBy(id = "radio-button-3")
    public WebElement gradSchoolElement;
    @FindBy(id = "checkbox-1")
    public WebElement maleElement;
    @FindBy(id = "checkbox-2")
    public WebElement femaleElement;
    @FindBy(id = "checkbox-3")
    public WebElement preferNotToSayElement;
    @FindBy(id = "select-menu")
    public WebElement yearsOfExperienceElement;

    public void clickCompleteWebForm(String firstNameValue, String lastNameValue, String jobTitleValue, String educationLevel, String sex, String educationValue) {
        elementMethods.clickElement(completeWebFormMenuElement);
        elementMethods.fillElement(firstNameElement, firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(jobTitleElement, jobTitleValue);
        selectEducationLevel(educationLevel);
        selectSex(sex);
        elementMethods.clickElement(yearsOfExperienceElement);

    }

    public void selectEducationLevel(String educationLevel) {
        switch (educationLevel.toLowerCase()) {
            case "high school":
                elementMethods.clickElement(highSchoolElement);
                break;
            case "college":
                elementMethods.clickElement(collegeElement);
                break;
            case "grad school":
                elementMethods.clickElement(gradSchoolElement);
                break;
            default:
                System.out.println("Invalid education level: " + educationLevel);
        }
    }

    public void selectSex(String sex){
        switch (sex.toLowerCase()){
            case "male":
                elementMethods.clickElement(maleElement);
                break;
            case "female":
                elementMethods.clickElement(femaleElement);
                break;
            case "prefer not to say":
                elementMethods.clickElement(preferNotToSayElement);
                break;
            default:
                System.out.println("Invalid education level: " + sex);

        }

    }

    public void selectYearsOfExperience(String value) {
        Select select = new Select(yearsOfExperienceElement);
        select.selectByValue(value);  // Selectează după valoare (atributul value din <option>)
    }
}


