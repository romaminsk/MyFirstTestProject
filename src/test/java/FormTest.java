import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private RegistrationFormPage registrationFormPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://demoqa.com/automation-practice-form");
        registrationFormPage = new RegistrationFormPage(driver, wait);
    }

    @Test(priority = 1)
    public void checkRegistrationFormData() {

        registrationFormPage.enterFirstName("Roman");
        registrationFormPage.enterLastName("Ivanov");

        WebElement maleRadioButton = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));
        maleRadioButton.click();

        WebElement mobileNumberField = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        mobileNumberField.sendKeys("1111111111");

        WebElement dropDown = driver.findElement(By.id("react-select-3-input"));
        dropDown.sendKeys("NCR");
        dropDown.sendKeys(Keys.RETURN);

        WebElement uploadPictureInput = driver.findElement(By.id("uploadPicture"));
        uploadPictureInput.sendKeys("C:\\Users\\User\\IdeaProjects\\MyFirstTestProject\\src\\main\\resources\\1.png");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitButton.click();

        WebElement userDataText = driver.findElement(By.xpath("//tr[1]/td[1]/following-sibling::td"));

        Assert.assertTrue(userDataText.getText().contains("Roman Ivanov"));
    }

    @Test(priority = 2)
    public void checkRegistrationFormData2() {

        registrationFormPage.enterFirstName("Roman");
        registrationFormPage.enterLastName("Ivanov");

        WebElement userDataText = driver.findElement(By.xpath("//tr[1]/td[1]/following-sibling::td"));

        Assert.assertTrue(userDataText.getText().contains("Roman Ivanov"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
