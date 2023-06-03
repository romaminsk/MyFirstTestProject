import org.example.driver.DriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormPage = new RegistrationFormPage(driver);
    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormData(String name) {

        registrationFormPage.enterFirstName(name);
        registrationFormPage.enterLastName("Ivanov");
        registrationFormPage.clickMaleRadioButton();
        registrationFormPage.enterMobileNumber("1111111111");
        registrationFormPage.clickSubmitButton();

        WebElement userDataText = driver.findElement(By.xpath("//tr[1]/td[1]/following-sibling::td"));

        Assert.assertTrue(userDataText.getText().contains("Roman Ivanov"));
    }
}
