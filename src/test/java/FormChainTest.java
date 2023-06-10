import io.qameta.allure.*;
import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.pages.RegistrationFormChainPage;
import org.example.utils.AllureListener;
import org.example.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class FormChainTest extends BaseTest {

    protected WebDriver driver;
    private RegistrationFormChainPage registrationFormPage;

    @BeforeClass
    public void startPage() {
        driver = DriverManager.getDriver();
        registrationFormPage = new RegistrationFormChainPage(driver);
    }

    @Issue("Broken data")
    @Flaky
    @Severity(value = SeverityLevel.BLOCKER)
    @Description("Check registration form data chain {userData}")
    @Link("https://demoqa.com/automation-practice-form")
    @Owner(value = "Пупкин Валерий Иванович")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormDataChain(UserData userData) {

        String userDataText = registrationFormPage
//                .enterFirstName(userData.getFirstName())
                .enterLastName(userData.getLastName())
                .clickMaleRadioButton()
                .enterMobileNumber("1111111111")
                .clickSubmitButton()
                .getUserDataText();

        Assert.assertTrue(userDataText.contains(userData.getFirstName()));
    }
}
