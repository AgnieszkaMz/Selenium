import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    WebElement emailInput;
    WebElement passwordInput;
    WebElement submitButton;
    String title;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver100.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void doLogin() {
        driver.get(url);
        emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("poczta@poczta.pl");
        passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("password");
        submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
        title = driver.findElement(By.className("info-account")).getText();
        System.out.println(title);
        Assert.assertEquals(title,"Welcome to your account. Here you can manage all of your personal information and orders.");

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

// ustalony porządek pisania skryptu,
// definiowanie WebElementów aplikacji (login, hasło, button),
// wyciągniecie wartości tekstowej -> get.text,
// zakończenie testu asercją