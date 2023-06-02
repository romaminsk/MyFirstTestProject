import org.example.driver.DriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    protected WebDriver driver;
    private RegistrationFormPage registrationFormPage;

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"Roman"}, {"Andrew"}};
    }

    @BeforeClass
    public void startPage() {
        driver = DriverManager.getDriver();
        registrationFormPage = new RegistrationFormPage(driver);
    }

//    @DataProvider(name = "data-provider")
//    public Object[][] dpMethod() {
//        return new Object[][]{
//                {new UserData("John")},
//                {new UserData("Anna")}
//        };
//    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormData(String name) {
        registrationFormPage.enterFirstName(name);
        registrationFormPage.enterLastName("Ivanov");
        registrationFormPage.clickMaleRadioButton();
        registrationFormPage.enterMobileNumber("1111111111");
        registrationFormPage.clickSubmitButton();

        Assert.assertTrue(registrationFormPage.getUserDataText().contains(name));
    }

}
