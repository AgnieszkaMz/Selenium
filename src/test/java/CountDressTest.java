import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CountDressTest {
    WebDriver driver;
    String url = "http://automationpractice.com/index.php";
    WebElement searchInput;
    WebElement searchButton;
    List<WebElement> dresses;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver100.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void countDress () {
        driver.get(url);
        searchInput = driver.findElement(By.id ("search_query_top"));
        searchInput.sendKeys("Dress");
        searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("heading-counter"))));
        dresses = driver.findElements(By.xpath("//div[@class='product-image-container']")); //co to jest xpath? tutorial z przypadkami
        Assert.assertEquals(dresses.size(),7);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
