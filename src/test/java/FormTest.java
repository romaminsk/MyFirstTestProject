import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTest {

    private RegistrationFormPage registrationFormPage;

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        registrationFormPage = new RegistrationFormPage(driver, wait);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void checkRegistrationFormData() {

        registrationFormPage.setFirstName("Roman");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        lastNameField.sendKeys("Ivanov");

        WebElement maleRadioButton = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));
        maleRadioButton.click();

        WebElement mobileNumberField = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        mobileNumberField.sendKeys("1111111111");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitButton.click();

        WebElement userDataText = driver.findElement(By.xpath("//tr[1]/td[1]/following-sibling::td"));

        Assert.assertTrue(userDataText.getText().contains("Roman Ivanov"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
