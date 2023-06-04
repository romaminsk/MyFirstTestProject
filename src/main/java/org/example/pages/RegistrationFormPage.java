package org.example.pages;

import org.example.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RegistrationFormPage extends BasePage {

    protected WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//label[@for=\"gender-radio-1\"]")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        Waiters.waitForVisibility(firstNameField);
        log.info("Enter first name");
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        log.info("Enter last name");
        lastNameField.sendKeys(lastName);
    }

    public void clickMaleRadioButton() {
        log.info("Click male radio button");
        maleRadioButton.click();
    }

    public void enterMobileNumber(String mobileNumber) {
        log.info("Enter mobile number");
        mobileNumberField.sendKeys(mobileNumber);
    }

    public void clickSubmitButton() {
        log.info("Click submit button");
        submitButton.click();
    }
}
