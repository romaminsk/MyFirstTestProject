import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.steps.RegistrationFormSteps;
import org.example.utils.AllureListener;
import org.example.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class FormTest extends BaseTest {

    protected WebDriver driver;
    private RegistrationFormSteps registrationFormSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormSteps = new RegistrationFormSteps(driver);
    }

    @Epic(value = "Математика")
    @Feature(value = "Простые математические операции")
    @Story(value = "Сложение")
    @Link("https://demoqa.com/automation-practice-form")
    @Test(description = "Check registration form data",
            dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormData(UserData userData) {

        registrationFormSteps.fillForm(userData);

        Assert.assertTrue(registrationFormSteps.getUserDataText().contains(userData.getFirstName()));
    }

    @Link("https://demoqa.com/automation-practice-form")
    @Test(description = "Check registration form data separate",
            dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormSeparateData(UserData userData) {

//        registrationFormSteps.enterFirstName(userData.getFirstName());
        registrationFormSteps.enterLastName(userData.getLastName());
        registrationFormSteps.clickMaleRadioButton();
        registrationFormSteps.enterMobileNumber(userData.getMobileNumber());
        registrationFormSteps.clickSubmitButton();

        Assert.assertTrue(registrationFormSteps.getUserDataText().contains(userData.getFirstName()));
    }
}
