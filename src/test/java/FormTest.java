import org.example.driver.DriverManager;
import org.example.steps.RegistrationFormSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    protected WebDriver driver;
    private RegistrationFormSteps registrationFormSteps;

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"Roman"}, {"Andrew"}};
    }

    @BeforeClass
    public void startPage() {
        driver = DriverManager.getDriver();
        registrationFormSteps = new RegistrationFormSteps(DriverManager.getDriver());
    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormData(String name) {
        registrationFormSteps.enterFirstName(name);
        registrationFormSteps.enterLastName("Ivanov");
        registrationFormSteps.clickMaleRadioButton();
        registrationFormSteps.enterMobileNumber("1111111111");
        registrationFormSteps.clickSubmitButton();

        Assert.assertTrue(registrationFormSteps.getUserDataText().contains(name));
    }

}
