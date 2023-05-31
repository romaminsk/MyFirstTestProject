import org.example.driver.DriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class FormTest extends BaseTest {

    static ResourceBundle bundle = ResourceBundle.getBundle("test_framework");
    private final String URL = bundle.getString("path_to_url");

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"Roman"}, {"Ivanov"}};
    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormData(String name) {
        WebDriver driver = DriverManager.getDriver();
        RegistrationFormPage registrationFormPage;
        driver.get(URL);

        registrationFormPage = new RegistrationFormPage(driver);

        registrationFormPage.enterFirstName(name);
        registrationFormPage.enterLastName("Ivanov");
        registrationFormPage.clickMaleRadioButton();
        registrationFormPage.enterMobileNumber("1111111111");
        registrationFormPage.clickSubmitButton();

        Assert.assertTrue(registrationFormPage.getUserDataText().contains(name));
    }

}
