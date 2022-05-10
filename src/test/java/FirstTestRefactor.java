import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestRefactor {
    private WebDriver driver;
    String pageTitle = "";
    String url = "http://automationpractice.com/index.php";
    String expectedTitle = "My store";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver100.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void checkPageTitle() {
        driver.get(url);
        pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, expectedTitle, "Wartość oczekiwana jest różna od wartości pobranej");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}
