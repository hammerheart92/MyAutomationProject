package tests;

import org.testng.annotations.Test;
import pages.CompleteWebFormPage;
import pages.HomePage;
import sharedData.Hooks;

public class CompleteWebFormTest extends Hooks {

    @Test
    public void testMethod() {
        loggerUtility.infoLog("Starting CompleteWebFormTest");

        String firstName = "Apaczai";
        String lastName = "Laszlo";
        String jobTitle = "Automation Testing";
        String educationLevel = "High School";
        String sex = "Male";
        String yearsOfExperience = "5-9";
        String month = "Feb";
        String day = "19";
        String year = "2011";

        loggerUtility.infoLog("Navigating to HomePage and interacting with Complete Web Form");
        HomePage elementsPage = new HomePage(getDriver());
        elementsPage.clickCompleteWebForm();

        loggerUtility.infoLog("Filling out Complete Web Form with provided data");
        CompleteWebFormPage completeWebFormPage = new CompleteWebFormPage(getDriver());
        completeWebFormPage.clickCompleteWebForm(firstName, lastName, jobTitle, educationLevel, sex,
                yearsOfExperience, month, day, year);

        loggerUtility.infoLog("Test completed successfully, quitting the driver.");
        getDriver().quit();
    }

}