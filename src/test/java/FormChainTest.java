import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.pages.RegistrationFormChainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormChainTest extends BaseTest {

    protected WebDriver driver;
    private RegistrationFormChainPage registrationFormPage;

    @BeforeClass
    public void startPage() {
        driver = DriverManager.getDriver();
        registrationFormPage = new RegistrationFormChainPage(driver);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {new UserData("John", "Doe")},
                {new UserData("Anna", "Petrova")}
        };
    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormDataChain(UserData userData) {

        String userDataText = registrationFormPage
                .enterFirstName(userData.getFirstName())
                .enterLastName(userData.getLastName())
                .clickMaleRadioButton()
                .enterMobileNumber("1111111111")
                .clickSubmitButton()
                .getUserDataText();

        Assert.assertTrue(userDataText.contains(userData.getFirstName()));
    }
}
