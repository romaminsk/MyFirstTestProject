package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RegistrationFormSteps {

    private RegistrationFormPage registrationFormPage;

    public RegistrationFormSteps(WebDriver driver) {
        registrationFormPage = new RegistrationFormPage(driver);
    }

    @Step("Enter first name")
    public void enterFirstName(String firstName) {
        log.info("Enter first name");
        registrationFormPage.getFirstNameField().sendKeys(firstName);
    }

    @Step("Enter last name")
    public void enterLastName(String lastName) {
        log.info("Enter last name");
        registrationFormPage.getLastNameField().sendKeys(lastName);
    }

    @Step("Click male radio button")
    public void clickMaleRadioButton() {
        log.info("Click male radio button");
        registrationFormPage.getMaleRadioButton().click();
    }

    @Step("Enter mobile number")
    public void enterMobileNumber(String mobileNumber) {
        log.info("Enter mobile number");
        registrationFormPage.getMobileNumberField().sendKeys(mobileNumber);
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        log.info("Click submit button");
        registrationFormPage.getSubmitButton().click();
    }

    @Step("Get user data text")
    public String getUserDataText() {
        log.info("Get user data text");
        return registrationFormPage.getUserDataText().getText();
    }
}
