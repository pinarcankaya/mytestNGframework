package officehours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day01_AppleTest {
    private WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup(); // driver oluşturmadan önce setup işlemi gerçekleştirelim
        WebDriver driver = new ChromeDriver(); // driver objesi oluşturalım
        driver.manage().window().maximize();  // tüm ekranı kaplasın
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // driver'a bekleme süresi ekledik.
        driver.get("https://www.apple.com/"); // apple.com'a git
    }
    @Test
    public void ilkUrunTest(){

    }



    @AfterTest
    public void tearDown(){
     //  driver.quit();
        System.out.println("test bitti");
    }
}
