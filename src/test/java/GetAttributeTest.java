import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://donerking.by/delivery");

        WebElement searchTextBox= driver.findElement(By.id("street"));
        WebElement building= driver.findElement(By.id("building"));
        WebElement searchQuery= driver.findElement(By.id("search-query"));
        WebElement deliveryStatus= driver.findElement(By.id("delivery_status"));

        searchTextBox.sendKeys("qqqqq");
        building.sendKeys("111");
        searchQuery.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String classValue = deliveryStatus.getAttribute("class");
        String outerHtml = deliveryStatus.getAttribute("outerHTML");

        System.out.println("Class value: " + classValue);
        System.out.println("Outer HTML: " + outerHtml);
    }
}
