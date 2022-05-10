import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver100.exe");

        String pageTitle = "";
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        pageTitle = driver.getTitle();

        if(pageTitle.equals("My Store")) {
            System.out.println("Test is correct");
        }
        else{
            System.out.println("Test is incorrect");
        }

    }
}
