import org.example.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
