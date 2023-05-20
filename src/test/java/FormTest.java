import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FormTest {

    @Test
    public void checkRegistrationFormData() {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }
}
