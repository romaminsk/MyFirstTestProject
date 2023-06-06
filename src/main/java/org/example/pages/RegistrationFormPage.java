package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//tr[1]/td[1]/following-sibling::td")
    private WebElement userDataText;

    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getMobileNumberField() {
        return mobileNumberField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getUserDataText() {
        return userDataText;
    }
}
