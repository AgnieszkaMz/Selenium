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

public class IsEnabledTest {
    WebDriver driver;
    String url = "http://automationpractice.com/index.php";
    WebElement signInButton;
    WebElement emailInput;
    WebElement passwordInput;
    WebElement submitButton;
    boolean isSignOutEnabled;



    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver100.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void doLogin() {
        driver.get(url);
        signInButton = driver.findElement(By.className("login"));
        signInButton.click();
        emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("poczta@poczta.pl");
        passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");
        submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("logout"))));
        isSignOutEnabled = driver.findElement(By.className("logout")).isEnabled();
        Assert.assertTrue(isSignOutEnabled);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
