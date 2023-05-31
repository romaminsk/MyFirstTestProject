import org.example.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

//    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriver driver = DriverManager.getDriver();
        // Additional setup steps (e.g., maximize browser window, set timeouts, etc.)
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        WebDriver driver = DriverManager.getDriver();
        // Perform cleanup actions (e.g., close the browser, clear cookies, etc.)
        driver.quit();
    }
}
