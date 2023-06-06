import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.steps.RegistrationFormSteps;
import org.example.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    protected WebDriver driver;
    private RegistrationFormSteps registrationFormSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormSteps = new RegistrationFormSteps(driver);
    }

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormData(UserData userData) {

        registrationFormSteps.fillForm(userData);

        Assert.assertTrue(registrationFormSteps.getUserDataText().contains("Roman Ivanov"));
    }

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormSeparateData(UserData userData) {

        registrationFormSteps.enterFirstName(userData.getFirstName());
        registrationFormSteps.enterLastName(userData.getLastName());
        registrationFormSteps.clickMaleRadioButton();
        registrationFormSteps.enterMobileNumber(userData.getMobileNumber());
        registrationFormSteps.clickSubmitButton();

        Assert.assertTrue(registrationFormSteps.getUserDataText().contains("Roman Ivanov"));
    }
}
