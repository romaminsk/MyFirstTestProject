package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

    public RegistrationFormPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

}
