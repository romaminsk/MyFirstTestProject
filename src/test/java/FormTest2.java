import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.pages.RegistrationFormChainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTest2 extends BaseTest {

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
                {new UserData("John")},
                {new UserData("Anna")}
        };
    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormData2(UserData userData) {
        String firstName = userData.getFirstName();
        String lastName = "Doe";
        String mobileNumber = "1234567890";

        String userDataText = registrationFormPage
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .clickMaleRadioButton()
                .enterMobileNumber(mobileNumber)
                .clickSubmitButton()
                .getUserDataText();

        Assert.assertTrue(userDataText.contains(firstName));
    }

}
